package com.proxibanquev4trio.presentation;

import com.proxibanquev4trio.domaine.Conseiller;

public interface IUser {
	
	public Conseiller findByLogin(String login);

}
