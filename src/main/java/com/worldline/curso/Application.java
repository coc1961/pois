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
import com.worldline.curso.entities.Poi;
import com.worldline.curso.entities.Servicio;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableTransactionManagement
@SpringBootApplication
@EnableSwagger2
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
            .title("Poi Service API")
            .description(
                "Service that expose REST API to access to Poi data")
            .version("1.0.0-SNAPSHOT").build();
    }

	
	@Bean
	public CommandLineRunner demo(PoiDao repository) {
		return (args) -> {
			repository.save(new Poi("Buenos Aires Turistica",
									"-34.603750",
									"-58.378575",
									"Las Cuartetas",
									"Pizzeria Las Cuartetas"));
			
			repository.save(new Poi("Buenos Aires Turistica",
					"-34.597828",
					"-58.385435",
					"El Cuartito",
					"Pizzeria El Cuartito"));
			
			repository.save(new Poi("Buenos Aires Turistica",
					"-34.603290",
					"-58.377388",
					"El Palacio de la Pizza",
					"Pizzeria El Palacio de la Pizza"));

			repository.save(new Poi("Buenos Aires Turistica",
					"-34.635611",
					"-58.364713",
					"Bombonera",
					"Los mas grande del mundo"));
			
			repository.save(new Poi("Buenos Aires Turistica",
					"-34.635362",
					"-58.520740",
					"Estadio de Vélez",
					"??"));
			
			repository.save(new Poi("Buenos Aires Turistica",
					"-34.545262",
					"-58.449753",
					"Monumental",
					"Freezer"));
			
			repository.save(new Poi("Buenos Aires Turistica",
					"-34.603765",
					"-58.381624",
					"Obelisco",
					"Obelisco"));
			
			
			repository.save(new Poi("Buenos Aires Historica",
					"-34.608808",
					"-58.373833",
					"Cabildo",
					"Cabildo"));
			
			repository.save(new Poi("Buenos Aires Historica",
					"-34.612571",
					"-58.371842",
					"Convento de Santo Domingo",
					"Convento de Santo Domingo"));
			
			repository.save(new Poi("Buenos Aires Historica",
					"-34.607569",
					"-58.373257",
					"Catedral Metropolitana",
					"Catedral Metropolitana"));
			
			repository.save(new Poi("Buenos Aires Historica",
					"-34.609590",
					"-58.396192",
					"Café los Angelitos",
					"Café los Angelitos"));
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
