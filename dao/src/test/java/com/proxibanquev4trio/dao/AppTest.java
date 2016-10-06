package com.proxibanquev4trio.dao;

import com.proxibanquev4trio.domaine.Adresse;
import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.domaine.Conseiller;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stagiaire on 05/10/2016.
 */
public class AppTest extends TestCase {
	
	private Client client;
	private Conseiller conseiller;
	
	private ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spring-data.xml");
	private ClientDao daoClient=(ClientDao) appContext.getBean("clientDao");
	private IConseillerDao daoConseiller=(IConseillerDao) appContext.getBean(IConseillerDao.class);
	
	
	
	public void testSave() {
		
		Adresse adresse = new Adresse();
		adresse.setCodePostal("69100");
		adresse.setNomDeRue("Lavoisier");
		adresse.setNumeroDeRue("19");
		adresse.setTypeDeRue("rue");
		adresse.setVille("Villeurbanne");
		
		client = new Client();
		client.setNom("LAVELLE");
		client.setEmail("fabricelavelle@wanadoo.fr");
		client.setPrenom("Fabrice");
		client.setTelephone("01.25.48.69.28");
		client.setAdresse(adresse);
		
		conseiller=new Conseiller();
    	conseiller.setNom("MBIANDOU");
    	conseiller.setPrenom("Douglas");
    	conseiller.setPwd("pwd1");
    	conseiller.setTelephone("04.58.96.27.64");
    	conseiller.setLogin("login1");
    	List<Client> liste=new ArrayList<Client>();
    	liste.add(client);
    	conseiller.setClients(liste);
    	client.setConseiller(conseiller);
    	
    	
    	daoConseiller.save(conseiller);
	
		
	}

    @Test 
    public void testFindClientById(){
		
    	Long id = 2L;
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
    

}