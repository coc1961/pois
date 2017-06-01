package com.worldline.curso.services.impl;

import java.util.ArrayList;
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

	@Override
	public Poi findNearestPoi(String latitud, String longitud, List<Poi> pois) {
		
		Poi poi = new Poi(latitud, longitud);
		return getNearestPoint(poi, pois); 
	}
	
	@Override
	public List<Poi> findPoisWithinRadius(String latitud, String longitud, int radio, List<Poi> pois) {
		
		Poi poi = new Poi(latitud, longitud);
		return getPoisWithinRadius(poi, pois, radio); 
	}

	
	private Poi getNearestPoint(Poi poiReferencia, List<Poi> pois) {

		Poi poiMasCercano = null; 
        double distancia = 0; 
        double distanciaMasCercana = 9999999999f; 
        
        for (Poi poiToValidate : pois) {
          distancia = obtenerDistancia(poiReferencia, poiToValidate); 
          if (distancia < distanciaMasCercana) 
          { 
              distanciaMasCercana = distancia; 
              poiMasCercano = poiToValidate; 
          }       
        }
        return poiMasCercano; 
	}

	private List<Poi> getPoisWithinRadius(Poi poiReferencia, List<Poi> pois, int radio) {
		
		List<Poi> poisEnZona = new ArrayList<>();
		
        for (Poi poiToValidate : pois) {		
			if (obtenerDistancia(poiReferencia, poiToValidate) <= radio) {
				poisEnZona.add(poiToValidate);
			}
		}
		return poisEnZona;
	} 
	
	private double obtenerDistancia(Poi poiReferencia, Poi poiToValidate) {
		
		double latReferencia = Double.parseDouble(poiReferencia.getLatitud());
		double lonReferencia = Double.parseDouble(poiReferencia.getLongitud());

		double latToValidate = Double.parseDouble(poiToValidate.getLatitud());
		double lonToValidate = Double.parseDouble(poiToValidate.getLongitud());

//		double difLatitud  = Math.pow((latToValidate - latReferencia), 2);
//		double difLongitud = Math.pow((lonToValidate - lonReferencia), 2);
		
		double difLatitud  = Math.pow((latReferencia - latToValidate), 2);
		double difLongitud = Math.pow((lonReferencia - lonToValidate), 2);

		return Math.sqrt(difLatitud + difLongitud);
		
	}
}
