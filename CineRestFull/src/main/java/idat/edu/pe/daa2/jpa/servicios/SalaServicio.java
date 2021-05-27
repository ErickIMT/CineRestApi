package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Sala;
import idat.edu.pe.daa2.jpa.repositorios.SalaRepositorio;



@Service
@Transactional
public class SalaServicio {
	@Autowired
	private SalaRepositorio repositorio;

	public SalaServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Sala> buscarTodo() {
		return (List<Sala>) repositorio.findAll();  
	}

	public Sala crear(Sala sala) {
		return repositorio.save(sala);
	}

	public Sala actualizar(Sala salaActualizar) {
		Sala salaActual = repositorio.findById(salaActualizar.getIdSala()).get();
		salaActual.setNombre(salaActualizar.getNombre());
		salaActual.setCapacidad(salaActualizar.getCapacidad());
		Sala salaActualizado = repositorio.save(salaActual);
		return salaActualizado;
	}

	public Sala buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}
}
