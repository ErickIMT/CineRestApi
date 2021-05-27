package idat.edu.pe.daa2.jpa.repositorios;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import idat.edu.pe.daa2.jpa.modelo.Cine;

public interface CineRepositorio extends CrudRepository<Cine, Integer> {
@Query(value = "SELECT a FROM Cine a WHERE a.nombre = ?1")
	public List<Cine> buscarCinesPorNombre(String nombre);
	
	@Query(value = "SELECT a FROM Cine a WHERE a.nombre like CONCAT(?1, '%')")
public List<Cine> buscarCinesLikeNombre(String nombre);
}
