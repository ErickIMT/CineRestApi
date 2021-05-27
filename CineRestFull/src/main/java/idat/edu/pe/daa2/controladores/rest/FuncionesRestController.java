package idat.edu.pe.daa2.controladores.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import idat.edu.pe.daa2.jpa.modelo.Funciones;
import idat.edu.pe.daa2.jpa.servicios.FuncionesServicio;

@RestController
@RequestMapping("/rest/funciones")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionesRestController {

	@Autowired
	private FuncionesServicio servFunc;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		
		List<Funciones> listadoFunciones = servFunc.buscarTodo();
		
		return new ResponseEntity<Object>(listadoFunciones, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")//produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} 
								//Se puede agregar para indicar que tipo de datos generara la solicitud
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id){
		
		Funciones funcion = servFunc.buscarPorID(id);
		
		if(funcion == null) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcion no encontrada, id no es correcto");
		
		
		return new ResponseEntity<>(funcion,HttpStatus.OK);
	}
	
	@PostMapping //Tambien se peude usar la opcion produces y/o consumes para indicar tipo de datos qu epoducira y/o consumira
	public ResponseEntity<Object> crearFuncion(@RequestBody Funciones funcion){		
		
		Funciones funcionCreada = servFunc.crear(funcion);
		Map<String, String> mapRespuesta = new HashMap<>();
		mapRespuesta.put("Codigo", "Ok");
		mapRespuesta.put("Mensaje", "Nueva Funciona Creada Correctamente");
		mapRespuesta.put("Codigo de Funcion:", funcionCreada.getIdFunciones().toString());
		return new ResponseEntity<>(mapRespuesta, HttpStatus.CREATED);
	}
	
	@PatchMapping("/{id}") //Para actualizar se utiliza Path o Put
							//Path actualizacion PArcial
							//Put para actualizacion completa // Normalmente se utiliza Put para ambos
	public ResponseEntity<Object> editarFuncion(@PathVariable("id") int id, @RequestBody Funciones funcionActualizar){
		
		funcionActualizar.setIdFunciones(Integer.valueOf(id));
		servFunc.actualizar(funcionActualizar);		
		return new ResponseEntity<Object>("Funcion Actualizada Correctamente",HttpStatus.ACCEPTED);	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminarFuncion(@PathVariable("id") int id){	
		Funciones funcion = servFunc.buscarPorID(id);
		servFunc.borrarPorID(id);		
		return new ResponseEntity<Object>("Funcion: "+funcion.getPelicula().getNombre()+" Borrada correctamente", HttpStatus.ACCEPTED);
	}
	
	
}
