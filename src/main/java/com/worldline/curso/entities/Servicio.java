package com.worldline.curso.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Servicio {

	@Id
	@GenericGenerator(name="myGenerator1",strategy="com.worldline.curso.entities.generator.IdGenerator") 
	@GeneratedValue(generator="myGenerator1")
	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Servicio() {
	}
	public Servicio(String name) {
		super();
		this.name = name;
	}

}
