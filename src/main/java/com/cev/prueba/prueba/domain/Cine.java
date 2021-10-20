package com.cev.prueba.prueba.domain;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cine")
public class Cine {

	@Id
	@GeneratedValue
	Long id;
	
	String nombre;
	String poblacion;
	String codigoPostal;
	String provincia;
	Long precioEntrada;

	@ManyToMany
	@JsonIgnore
 	List<Pelicula> peliculas;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Long getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(Long precioEntrada) {
		this.precioEntrada = precioEntrada;
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	@Override
	public String toString() {
		return "Cine [id=" + id + ", nombre=" + nombre + ", poblacion=" + poblacion + ", codigoPostal=" + codigoPostal
				+ ", provincia=" + provincia + ", precioEntrada=" + precioEntrada + ", peliculas=" + peliculas + "]";
	}

	
}
