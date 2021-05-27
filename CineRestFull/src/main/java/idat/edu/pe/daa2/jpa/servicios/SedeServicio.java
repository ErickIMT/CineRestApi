package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Sede;
import idat.edu.pe.daa2.jpa.repositorios.SedeRepositorio;



@Service
@Transactional
public class SedeServicio {

	@Autowired
	private SedeRepositorio repositorio;

	public SedeServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Sede> buscarTodo() {
		return (List<Sede>) repositorio.findAll();  
	}

	public Sede crear(Sede sede) {
		return repositorio.save(sede);
	}

	public Sede actualizar(Sede sedeActualizar) {
		Sede sedeActual = repositorio.findById(sedeActualizar.getIdSede()).get();
		sedeActual.setNombre(sedeActualizar.getNombre());
		sedeActual.setDireccion(sedeActualizar.getDireccion());
		
		Sede SedeActualizado = repositorio.save(sedeActual);
		return SedeActualizado;
	}

	public Sede buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}
}
