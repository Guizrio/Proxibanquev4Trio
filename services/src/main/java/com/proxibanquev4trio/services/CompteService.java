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
	
	public void virement(Compte compte1, Compte compte2, Double valeur){
		
		compte1.setSolde(compte1.getSolde()-valeur);
		compte2.setSolde(compte2.getSolde()+valeur);
		
		daoCompte.save(compte1);
		daoCompte.save(compte2);
		
	}

	public ICompteDao getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(ICompteDao daoCompte) {
		this.daoCompte = daoCompte;
	}

}
