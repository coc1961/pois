package com.worldline.curso.services;

import java.util.List;

import com.worldline.curso.entities.Poi;

public interface PoiService {
	
	List<Poi> findByServiceName(String serviceName);
	
	Poi findNearestPoi(String latitud, String longitud, List<Poi> pois);

	List<Poi> findPoisWithinRadius(String latitud, String longitud, int radio, List<Poi> pois);

}
