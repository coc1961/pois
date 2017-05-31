package com.worldline.curso.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.worldline.curso.entities.Servicio;

public interface ServicioDao extends CrudRepository<Servicio, Long> {
	
	List<Servicio> findByName(String serviceName);
	
}
