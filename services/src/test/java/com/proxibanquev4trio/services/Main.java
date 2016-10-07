package com.proxibanquev4trio.services;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.proxibanquev4trio.domaine.Conseiller;


@Configuration
@ComponentScan
public class Main {

	public static void main(String[] args) {
		
		
		ApplicationContext context= new ClassPathXmlApplicationContext("spring-service.xml");
		IConseillerService service =context.getBean(IConseillerService.class);
    	
    	Conseiller conseiller = new Conseiller();
    	
    	conseiller=service.Authentification("login1");
    	
    	System.out.println(conseiller.getNom());

	}

}
