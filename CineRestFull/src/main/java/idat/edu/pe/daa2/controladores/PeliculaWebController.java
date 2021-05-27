package idat.edu.pe.daa2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.daa2.jpa.modelo.Pelicula;
import idat.edu.pe.daa2.jpa.servicios.PeliculasServicio;

@Controller
@RequestMapping("/peliculas")
public class PeliculaWebController {

	@Autowired
	private PeliculasServicio servicio;

	
	@RequestMapping("/listarTodo")
	public String listarPeliculas(Model model) {
		List<Pelicula> listaPeliculas = servicio.buscarTodo();
		model.addAttribute("listaPeliculas", listaPeliculas);
		return "/moduloPeliculas/listarTodo";
	}

	
	@RequestMapping("/nuevo")
	public String nuevaPelicula(Model model) {
		Pelicula pelicula = new Pelicula();
		model.addAttribute("pelicula", pelicula);
		return "/moduloPeliculas/nuevaPelicula";
	}
	
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearPelicula(@ModelAttribute("pelicula") Pelicula pelicula) {
		servicio.crear(pelicula);
	    return "redirect:/peliculas/listarTodo";
	}
	
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarPelicula(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloPeliculas/editarPelicula");
	    Pelicula pelicula = servicio.buscarPorID(id);
	    mav.addObject("pelicula", pelicula);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarPelicula(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);;
	    return "redirect:/peliculas/listarTodo";       
	}

}
