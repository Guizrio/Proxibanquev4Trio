package com.proxibanquev4trio.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proxibanquev4trio.domaine.Adresse;
import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.domaine.Conseiller;
import com.proxibanquev4trio.domaine.Gerant;

public class MiseEnPlaceBD {

	public static void main(String[] args) {
		
		
		Client client;
		Conseiller conseiller;
		Gerant gerant;
		
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spring-dao.xml");
		IClientDao daoClient=(IClientDao) appContext.getBean(IClientDao.class);
		IConseillerDao daoConseiller=(IConseillerDao) appContext.getBean(IConseillerDao.class);
		IGerantDao daoGerant=(IGerantDao) appContext.getBean(IGerantDao.class);
		
		
		
		
			
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
	    	conseiller.setRole("conseiller");
	    	List<Client> liste=new ArrayList<Client>();
	    	liste.add(client);
	    	conseiller.setClients(liste);
	    	client.setConseiller(conseiller);
	    	
	    	gerant =new Gerant();
	    	gerant.setNom("Vincent");
	    	gerant.setRole("gerant");
	    	List<Conseiller> liste2= new ArrayList<Conseiller>();
	    	liste2.add(conseiller);
	    	gerant.setConseillers(liste2);
	    	conseiller.setGerant(gerant);
	    	
	    	daoGerant.save(gerant);
	    	
		
			
		
		

}
}
