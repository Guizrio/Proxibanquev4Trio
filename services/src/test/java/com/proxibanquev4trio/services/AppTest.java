package com.proxibanquev4trio.services;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.proxibanquev4trio.domaine.Conseiller;

/**
 * Created by Stagiaire on 05/10/2016.
 */

@Configuration
@ComponentScan
public class AppTest {
    @Test
    public void main() throws Exception {

    }
    
    @Test
    public void testAuthentification(){
    	
    	
    	ApplicationContext context= new AnnotationConfigApplicationContext(AppTest.class);
		IConseillerService service =context.getBean(IConseillerService.class);
    	
    	Conseiller conseiller = new Conseiller();
    	
    	conseiller=service.Authentification("login1", "pwd1");
    	
    	System.out.println(conseiller.getNom());
    }
    
    @Test
    public void test(){
    	

		ApplicationContext context= new AnnotationConfigApplicationContext(AppTest.class);
		IConseillerService service =context.getBean(IConseillerService.class);
		
		
		service.test();
    	
    }

}