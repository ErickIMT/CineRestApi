package idat.edu.pe.daa2.jpa.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.daa2.jpa.modelo.Pelicula;

public interface PeliculaRepositorio extends CrudRepository<Pelicula, Integer> {

	@Query(value = "SELECT a FROM Pelicula a WHERE a.nombre = ?1")
	public List<Pelicula> buscarPeliculasPorNombre(String nombre);

	@Query(value = "SELECT a FROM Pelicula a WHERE a.nombre like CONCAT(?1, '%')")
	public List<Pelicula> buscarPeliculaLikeNombre(String nombre);
}
