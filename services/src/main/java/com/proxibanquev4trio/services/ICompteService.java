package com.proxibanquev4trio.services;

import java.util.List;

import com.proxibanquev4trio.domaine.Compte;

public interface ICompteService {
	
	public List<Compte> getAllCompte();
	
	public void virement(Compte compte1, Compte compte2, Double valeur);

}