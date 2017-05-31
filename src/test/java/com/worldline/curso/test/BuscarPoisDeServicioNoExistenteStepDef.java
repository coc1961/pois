package com.worldline.curso.test;

import static org.junit.Assert.assertEquals;

import org.springframework.web.client.RestTemplate;

import com.worldline.curso.entities.PoisResponse;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class BuscarPoisDeServicioNoExistenteStepDef {

	private RestTemplate restTemplate=new RestTemplate();
	private String hostService="http://localhost:8080/v1/poiservice/findPoiByService";
	
	private String urlWithService;

	@Dado("Recibo un consulta de un servicio")
	public void dado1(){
	}

	@Cuando("el servicio es (.*)")
	public void cuando1(String servico){
		urlWithService = hostService+"/"+servico;
	}

	@Entonces("Devuelve el Mensaje (.*)")
	public void entonces1(String mensaje){
		PoisResponse resp=restTemplate.getForObject(urlWithService,PoisResponse.class);
		assertEquals(resp.getStatus(), mensaje);
	}


}
