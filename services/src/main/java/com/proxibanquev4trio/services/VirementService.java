package com.proxibanquev4trio.services;

import com.proxibanquev4trio.dao.ICompteDao;
import com.proxibanquev4trio.dao.IVirementDao;
import com.proxibanquev4trio.domaine.Compte;
import com.proxibanquev4trio.domaine.Virement;
import com.proxibanquev4trio.logging.Loggable;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

/**
 * Created by Guillaume on 09/10/2016.
 */
@Component
public class VirementService implements IVirementService {
	
	
	@Inject
	IVirementDao virementDao;
	
	@Inject
	ICompteDao daoCompte;
	
	
	public List<Virement> getAllVirement(){
		
		return virementDao.findAll();
		
	}

	public void virement(Compte compte1, Compte compte2, Double valeur){
		
		compte1.setSolde(compte1.getSolde()-valeur);
		compte2.setSolde(compte2.getSolde()+valeur);
		
		daoCompte.save(compte1);
		daoCompte.save(compte2);
		
		Virement virement = new Virement();
		virement.setDate(new Date(System.currentTimeMillis()));
		virement.setIdCrediteur(compte1.getId());
		virement.setIdDebiteur(compte2.getId());
		virement.setMontant(valeur);
		
		virementDao.save(virement);
		
		
	}

    



	@Override
	public List<Virement> getAllVirementBetween(Date date1, Date date2) {
		// TODO Auto-generated method stub
		return null;
	}



	public IVirementDao getVirementDao() {
		return virementDao;
	}



	public void setVirementDao(IVirementDao virementDao) {
		this.virementDao = virementDao;
	}



	public ICompteDao getDaoCompte() {
		return daoCompte;
	}



	public void setDaoCompte(ICompteDao daoCompte) {
		this.daoCompte = daoCompte;
	}


}
