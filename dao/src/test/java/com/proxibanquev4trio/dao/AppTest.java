package com.proxibanquev4trio.dao;

import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.domaine.Conseiller;
import com.proxibanquev4trio.domaine.Gerant;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Stagiaire on 05/10/2016.
 */
public class AppTest  {


	private Client client;
	private Conseiller conseiller;
	private Gerant gerant;

	private ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spring-dao.xml");
	private IClientDao daoClient = (IClientDao) appContext.getBean(IClientDao.class);
	private IConseillerDao daoConseiller = (IConseillerDao) appContext.getBean(IConseillerDao.class);
	private IGerantDao daoGerant = (IGerantDao) appContext.getBean(IGerantDao.class);



	@Test
	public void testFindClientById() {

		long id = 3L;
		Client liste;

		liste = daoClient.findById(id);
		System.out.println(liste.getNom());
	}

	@Test
	public void testUpdateClient() {

		Client client = daoClient.findById(3L);
		client.setNom("Dubois");
		daoClient.save(client);
		client = daoClient.findById(3L);

		System.out.println(client.getNom());
	}

	@Test
	public void testFindConseillerByLogin() {

		String login = "login1";
		Conseiller liste;

		liste = daoConseiller.findByLogin(login);
		System.out.println(liste.getNom());
		System.out.println(liste.getPwd());
		System.out.println(liste.getClients().get(0).getNom());
	}

}
