package com.proxibanquev4trio.services;

import com.proxibanquev4trio.dao.IConseillerDao;
import com.proxibanquev4trio.domaine.Conseiller;
import org.springframework.stereotype.Component;

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
	

	
	public Conseiller Authentification(String login){
		
		Conseiller conseiller=null;
		
		conseiller=this.conseillerDao.findByLogin(login).get(0);

		return conseiller;
		
		
		
	}
	






	


	

}
