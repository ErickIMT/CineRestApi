package idat.edu.pe.daa2.jpa.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.daa2.jpa.modelo.Pelicula;
import idat.edu.pe.daa2.jpa.repositorios.PeliculaRepositorio;


@Service
@Transactional
public class PeliculasServicio {
	@Autowired
	private PeliculaRepositorio repositorio;

	public PeliculasServicio() {  
		// TODO Auto-generated constructor stub
	}

	public List<Pelicula> buscarTodo() {
		return (List<Pelicula>) repositorio.findAll();  
	}

	public Pelicula crear(Pelicula pelicula) {
		return repositorio.save(pelicula);
	}

	public Pelicula actualizar(Pelicula peliculaActualizar) {
		Pelicula peliculaActual = repositorio.findById(peliculaActualizar.getIdPelicula()).get();
		peliculaActual.setIdPelicula(peliculaActualizar.getIdPelicula());
		peliculaActual.setNombre(peliculaActualizar.getNombre());
		peliculaActual.setDuracion(peliculaActualizar.getDuracion());
		peliculaActual.setClasificacion(peliculaActualizar.getClasificacion());
		peliculaActual.setIdioma(peliculaActualizar.getIdioma());
		peliculaActual.setGenero(peliculaActualizar.getGenero());
		peliculaActual.setFormato(peliculaActualizar.getFormato());
		peliculaActual.setSinopsis(peliculaActualizar.getSinopsis());
		
		
		
		
		Pelicula peliculaActualizado = repositorio.save(peliculaActual);
		return peliculaActualizado;
	}

	public Pelicula buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}

	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}
}
