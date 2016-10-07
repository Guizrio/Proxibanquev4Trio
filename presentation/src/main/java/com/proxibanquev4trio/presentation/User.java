package com.proxibanquev4trio.presentation;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.proxibanquev4trio.domaine.Conseiller;
import com.proxibanquev4trio.services.IConseillerService;


@Component
public class User implements IUser {

	@Inject
	IConseillerService conseillerService;
	
	
	public Conseiller findByLogin(String login){
		
		return conseillerService.Authentification(login);
	}
	
}
