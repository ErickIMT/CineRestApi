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

import idat.edu.pe.daa2.jpa.modelo.Cine;
import idat.edu.pe.daa2.jpa.servicios.CineServicio;



@Controller
@RequestMapping("/cines")
public class CineWebController {
	@Autowired
	private CineServicio servicio;

	@RequestMapping("/listarTodo")
	public String listarCines(Model model) {
		List<Cine> listaCines = servicio.buscarTodo();
		model.addAttribute("listaCines", listaCines);
		return "/moduloCines/listarTodo";
	}

	@RequestMapping("/nuevo")
	public String nuevoCine(Model model) {
		Cine cine = new Cine();
		model.addAttribute("cine", cine);
		return "/moduloCines/nuevoCine";
	}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String crearCine(@ModelAttribute("cine") Cine cine) {
		servicio.crear(cine);
		return "redirect:/cines/listarTodo";
	}

	@RequestMapping("/actualizar/{id}")
	public ModelAndView editarCine(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("/moduloCines/editarCine");
		Cine cine = servicio.buscarPorID(id);
		mav.addObject("cine", cine);

		return mav;
	}

	@RequestMapping("/eliminar/{id}")
	public String eliminarCine(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);
		;
		return "redirect:/cines/listarTodo";
	}

}
