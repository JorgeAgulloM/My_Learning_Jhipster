package com.cev.prueba.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cev.prueba.prueba.domain.Pelicula;

@Repository
public interface PeliculasRepository extends JpaRepository<Pelicula, Long> {

	//List<Pelicula>findByTituloContainingIgnoreCase(String titulo);
	
	@Query(nativeQuery = true, value = "SELECT * FROM pelicula WHERE pelicula.titulo =:titulo "
			+ "In (pelicula.cines ORDER BY precioEntrada ASC)")
	List<Pelicula>CinesInPeliculaOrderByPrecioEntradaAsc(String titulo);
	

	@Query(nativeQuery = true, value = "order by cines.precioEntrada")
	List<Pelicula>findByTituloContainingIgnoreCase(String titulo);
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM pelicula WHERE pelicula.titulo =:titulo "
			+ "JOIN cines order by precioEntrada")
	List<Pelicula>findByTitulo(String titulo);
	

	
}
