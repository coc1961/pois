package com.worldline.curso.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Poi {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	private String latitud;
	private String longitud;
	private String nombre;
	private String descripcion;
	private String serviceName;
	
	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Poi() {}
	
	public Poi(String serviceName, String latitud, String longitud, String nombre, String descripcion) {
		super();
		this.serviceName = serviceName;
		this.latitud = latitud;
		this.longitud = longitud;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Poi(String latitud, String longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

	private Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	
	
	

}
