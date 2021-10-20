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
import org.springframework.web.bind.annotation.RestController;

import com.cev.prueba.prueba.domain.Cine;
import com.cev.prueba.prueba.repository.CinesRepository;

@RestController
public class CineController {
	
	private final Logger log = LoggerFactory.getLogger(PeliculasController.class);
	
	@Autowired
	CinesRepository cinesRepository;


	@GetMapping(path = "/cines")
	List<Cine> getAll() {
		return cinesRepository.findAll();
	}
	
	// Cines en los que se proyecta ordenados por precio, de más barato a más caro.
	
	// Cines en los que se proyecta con un determinado código postal.
	
	// Reviews ordenados de mayor puntuación a menor
	
	
	@PostMapping(path = "/cine")
	Cine addCine(@RequestBody Cine cine) {
		log.info("Entré", "add" );
		 Cine CineGuardado = cinesRepository.save(cine);
		 return CineGuardado;
	}
	
	@PutMapping(path = "/cine/{id}")
	Cine updateCine(@RequestBody Cine cine, @PathVariable Long id) {
		Cine cineGuardado = cinesRepository.getOne(id);
		cineGuardado.setNombre(cine.getNombre());
		cineGuardado.setPoblacion(cine.getPoblacion());
		cineGuardado.setCodigoPostal(cine.getCodigoPostal());
		cineGuardado.setProvincia(cine.getProvincia());
		cineGuardado.setPrecioEntrada(cine.getPrecioEntrada());
		cinesRepository.save(cineGuardado);
		return cine;
	}
	
	@DeleteMapping(path = "/cine/{id}")
	String deleteCine(@PathVariable Long id) {
		cinesRepository.delete(cinesRepository.getOne(id));
		return ("Registro borrado.");
	}
}
