package com.proxibanquev4trio.services;

import com.proxibanquev4trio.domaine.Conseiller;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Stagiaire on 05/10/2016.
 */
public class AppTest {
    @Test
    public void main() throws Exception {

    }
    
    @Test
    public void testAuthentification(){
    	
    	
    	ApplicationContext context= new ClassPathXmlApplicationContext("spring-service.xml");
		IConseillerService service =context.getBean(IConseillerService.class);
    	
    	Conseiller conseiller = new Conseiller();
    	
    	conseiller=service.Authentification("login1");
    	
    	System.out.println(conseiller.getNom());
    }
    
   

}