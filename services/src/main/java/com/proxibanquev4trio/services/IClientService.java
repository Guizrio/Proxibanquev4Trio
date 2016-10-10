package com.proxibanquev4trio.services;

import java.util.List;

import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.domaine.Conseiller;

public interface IClientService {

	void updateClient(Client client);

	void creerClient(Client client);

	List<Client> findByConseiller(Conseiller conseiller);
	
	public List<Client> getAllClient();
	

}