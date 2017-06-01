package com.worldline.curso.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.worldline.curso.dao.ServicioDao;
import com.worldline.curso.entities.Poi;
import com.worldline.curso.entities.PoisResponse;
import com.worldline.curso.entities.Servicio;
import com.worldline.curso.services.PoiService;

/**
 * REST API of Share Data Manager service
 * 
 * @author a548275
 *
 */
@RestController
@RequestMapping("/v1/poiservice")
public class PoiController
{

	protected static final Logger logger = LoggerFactory.getLogger(PoiController.class);

	@Autowired
	PoiService poiService;

	@Autowired
	ServicioDao servicioDao;

	@RequestMapping(value="/findPoiByService/{serviceName}",method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<PoisResponse> findPoiByServices(@PathVariable("serviceName") String serviceName) {
		String status="Ok";

		List<Poi> pois=new ArrayList<>();

		List<Servicio> servico=servicioDao.findByName(serviceName);
		
		if (servico.size()==0){
			status = "El Servicio Solicitado No Existe";
		}
		else {
			pois=poiService.findByServiceName(serviceName);
		}

		return new  ResponseEntity<PoisResponse>(new PoisResponse(status,pois), HttpStatus.OK);
	}
	
	@RequestMapping(value="/findNearestPoint/{serviceName}/{latitud}/{longitud}",method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<PoisResponse> findNearestPoint(@PathVariable("serviceName") String serviceName, @PathVariable("latitud") String latitud, @PathVariable("longitud") String longitud) {
		String status="Ok";

		Poi poi = new Poi();

		List<Servicio> servico=servicioDao.findByName(serviceName);
		
		if (servico.size()==0){
			status = "El Servicio Solicitado No Existe";
		}
		
		else {
			List<Poi> pois = poiService.findByServiceName(serviceName);
			poi = poiService.findNearestPoi(latitud, longitud, pois);

			if (poi == null){
				status = "No existen puntos cercanos";
			}
		}

		return new  ResponseEntity<PoisResponse>(new PoisResponse(status,poi), HttpStatus.OK);
	}


	@RequestMapping(value="/findPoisWithinRadius/{serviceName}/{latitud}/{longitud}/{radio}",method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<PoisResponse> findPoisWithinRadius(@PathVariable("serviceName") String serviceName, @PathVariable("latitud") String latitud, @PathVariable("longitud") String longitud, @PathVariable("radio") Integer radio) {
		String status="Ok";

		List<Poi> poisResult = new ArrayList<>();

		List<Servicio> servico=servicioDao.findByName(serviceName);
		
		if (servico.size()==0){
			status = "El Servicio Solicitado No Existe";
		}
		
		else {
			List<Poi> pois = poiService.findByServiceName(serviceName);
			poisResult = poiService.findPoisWithinRadius(latitud, longitud, radio, pois);

			if (pois == null){
				status = "No existen puntos en el radio especificado";
			}
		}

		return new  ResponseEntity<PoisResponse>(new PoisResponse(status,poisResult), HttpStatus.OK);
	}


}
