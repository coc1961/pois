package com.worldline.curso;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	public SessionFactory getSessionFactory(final DataSource dataSource) {
	    final LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    Properties properties = new Properties();
	    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
	    sessionBuilder.addProperties(properties);
	    sessionBuilder.scanPackages("com.em.daas.entity");
	    return sessionBuilder.buildSessionFactory();
	}

}
