package com.cev.prueba.prueba.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.stereotype.Service;
import com.cev.prueba.prueba.domain.Pelicula;


@Service
public class PeliculasService {
	
	List<Pelicula> peliculasEs = new ArrayList<Pelicula>();
	List<Pelicula> peliculasEn = new ArrayList<Pelicula>();
	
	
	public PeliculasService() {
		Pelicula pelicula = new Pelicula();
		
		pelicula.setTitulo("Kill Bill");
		pelicula.setPuntuacion(10);
		pelicula.setSinopsis("Uma Thurman in yellow jumpsuit and hitting sabers. What do you want more for?");
		pelicula.setFechaEstreno(new GregorianCalendar(2003, Calendar.JANUARY, 01).getTime());
		pelicula.setDirector("Quentin Tarantino");
		peliculasEn.add(pelicula);
		

		pelicula.setTitulo("Kill Bill");
		pelicula.setPuntuacion(10);
		pelicula.setSinopsis("Uma Thurman con mono amarillo y pegando sablazos. Para qué quieres más.");
		pelicula.setFechaEstreno(new GregorianCalendar(2003, Calendar.JANUARY, 01).getTime());
		pelicula.setDirector("Quentin Tarantino");
		peliculasEs.add(pelicula);
	}	
	
	public Pelicula getPelicula(int id, String acceptLenguage) {
		if (acceptLenguage == "es-ES") {
			return peliculasEs.get(id-1);
		} else return peliculasEn.get(id-1);
	}
	
	public int add(Pelicula pelicula) {
		peliculasEn.add(pelicula);
		return peliculasEn.size();
	}

	public List<Pelicula> getPeliculas() {
		return peliculasEn;
	}
	
	public void guarda(int id, Pelicula pelicula ) {
		peliculasEn.set(id-1, pelicula);
	}
	
	public void borra(int id) {
		peliculasEn.remove(id-1);
	}
	
	public List<Pelicula> buscaPorTitulo(String titulo) {
		
		List<Pelicula> peliculasResultado = new ArrayList<Pelicula>();	
		for(Pelicula pelicula: peliculasEn) {
			if(pelicula.getTitulo().contains(titulo)) {
				peliculasResultado.add(pelicula);
			}
		}
		return peliculasResultado;	
	}
	
	public List<Pelicula> buscarPorPuntuacion(int puntuacionMinima, int puntuacionMaxima){
		
		List<Pelicula> peliculasResultado = new ArrayList<Pelicula>();	
		for(Pelicula pelicula: peliculasEn) {
			if(pelicula.getPuntuacion() >= puntuacionMinima && 
					pelicula.getPuntuacion() <= puntuacionMaxima) {				
				peliculasResultado.add(pelicula);
			}
		}
		return peliculasResultado;
	}
	
}
