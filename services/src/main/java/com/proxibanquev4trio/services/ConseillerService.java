package com.proxibanquev4trio.services;

import com.proxibanquev4trio.dao.IConseillerDao;
import com.proxibanquev4trio.domaine.Conseiller;
import com.proxibanquev4trio.logging.Loggable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@Component
public class ConseillerService implements IConseillerService {
	
	
	@Inject
	private IConseillerDao conseillerDao;
	
	
	
	public ConseillerService(IConseillerDao dao){
		
		this.conseillerDao=dao;
	}


	public ConseillerService() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.proxibanquev4trio.services.IConseillerService#Authentification(java.lang.String, java.lang.String)
	 */
	

	@Loggable
	public Conseiller authentification(String login){
		
		Conseiller conseiller=null;
		
		conseiller=this.conseillerDao.findByLogin(login);

		return conseiller;
		
	}
	
	public List<Conseiller> getAllConseiller(){
		
		List<Conseiller> liste;
		
		liste=conseillerDao.findAll();
		
		return liste;
		
		
	}


	public IConseillerDao getConseillerDao() {
		return conseillerDao;
	}


	public void setConseillerDao(IConseillerDao conseillerDao) {
		this.conseillerDao = conseillerDao;
	}


	
	






	


	

}
