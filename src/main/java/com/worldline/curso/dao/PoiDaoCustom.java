package com.worldline.curso.dao;

import java.util.List;

import com.worldline.curso.entities.Poi;

public interface PoiDaoCustom {
	
	public List<Poi> findByServiceNameAndMap(String serviceName,String map);

}
