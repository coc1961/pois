package com.worldline.curso.test;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.worldline.curso.entities.PoisResponse;


//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT,classes = Application.class)
public class PoiIT {
		
	 private RestTemplate restTemplate=new RestTemplate();
	 
	 private String hostService="http://localhost:8080/v1/poiservice";

	
	@Test
	public void exampleTest() {
		PoisResponse resp=restTemplate.getForObject(hostService+"/findPoiByService/Buenos Aires Turistica",PoisResponse.class);
		System.out.println(resp);
	}
	


}
