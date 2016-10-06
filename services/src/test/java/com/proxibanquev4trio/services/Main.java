package com.proxibanquev4trio.services;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.proxibanquev4trio.domaine.Conseiller;


@Configuration
@ComponentScan
public class Main {

	public static void main(String[] args) {
		
		
		ApplicationContext context= new AnnotationConfigApplicationContext(Main.class);
		IConseillerService service =context.getBean(IConseillerService.class);
		
		
		service.test();
        
		
		//Conseiller conseiller = new Conseiller();
		//conseiller=service.Authentification("login1", "pwd1");
    	//System.out.println(conseiller.getNom());

	}

}
