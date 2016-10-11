package com.proxibanquev4trio.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.proxibanquev4trio.dao.ICompteDao;
import com.proxibanquev4trio.domaine.Compte;

@Component
public class CompteService implements ICompteService {
	
	
	@Inject
	ICompteDao daoCompte;
	
	
	public List<Compte> getAllCompte(){
		
		List<Compte> liste;
		
		liste=daoCompte.findAll();
		
		return liste;
		
	}
	


	public ICompteDao getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(ICompteDao daoCompte) {
		this.daoCompte = daoCompte;
	}

}
