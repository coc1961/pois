package com.worldline.curso.test;

import org.springframework.web.client.RestTemplate;

public class BaseTest {
	
	private RestTemplate restTemplate=new RestTemplate();
	private String hostServiceBase="http://localhost:8080/pois-app/v1/poiservice";

	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	public String getHostServiceBase() {
		return hostServiceBase;
	}
	
	
	
	
	


}
