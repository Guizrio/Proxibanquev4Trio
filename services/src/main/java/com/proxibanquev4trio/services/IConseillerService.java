package com.proxibanquev4trio.services;

import java.util.List;

import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.domaine.Conseiller;

public interface IConseillerService {

	Conseiller authentification(String login);
	
	public List<Conseiller> getAllConseiller();


	public void updateConseiller(Conseiller conseiller);


	public void creerConseiller(Conseiller conseiller);
	
	

}