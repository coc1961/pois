package com.worldline.curso;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.worldline.curso.dao.PoiDao;
import com.worldline.curso.entities.Poi;

@Configuration
@EnableTransactionManagement
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	
	@Bean
	public CommandLineRunner demo(PoiDao repository) {
		return (args) -> {
			repository.save(new Poi("Prueba"));
			repository.findByServiceNameAndMap("Prueba","mapa");

		};
	}

}
