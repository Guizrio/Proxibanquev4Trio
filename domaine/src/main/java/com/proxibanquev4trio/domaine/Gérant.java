package com.proxibanquev4trio.domaine;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Gérant extends Conseiller{
	
	@OneToMany(fetch=FetchType.EAGER)
	  protected List<Conseiller> conseillers;

	public List<Conseiller> getConseillers() {
		return conseillers;
	}

	public void setConseillers(List<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}
	
	

}
