package com.cev.prueba.prueba.web;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cev.prueba.prueba.domain.Pelicula;
import com.cev.prueba.prueba.repository.PeliculasRepository;
import com.cev.prueba.prueba.service.PeliculasPersistService;
import com.cev.prueba.prueba.web.error.CustomError;
import com.cev.prueba.prueba.web.error.TeaError;

@RestController
public class PeliculasController {
	
	private final Logger log = LoggerFactory.getLogger(PeliculasController.class);
	
	@Autowired 
	PeliculasPersistService peliculasPersistService;	
	
	@Autowired 
	PeliculasRepository peliculasRepository;

	@GetMapping(path = "/peliculas")
	List<Pelicula> getPeliculas(){ return peliculasPersistService.getPeliculas(); }
		

	@GetMapping(path = "/peliculas/{id}")
	Pelicula getPeliculas(@PathVariable Long id,
			@RequestParam(required = false, name = "accept-language") String acceptLanguage){	
		if(peliculasPersistService.findById(id).isPresent()) {
			return peliculasPersistService.findById(id).get();
		} else throw new CustomError("No encuentro esa película");
			
	}
	
	@GetMapping(path = "/tes")
	String getTeaHour() { throw new TeaError("Son las 5:00pm, hora de tomar el té."); }
	
	//Prueba
	@GetMapping(path = "peliculas/titulo")
	List<Pelicula> getPeliculasTitulo(@RequestParam(required = true, name = "titulo") String titulo){		
		return peliculasRepository.findByTitulo(titulo);
		
		//return peliculasRepository.findByTituloContainingIgnoreCaseCollectionCinesOrderByPrecioEntradas(titulo);
	}
	
	
	@PostMapping(path = "/peliculas")
	Long addPelicula(@RequestBody Pelicula pelicula ) {				
		return peliculasPersistService.addPelicula(pelicula);		
	}
	
	@PutMapping(path = "/peliculas/{id}")
	Pelicula updatePelicula(@RequestBody Pelicula pelicula, @PathVariable Long id) {
		peliculasPersistService.updatePelicula(id, pelicula);			
		return pelicula;		
	}
	
	@DeleteMapping(path="/peliculas/{id}")
	String deletePelicula(@PathVariable Long id) {	
		peliculasPersistService.delletePelicula(id);	
		return("OK");
	}
	

	
	
	

}

