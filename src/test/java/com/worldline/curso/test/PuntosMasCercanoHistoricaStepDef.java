package com.worldline.curso.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.worldline.curso.entities.Poi;
import com.worldline.curso.entities.PoisResponse;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class PuntosMasCercanoHistoricaStepDef extends BaseTest {

	private String hostService=getHostServiceBase()+"/findNearestPoint";
	private String urlWithService;

	@Dado("Obtener el Poi de Un Servicio en funcion de las coordenadas y servicio de un usuario")
	public void dado(){
	}

	@Cuando("un usuario suscripto al servicios (.*) y el usuario está ubicado en (.*) (.*)")
	public void cuando(String servico,String latitud,String longitud){
		urlWithService = hostService+"/"+servico+"/"+latitud+"/"+longitud+"/";
	}

	@Entonces("se devuelve")
	public void entonces(List<Poi> pois){
		PoisResponse resp=getRestTemplate().getForObject(urlWithService,PoisResponse.class);
		assertTrue(resp.getPoi().getNombre().equals(pois.get(0).getNombre()) );
	}


}
