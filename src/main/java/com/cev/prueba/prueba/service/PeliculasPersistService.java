package com.cev.prueba.prueba.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cev.prueba.prueba.domain.Pelicula;
import com.cev.prueba.prueba.repository.PeliculasRepository;
import com.cev.prueba.prueba.web.PeliculasController;

@Service
public class PeliculasPersistService {

	
	
	PeliculasRepository peliculasRepository;

	public PeliculasPersistService(PeliculasRepository peliculasRepository) {
		this.peliculasRepository = peliculasRepository;
	}
	
	public Pelicula getPelicula(Long id) {
		return peliculasRepository.getOne(id);
	}

	public Long addPelicula(Pelicula pelicula) {
		Pelicula peliculaGuardada = peliculasRepository.save(pelicula);
		return peliculaGuardada.getId();
	}
	
	public List<Pelicula>getPeliculas() {
		return peliculasRepository.findAll();
	}
	
	public void updatePelicula(Long id, Pelicula pelicula) {
		Pelicula peliculaGuardada = peliculasRepository.getOne(id);
		peliculaGuardada.setDirector(pelicula.getDirector());
		peliculaGuardada.setFechaEstreno(pelicula.getFechaEstreno());
		peliculaGuardada.setPuntuacion(pelicula.getPuntuacion());
		peliculaGuardada.setSinopsis(pelicula.getSinopsis());
		peliculaGuardada.setTitulo(pelicula.getTitulo());
		peliculasRepository.save(peliculaGuardada);
	}
	
	public void delletePelicula(Long id) {
		peliculasRepository.delete(peliculasRepository.getOne(id));
	}
	
	public Optional<Pelicula> findById(Long id) {
		return peliculasRepository.findById(id);
	}
	

}
