package com.proxibanquev4trio.services;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.proxibanquev4trio.dao.IGerantDao;
import com.proxibanquev4trio.domaine.Conseiller;
import com.proxibanquev4trio.domaine.Gerant;

@Component
public class GerantService implements IGerantService {
	
	
	@Inject
	IGerantDao gerantDao;

	public IGerantDao getDaogerant() {
		return gerantDao;
	}

	public void setDaogerant(IGerantDao daogerant) {
		this.gerantDao = daogerant;
	}
	
	
	
	public Gerant authentification(String login){
		
		
		Gerant gerant=null;
		
		gerant=this.gerantDao.findByLogin(login);

		return gerant;
		
	}
	

}
