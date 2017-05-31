package com.worldline.curso.services.impl;

import java.math.BigDecimal;
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
	public Poi findNearestPoi(String latitud, String longitud) {
		
		Poi poi = new Poi(latitud, longitud);
		List<Poi> pois = (List<Poi>) dao.findAll();
		
		return getNearestPoint(poi, pois); 
	}
	
	private Poi getNearestPoint(Poi poi, List<Poi> pois) {

		Poi poiMasCercano = null; 
        double distancia = 0; 
        double distanciaMasCercana = 99999999f; 
        
        for (Poi p : pois) {
          distancia = obtenerDistancia(poi.getLatitud(), poi.getLongitud(), p.getLatitud(), p.getLongitud()); 
          if (distancia < distanciaMasCercana) 
          { 
              distanciaMasCercana = distancia; 
              poiMasCercano = p; 
          }       
        }
        return poiMasCercano; 
	}
	
	
	private double obtenerDistancia(String lat1, String long1, String lat2, String long2) {
		
		BigDecimal latitud1 = new BigDecimal(lat1);
		BigDecimal longitud1 = new BigDecimal(long1);
		BigDecimal latitud2 = new BigDecimal(lat2);
		BigDecimal longitud2 = new BigDecimal(long2);
		
		BigDecimal result1 = new BigDecimal(Math.pow((latitud2.subtract(latitud1)).doubleValue(), 2f));
		BigDecimal result2 = new BigDecimal(Math.pow((longitud2.subtract(longitud1)).doubleValue(), 2f));
		
		return Math.sqrt(result1.add(result2).doubleValue());
		
    }
	
//	public pois puntosDentroDeUnaZona(float latitud, float longitud, int radio, pois puntos)
//
//    {
//
//                pois poisEnZona;
//
//                foreach (pois as poi)
//
//                {
//
//                            if (obtenerDistancia(latitud, longitud, poi.latitud, poi.longitud) <= radio)
//
//                            {
//
//                                        poisEnZona.add(poi);
//
//                            }
//
//                }
//
//                return poisEnZona;
//
//    } 

}
