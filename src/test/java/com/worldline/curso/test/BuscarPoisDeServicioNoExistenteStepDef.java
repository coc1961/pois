package com.worldline.curso.test;

import static org.junit.Assert.assertEquals;

import com.worldline.curso.entities.PoisResponse;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class BuscarPoisDeServicioNoExistenteStepDef extends BaseTest {

	private String hostService=getHostServiceBase()+"/findPoiByService";
	private String urlWithService;

	@Dado("Recibo un consulta de un servicio")
	public void dado(){
	}

	@Cuando("el servicio es (.*)")
	public void cuando(String servico){
		urlWithService = hostService+"/"+servico;
	}

	@Entonces("Devuelve el Mensaje (.*)")
	public void entonces(String mensaje){
		PoisResponse resp=getRestTemplate().getForObject(urlWithService,PoisResponse.class);
		assertEquals(resp.getStatus(), mensaje);
	}


}
