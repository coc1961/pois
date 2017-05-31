package com.worldline.curso.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldline.curso.dao.PoiDao;
import com.worldline.curso.entities.Poi;
import com.worldline.curso.services.PoiService;

@Service
public class PoiServiceImpl implements PoiService {
	
	@Autowired
	PoiDao dao;

	@Override
	public List<Poi> findByServiceName(String serviceName) {
		return dao.findByServiceName(serviceName);
	}
	
	

	
}
