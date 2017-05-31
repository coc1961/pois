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
import com.worldline.curso.dao.ServicioDao;
import com.worldline.curso.entities.Servicio;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

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
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("com.worldline.curso.controller"))
            .paths(PathSelectors.any()).build().apiInfo(metadata()).tags(new Tag("Poi","Poi"));
    }

    private ApiInfo metadata()
    {
        return new ApiInfoBuilder()
            .title("Share Data Manager API")
            .description(
                "Service that expose REST API to access to Poi data")
            .version("1.0.0-SNAPSHOT").build();
    }

	
	@Bean
	public CommandLineRunner demo(PoiDao repository) {
		return (args) -> {
			//repository.save(new Poi("Prueba"));
			

		};
	}

	@Bean
	public CommandLineRunner servicioP(ServicioDao repository) {
		return (args) -> {
			repository.save(new Servicio("Buenos Aires Turistica"));
			repository.save(new Servicio("Buenos Aires Historica"));
			repository.save(new Servicio("Buenos Aires Tango"));
		};
	}

}
