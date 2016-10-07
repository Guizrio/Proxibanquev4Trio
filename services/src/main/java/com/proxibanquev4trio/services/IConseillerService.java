package com.proxibanquev4trio.services;

import com.proxibanquev4trio.domaine.Conseiller;

public interface IConseillerService {

	Conseiller Authentification(String login, String pwd);
	
	

}