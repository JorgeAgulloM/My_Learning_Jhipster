package com.cev.prueba.prueba.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Pelicula {
	
	@Id
	@GeneratedValue
	Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	//@Column() Sirve para realizar modificaciones en la BBDD
	String titulo;

	int puntuacion;
	String sinopsis;
	String director;
	Date fechaEstreno;
	
	@ManyToMany(mappedBy ="peliculas")	
	@JsonIgnoreProperties({"peliculas"}) 
	List<Cine> cines;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public List<Cine> getCines() {
		return cines;
	}
	public void setCines(List<Cine> cines) {
		this.cines = cines;
	}


}
