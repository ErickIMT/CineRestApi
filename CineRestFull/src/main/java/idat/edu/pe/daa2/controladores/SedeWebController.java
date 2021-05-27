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

import idat.edu.pe.daa2.jpa.modelo.Sede;
import idat.edu.pe.daa2.jpa.servicios.SedeServicio;


@Controller
@RequestMapping("/sedes")
public class SedeWebController {
	@Autowired
	private SedeServicio servicio;

	@RequestMapping("/listarTodo")
	public String listarSedes(Model model) {
		List<Sede> listaSedes = servicio.buscarTodo();
		model.addAttribute("listaSedes", listaSedes);
		return "/moduloSedes/listarTodo";
	}

	@RequestMapping("/nuevo")
	public String nuevaSede(Model model) {
		Sede sede = new Sede();
		model.addAttribute("sede", sede);
		return "/moduloSedes/nuevaSede";
	}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearSede(@ModelAttribute("sede") Sede sede) {
		servicio.crear(sede);
		return "redirect:/sedes/listarTodo";
	}

	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarSede(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("/moduloSedes/editarSede");
		Sede sede = servicio.buscarPorID(id);
		mav.addObject("sede", sede);

		return mav;
	}

	@RequestMapping("/eliminar/{id}")
	public String eliminarSede(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);
		;
		return "redirect:/sedes/listarTodo";
	}

}
