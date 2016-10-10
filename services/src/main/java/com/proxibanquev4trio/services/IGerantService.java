package com.proxibanquev4trio.services;

import com.proxibanquev4trio.domaine.Gerant;

public interface IGerantService {
	
	public Gerant authentification(String login);

}