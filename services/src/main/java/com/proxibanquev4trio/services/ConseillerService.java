package com.proxibanquev4trio.services;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.proxibanquev4trio.dao.IConseillerDao;
import com.proxibanquev4trio.domaine.Conseiller;

@Component
public class ConseillerService implements IConseillerService {
	
	
	@Autowired
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
	

	
	public Conseiller Authentification(String login, String pwd){
		
		Conseiller conseiller=null;
		
		conseiller=this.conseillerDao.findByLogin(login).get(0);
		
		if(login.equals(conseiller.getLogin()) && pwd.equals(conseiller.getPwd())){
		return conseiller;
		}else{
			return null;
		}
		
		
		
	}
	
	public void test(){
		
		System.out.println("test");
	}






	


	

}
