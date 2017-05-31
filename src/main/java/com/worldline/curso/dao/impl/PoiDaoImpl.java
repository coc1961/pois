package com.worldline.curso.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.worldline.curso.dao.PoiDaoCustom;
import com.worldline.curso.entities.Poi;


public class PoiDaoImpl implements PoiDaoCustom {
	
	 @PersistenceContext 
	 private EntityManager em;
	 
	 @PostConstruct
	 private void init(){
		 System.out.println();
	 }

	@Override
	public List<Poi> findByServiceNameAndMap(String serviceName,String map) {
		return null;
	}

}
