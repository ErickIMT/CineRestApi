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

import idat.edu.pe.daa2.jpa.modelo.Sala;
import idat.edu.pe.daa2.jpa.servicios.SalaServicio;

@Controller
@RequestMapping("/salas")
public class SalaWebController {

	@Autowired
	private SalaServicio servicio;

	
	@RequestMapping("/listarTodo")
	public String listarSalas(Model model) {
		List<Sala> listaSalas = servicio.buscarTodo();
		model.addAttribute("listaSalas", listaSalas);
		return "/moduloSalas/listarTodo";
	}

	
	@RequestMapping("/nuevo")
	public String nuevaSala(Model model) {
		Sala sala = new Sala();
		model.addAttribute("sala", sala);
		return "/moduloSalas/nuevaSala";
	}
	
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearSala(@ModelAttribute("sala") Sala sala) {
		servicio.crear(sala);
	    return "redirect:/salas/listarTodo";
	}
	
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarSala(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloSalas/editarSala");
	    Sala sala = servicio.buscarPorID(id);
	    mav.addObject("sala", sala);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarSala(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);;
	    return "redirect:/salas/listarTodo";       
	}

}
