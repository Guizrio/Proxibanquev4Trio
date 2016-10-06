package com.proxibanquev4trio.dao;

import com.proxibanquev4trio.domaine.Client;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Stagiaire on 05/10/2016.
 */
public class AppTest extends TestCase {
	
	private Client client;
	private ClientDao dao;
	private ClassPathXmlApplicationContext appContext;
	
	
	
	
	public void testSaveEmploye() {
		
		client = new Client();
		client.setNom("LAVELLE");
		client.setEmail("fabricelavelle@wanadoo.fr");
		client.setPrenom("Fabrice");
		client.setTelephone("01.25.48.69.28");
		
		appContext = new ClassPathXmlApplicationContext("spring-data.xml");

		dao = (ClientDao) appContext.getBean("ClientDao");
		dao.save(client);
	}
	
	
	
   
    
    @Test 
    public void testFindClientById(){
		
    	
    	
    	Long id = 1L;
    	List<Client> liste;
  	 liste=dao.findClientById(id);
    	
  	 System.out.println(liste.get(0).getNom());
   
    	
    }

}