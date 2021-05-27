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

import idat.edu.pe.daa2.jpa.modelo.Funciones;
import idat.edu.pe.daa2.jpa.servicios.FuncionesServicio;



@Controller
@RequestMapping("/funciones")
public class FuncionesWebController {

	
	
	@Autowired
	private FuncionesServicio servicio;

	
	@RequestMapping("/listarTodo")
	public String listarFunciones(Model model) {
		List<Funciones> listaFunciones = servicio.buscarTodo();
		model.addAttribute("listaFunciones", listaFunciones);
		return "/moduloFunciones/listarTodo";
	}

	
	@RequestMapping("/nuevo")
	public String nuevaFuncion(Model model) {
		Funciones funcion = new Funciones();
		model.addAttribute("funcion", funcion);
		return "/moduloFunciones/nuevaFuncion";
	}
	
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearFuncion(@ModelAttribute("funcion") Funciones funcion) {
		servicio.crear(funcion);
	    return "redirect:/funciones/listarTodo";
	}
	
	
	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarFuncion(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloFunciones/editarFuncion");
	    Funciones funcion = servicio.buscarPorID(id);
	    mav.addObject("funcion", funcion);
	     
	    return mav;
	}
	
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarFuncion(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);;
	    return "redirect:/funciones/listarTodo";       
	}

}
