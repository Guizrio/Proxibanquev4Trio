package com.proxibanquev4trio.dao;

import com.proxibanquev4trio.domaine.Adresse;
import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.domaine.Conseiller;
import com.proxibanquev4trio.domaine.Gerant;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stagiaire on 05/10/2016.
 */
public class AppTest extends TestCase {
	
	Client client;
	Conseiller conseiller;
	Gerant gerant;
	
	ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spring-dao.xml");
	IClientDao daoClient=(IClientDao) appContext.getBean(IClientDao.class);
	IConseillerDao daoConseiller=(IConseillerDao) appContext.getBean(IConseillerDao.class);
	IGerantDao daoGerant=(IGerantDao) appContext.getBean(IGerantDao.class);
	
	

    @Test 
    public void testFindClientById(){
		
    	long id =3L  ;
    	List<Client> liste;
  	 
    	liste=daoClient.findById(id);	
  	 System.out.println(liste.get(0).getNom());
    }
    
    @Test 
    public void testFindConseillerByLogin(){
		
    	String login ="login1";
    	List<Conseiller> liste;
    	
    	liste= daoConseiller.findByLogin(login);
    	System.out.println(liste.get(0).getNom());
    	System.out.println(liste.get(0).getPwd());
    	System.out.println(liste.get(0).getClients().get(0).getNom());
    }
    
    @Test
    public void testUpdateClient(){
    	
    	
    	Client client =daoClient.findById(3L).get(0);
    	client.setNom("Dubois");
    	daoClient.save(client);
    	client=daoClient.findById(3L).get(0);
    	
        System.out.println(client.getNom());
    	
    	
    	
    	
    }

}