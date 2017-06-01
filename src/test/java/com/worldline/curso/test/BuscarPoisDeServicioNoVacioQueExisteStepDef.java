package com.worldline.curso.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.worldline.curso.entities.Poi;
import com.worldline.curso.entities.PoisResponse;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class BuscarPoisDeServicioNoVacioQueExisteStepDef extends BaseTest {

	private String hostService=getHostServiceBase()+"/findPoiByService";
	private String urlWithService;

	@Dado("Recibo un consulta de un Servicio")
	public void dado1(){
	}

	@Cuando("el servicio Es (.*)")
	public void cuando1(String servico){
		urlWithService = hostService+"/"+servico;
	}

	@Entonces("devuelve la lista de POIs")
	public void entonces1(List<Poi> pois){
		PoisResponse resp=getRestTemplate().getForObject(urlWithService,PoisResponse.class);
		for (Poi poi : pois) {
			boolean ok=false;
			for (Poi poiS : resp.getPois()) {
				if (poi.getLatitud().equals(poiS.getLatitud()) &&
					poi.getLongitud().equals(poiS.getLongitud()) &&
					poi.getNombre().equals(poiS.getNombre())
					){
					ok=true;
				}
			}
			assertTrue("Poi No Coincide "+poi.getNombre(),ok);
		}
		assertEquals(resp.getStatus(), "Ok");
	}


}
