package com.proxibanquev4trio.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proxibanquev4trio.domaine.Adresse;
import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.domaine.Compte;
import com.proxibanquev4trio.domaine.CompteCourant;
import com.proxibanquev4trio.domaine.CompteEpargne;
import com.proxibanquev4trio.domaine.Conseiller;
import com.proxibanquev4trio.domaine.Gerant;

public class MiseEnPlaceBD {

	public static void main(String[] args) {
		
		
		Client client;
		Client client2;
		Conseiller conseiller;
		Gerant gerant;
		
		CompteCourant compte1;
		CompteEpargne compte2;
		CompteCourant compte3;
		CompteEpargne compte4;
		
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spring-dao.xml");
		IClientDao daoClient=(IClientDao) appContext.getBean(IClientDao.class);
		IConseillerDao daoConseiller=(IConseillerDao) appContext.getBean(IConseillerDao.class);
		IGerantDao daoGerant=(IGerantDao) appContext.getBean(IGerantDao.class);
		ICompteDao daoCompte=(ICompteDao) appContext.getBean(ICompteDao.class);
		
		
		
		Adresse adresse2 = new Adresse();
		adresse2.setCodePostal("92400");
		adresse2.setNomDeRue("Baudin");
		adresse2.setNumeroDeRue("24");
		adresse2.setTypeDeRue("avenue");
		adresse2.setVille("St Denis");
		
		compte1=new CompteCourant();
		compte1.setDateouverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
		compte1.setSolde(10000D);
		compte1.setDecouvert(200D);
		
		compte2= new CompteEpargne();
		compte2.setDateouverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
		compte2.setSolde(20000D);
		compte2.setTaux(2D);
		
		
		
		
		client2 = new Client();
		client2.setNom("Rio");
		client2.setEmail("guillaumerio@wanadoo.fr");
		client2.setPrenom("Guillaume");
		client2.setTelephone("01.25.48.69.28");
		client2.setAdresse(adresse2);
		List<Compte> liste4 = new ArrayList<Compte>();
		client2.setListeCompte(liste4);
		client2.getListeCompte().add(compte2);
		client2.getListeCompte().add(compte1);
		
		compte2.setClient(client2);
		compte1.setClient(client2);
		
		
		
			
			Adresse adresse = new Adresse();
			adresse.setCodePostal("69100");
			adresse.setNomDeRue("Lavoisier");
			adresse.setNumeroDeRue("19");
			adresse.setTypeDeRue("rue");
			adresse.setVille("Villeurbanne");
			
			compte3=new CompteCourant();
			compte3.setDateouverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte3.setSolde(10000D);
			compte3.setDecouvert(200D);
			
			compte4= new CompteEpargne();
			compte4.setDateouverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte4.setSolde(20000D);
			compte4.setTaux(2D);
			
			client = new Client();
			client.setNom("LAVELLE");
			client.setEmail("fabricelavelle@wanadoo.fr");
			client.setPrenom("Fabrice");
			client.setTelephone("01.25.48.69.28");
			client.setAdresse(adresse);
			List<Compte> liste3= new ArrayList<Compte>();
			client.setListeCompte(liste3);
			client.getListeCompte().add(compte3);
			client.getListeCompte().add(compte4);
			
			compte3.setClient(client);
			compte4.setClient(client);
			
			conseiller=new Conseiller();
	    	conseiller.setNom("MBIANDOU");
	    	conseiller.setPrenom("Douglas");
	    	conseiller.setPwd("pwd1");
	    	conseiller.setTelephone("04.58.96.27.64");
	    	conseiller.setLogin("login1");
	    	conseiller.setRole("conseiller");
	    	List<Client> liste=new ArrayList<Client>();
	    	liste.add(client);
	    	liste.add(client2);
	    	conseiller.setClients(liste);
	    	client.setConseiller(conseiller);
	    	client2.setConseiller(conseiller);
	    	
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
