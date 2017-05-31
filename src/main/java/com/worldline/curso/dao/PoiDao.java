package com.worldline.curso.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.worldline.curso.entities.Poi;

public interface PoiDao extends CrudRepository<Poi, Long>, PoiDaoCustom {
	
	List<Poi> findByServiceName(String serviceName);
	
}
