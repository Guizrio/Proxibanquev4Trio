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
import com.proxibanquev4trio.domaine.Virement;

public class MiseEnPlaceBD {

	public static void main(String[] args) {
		
		
		
		Conseiller conseiller;
		Gerant gerant;
		
		
		
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spring-dao.xml");
		IClientDao daoClient=(IClientDao) appContext.getBean(IClientDao.class);
		IConseillerDao daoConseiller=(IConseillerDao) appContext.getBean(IConseillerDao.class);
		IGerantDao daoGerant=(IGerantDao) appContext.getBean(IGerantDao.class);
		ICompteDao daoCompte=(ICompteDao) appContext.getBean(ICompteDao.class);
		IVirementDao daoVirement= (IVirementDao) appContext.getBean(IVirementDao.class);
		

		Adresse adresse = new Adresse();
		adresse.setCodePostal("69100");
		adresse.setNomDeRue("Lavoisier");
		adresse.setNumeroDeRue("19");
		adresse.setTypeDeRue("rue");
		adresse.setVille("Villeurbanne");
		
		CompteCourant compte1=new CompteCourant();
		compte1.setDateOuverture(new Timestamp(1, 2, 3, 4, 5, 6, 7));
		compte1.setSolde(10000D);
		compte1.setDecouvert(200D);
		
		CompteEpargne compte2= new CompteEpargne();
		compte2.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
		compte2.setSolde(20000D);
		compte2.setTaux(2D);
		
		
		Client client = new Client();
		client.setNom("LAVELLE");
		client.setEmail("fabricelavelle@wanadoo.fr");
		client.setPrenom("Fabrice");
		client.setTelephone("01.25.48.69.28");
		client.setAdresse(adresse);
		List<Compte> liste3= new ArrayList<Compte>();
		client.setListeCompte(liste3);
		client.getListeCompte().add(compte1);
		client.getListeCompte().add(compte2);
		
		compte1.setClient(client);
		compte2.setClient(client);
		
		//client 2
		
		
		Adresse adresse2 = new Adresse();
		adresse2.setCodePostal("92400");
		adresse2.setNomDeRue("Baudin");
		adresse2.setNumeroDeRue("24");
		adresse2.setTypeDeRue("avenue");
		adresse2.setVille("St Denis");
	
		Client client2 = new Client();
		client2.setNom("Rio");
		client2.setEmail("guillaumerio@wanadoo.fr");
		client2.setPrenom("Guillaume");
		client2.setTelephone("01.25.48.69.28");
		client2.setAdresse(adresse2);
		
		CompteCourant compte3=new CompteCourant();
		compte3.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
		compte3.setSolde(10000D);
		compte3.setDecouvert(200D);
		
		CompteEpargne compte4= new CompteEpargne();
		compte4.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
		compte4.setSolde(20000D);
		compte4.setTaux(2D);
		
		List<Compte> liste4 = new ArrayList<Compte>();
		client2.setListeCompte(liste4);
		client2.getListeCompte().add(compte3);
		client2.getListeCompte().add(compte4);
		
		compte3.setClient(client2);
		compte4.setClient(client2);
		
		
		
			
			
			
			
			// Client 3
			
			Adresse adresse3 = new Adresse();
			adresse3.setCodePostal("69100");
			adresse3.setNomDeRue("Lavoisier");
			adresse3.setNumeroDeRue("19");
			adresse3.setTypeDeRue("rue");
			adresse3.setVille("Villeurbanne");
			
			
			CompteCourant compte5=new CompteCourant();
			compte5.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte5.setSolde(10000D);
			compte5.setDecouvert(200D);
			
			CompteEpargne compte6= new CompteEpargne();
			compte6.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte6.setSolde(20000D);
			compte6.setTaux(2D);
			
			
			Client client3 = new Client();
			client3.setNom("BLAMEBLE");
			client3.setEmail("blameble.vincent@wanadoo.fr");
			client3.setPrenom("Vincent");
			client3.setTelephone("01.25.48.69.28");
			client3.setAdresse(adresse3);
			List<Compte> liste5= new ArrayList<Compte>();
			client3.setListeCompte(liste5);
			client3.getListeCompte().add(compte5);
			client3.getListeCompte().add(compte6);
			
			compte5.setClient(client3);
			compte6.setClient(client3);
			
			//Client 4
			
			Adresse adresse4 = new Adresse();
			adresse4.setCodePostal("69100");
			adresse4.setNomDeRue("Lavoisier");
			adresse4.setNumeroDeRue("19");
			adresse4.setTypeDeRue("rue");
			adresse4.setVille("Villeurbanne");
			
			
			CompteCourant compte7=new CompteCourant();
			compte7.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte7.setSolde(10000D);
			compte7.setDecouvert(200D);
			
			CompteEpargne compte8= new CompteEpargne();
			compte8.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte8.setSolde(20000D);
			compte8.setTaux(2D);
			
			
			Client client4 = new Client();
			client4.setNom("TARDY");
			client4.setEmail("tardy.brice@wanadoo.fr");
			client4.setPrenom("Brice");
			client4.setTelephone("01.25.48.69.28");
			client4.setAdresse(adresse4);
			List<Compte> liste6= new ArrayList<Compte>();
			client4.setListeCompte(liste6);
			client4.getListeCompte().add(compte7);
			client4.getListeCompte().add(compte8);
			
			compte7.setClient(client4);
			compte8.setClient(client4);
			
//Client 5
			
			Adresse adresse5 = new Adresse();
			adresse5.setCodePostal("69100");
			adresse5.setNomDeRue("Lavoisier");
			adresse5.setNumeroDeRue("19");
			adresse5.setTypeDeRue("rue");
			adresse5.setVille("Villeurbanne");
			
			
			CompteCourant compte9=new CompteCourant();
			compte9.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte9.setSolde(10000D);
			compte9.setDecouvert(200D);
			
			CompteEpargne compte10= new CompteEpargne();
			compte10.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte10.setSolde(20000D);
			compte10.setTaux(2D);
			
			
			Client client5 = new Client();
			client5.setNom("CHAUVET");
			client5.setEmail("chauvet.sylvain@wanadoo.fr");
			client5.setPrenom("Sylvain");
			client5.setTelephone("01.25.48.69.28");
			client5.setAdresse(adresse5);
			List<Compte> liste7= new ArrayList<Compte>();
			client5.setListeCompte(liste7);
			client5.getListeCompte().add(compte9);
			client5.getListeCompte().add(compte10);
			
			compte9.setClient(client5);
			compte10.setClient(client5);
			
			
//Client 6
			
			Adresse adresse6 = new Adresse();
			adresse6.setCodePostal("69100");
			adresse6.setNomDeRue("Lavoisier");
			adresse6.setNumeroDeRue("19");
			adresse6.setTypeDeRue("rue");
			adresse6.setVille("Villeurbanne");
			
			
			CompteCourant compte11=new CompteCourant();
			compte11.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte11.setSolde(10000D);
			compte11.setDecouvert(200D);
			
			CompteEpargne compte12= new CompteEpargne();
			compte12.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte12.setSolde(20000D);
			compte12.setTaux(2D);
			
			
			Client client6 = new Client();
			client6.setNom("DAZZAZI");
			client6.setEmail("dazzazikarim@wanadoo.fr");
			client6.setPrenom("Karim");
			client6.setTelephone("01.25.48.69.28");
			client6.setAdresse(adresse6);
			List<Compte> liste8= new ArrayList<Compte>();
			client6.setListeCompte(liste8);
			client6.getListeCompte().add(compte11);
			client6.getListeCompte().add(compte12);
			
			compte11.setClient(client6);
			compte12.setClient(client6);
			
//Client 7
			
			Adresse adresse7 = new Adresse();
			adresse7.setCodePostal("69100");
			adresse7.setNomDeRue("Lavoisier");
			adresse7.setNumeroDeRue("19");
			adresse7.setTypeDeRue("rue");
			adresse7.setVille("Villeurbanne");
			
			
			CompteCourant compte13=new CompteCourant();
			compte13.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte13.setSolde(10000D);
			compte13.setDecouvert(200D);
			
			CompteEpargne compte14= new CompteEpargne();
			compte14.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte14.setSolde(20000D);
			compte14.setTaux(2D);
			
			
			Client client7 = new Client();
			client7.setNom("PANOUILLERES");
			client7.setEmail("panouilleres.vincent@wanadoo.fr");
			client7.setPrenom("Vincent");
			client7.setTelephone("01.25.48.69.28");
			client7.setAdresse(adresse7);
			List<Compte> liste9= new ArrayList<Compte>();
			client7.setListeCompte(liste9);
			client7.getListeCompte().add(compte13);
			client7.getListeCompte().add(compte14);
			
			compte13.setClient(client7);
			compte14.setClient(client7);
			
//Client 8
			
			Adresse adresse8 = new Adresse();
			adresse8.setCodePostal("69100");
			adresse8.setNomDeRue("Lavoisier");
			adresse8.setNumeroDeRue("19");
			adresse8.setTypeDeRue("rue");
			adresse8.setVille("Villeurbanne");
			
			
			CompteCourant compte15=new CompteCourant();
			compte15.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte15.setSolde(10000D);
			compte15.setDecouvert(200D);
			
			CompteEpargne compte16= new CompteEpargne();
			compte16.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte16.setSolde(20000D);
			compte16.setTaux(2D);
			
			
			Client client8 = new Client();
			client8.setNom("PATTEYN");
			client8.setEmail("patteyn.elise@wanadoo.fr");
			client8.setPrenom("Elise");
			client8.setTelephone("01.25.48.69.28");
			client8.setAdresse(adresse8);
			List<Compte> liste10= new ArrayList<Compte>();
			client8.setListeCompte(liste10);
			client8.getListeCompte().add(compte15);
			client8.getListeCompte().add(compte16);
			
			compte15.setClient(client8);
			compte16.setClient(client8);
			
//Client 9
			
			Adresse adresse9 = new Adresse();
			adresse9.setCodePostal("69100");
			adresse9.setNomDeRue("Lavoisier");
			adresse9.setNumeroDeRue("19");
			adresse9.setTypeDeRue("rue");
			adresse9.setVille("Villeurbanne");
			
			
			CompteCourant compte17=new CompteCourant();
			compte17.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte17.setSolde(10000D);
			compte17.setDecouvert(200D);
			
			CompteEpargne compte18= new CompteEpargne();
			compte18.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte18.setSolde(20000D);
			compte18.setTaux(2D);
			
			
			Client client9 = new Client();
			client9.setNom("THEODOROU");
			client9.setEmail("theodorou.thomas@wanadoo.fr");
			client9.setPrenom("Thomas");
			client9.setTelephone("01.25.48.69.28");
			client9.setAdresse(adresse9);
			List<Compte> liste11= new ArrayList<Compte>();
			client9.setListeCompte(liste11);
			client9.getListeCompte().add(compte17);
			client9.getListeCompte().add(compte18);
			
			compte17.setClient(client9);
			compte18.setClient(client9);
			
//Client 10
			
			Adresse adresse10 = new Adresse();
			adresse10.setCodePostal("69100");
			adresse10.setNomDeRue("Lavoisier");
			adresse10.setNumeroDeRue("19");
			adresse10.setTypeDeRue("rue");
			adresse10.setVille("Villeurbanne");
			
			
			CompteCourant compte19=new CompteCourant();
			compte19.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte19.setSolde(10000D);
			compte19.setDecouvert(200D);
			
			CompteEpargne compte20= new CompteEpargne();
			compte20.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte20.setSolde(20000D);
			compte20.setTaux(2D);
			
			
			Client client10 = new Client();
			client10.setNom("THOMAS");
			client10.setEmail("thomas.konrad@wanadoo.fr");
			client10.setPrenom("Konrad");
			client10.setTelephone("01.25.48.69.28");
			client10.setAdresse(adresse10);
			List<Compte> liste12= new ArrayList<Compte>();
			client10.setListeCompte(liste12);
			client10.getListeCompte().add(compte19);
			client10.getListeCompte().add(compte20);
			
			compte19.setClient(client10);
			compte20.setClient(client10);
			
//Client 11
			
			Adresse adresse11= new Adresse();
			adresse11.setCodePostal("69100");
			adresse11.setNomDeRue("Lavoisier");
			adresse11.setNumeroDeRue("19");
			adresse11.setTypeDeRue("rue");
			adresse11.setVille("Villeurbanne");
			
			
			CompteCourant compte21=new CompteCourant();
			compte21.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte21.setSolde(10000D);
			compte21.setDecouvert(200D);
			
			CompteEpargne compte22= new CompteEpargne();
			compte22.setDateOuverture(new Timestamp(1, 1, 1, 1, 1, 1, 1));
			compte22.setSolde(20000D);
			compte22.setTaux(2D);
			
			
			Client client11 = new Client();
			client11.setNom("CASTRO");
			client11.setEmail("castro.clement@wanadoo.fr");
			client11.setPrenom("Clement");
			client11.setTelephone("01.25.48.69.28");
			client11.setAdresse(adresse11);
			List<Compte> liste13= new ArrayList<Compte>();
			client11.setListeCompte(liste13);
			client11.getListeCompte().add(compte21);
			client11.getListeCompte().add(compte22);
			
			compte21.setClient(client11);
			compte22.setClient(client11);
			
			//Conseiller
			
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
	    	liste.add(client3);
	    	liste.add(client4);
	    	liste.add(client5);
	    	liste.add(client6);
	    	liste.add(client7);
	    	liste.add(client8);
	    	liste.add(client9);
	    	liste.add(client10);
	    	liste.add(client11);
	    	conseiller.setClients(liste);
	    	client.setConseiller(conseiller);
	    	client2.setConseiller(conseiller);
	    	client3.setConseiller(conseiller);
	    	client4.setConseiller(conseiller);
	    	client5.setConseiller(conseiller);
	    	client6.setConseiller(conseiller);
	    	client7.setConseiller(conseiller);
	    	client8.setConseiller(conseiller);
	    	client9.setConseiller(conseiller);
	    	client10.setConseiller(conseiller);
	    	client11.setConseiller(conseiller);
	    	
	    	gerant =new Gerant();
	    	gerant.setNom("Vincent");
	    	gerant.setRole("gerant");
	    	List<Conseiller> liste2= new ArrayList<Conseiller>();
	    	liste2.add(conseiller);
	    	gerant.setConseillers(liste2);
	    	conseiller.setGerant(gerant);
	    	
	    	
	    	daoGerant.save(gerant);
	    	
	    	
	    	//Virements
	    	
	    	Virement virement1 = new Virement();
	    	virement1.setDate(new Date(116, 5, 12));
	    	virement1.setMontant(2000D);
	    	daoVirement.save(virement1);
	    	
	    	Virement virement2 = new Virement();
	    	virement2.setDate(new Date(116, 6, 2));
	    	virement2.setMontant(1000D);
	    	daoVirement.save(virement2);
	    	
	    	Virement virement3 = new Virement();
	    	virement3.setDate(new Date(116, 7, 8));
	    	virement3.setMontant(20000D);
	    	daoVirement.save(virement3);
	    	
	    	Virement virement4 = new Virement();
	    	virement4.setDate(new Date(116, 8, 24));
	    	virement4.setMontant(1800D);
	    	daoVirement.save(virement4);
	    	
	    	Virement virement5 = new Virement();
	    	virement5.setDate(new Date(116, 9, 27));
	    	virement5.setMontant(7000D);
	    	daoVirement.save(virement5);
	    	
	    	Virement virement6 = new Virement();
	    	virement6.setDate(new Date(116, 10, 2));
	    	virement6.setMontant(512D);
	    	daoVirement.save(virement6);
	    	
	    	Virement virement7 = new Virement();
	    	virement7.setDate(new Date(116, 5, 9));
	    	virement7.setMontant(200D);
	    	daoVirement.save(virement7);
	    	
	    	Virement virement8 = new Virement();
	    	virement8.setDate(new Date(116, 8, 17));
	    	virement8.setMontant(3000D);
	    	daoVirement.save(virement8);
	    	
	    	Virement virement9 = new Virement();
	    	virement9.setDate(new Date(116, 9, 13));
	    	virement9.setMontant(4500D);
	    	daoVirement.save(virement9);
	    	
	    	Virement virement10 = new Virement();
	    	virement10.setDate(new Date(116, 7, 23));
	    	virement10.setMontant(10256D);
	    	daoVirement.save(virement10);
	    	
	    	Virement virement11 = new Virement();
	    	virement11.setDate(new Date(116, 07, 22));
	    	virement11.setMontant(5287D);
	    	daoVirement.save(virement11);
	    	
		
			
		
		

}
}
