package com.proxibanquev4trio.domaine;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


/**
 * Classe qui hérite de User et qui permet de gérer les gérants
 * 
 * elle a pour attributs :
 * 
 * conseillers : List<Conseiller> liste des conseillers de l'agence gérée par le gérant
 *@author Lavelle-Rio-Blameble
 */
@Entity
public class Gerant extends User{
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="gerant", cascade=CascadeType.PERSIST)
	  protected List<Conseiller> conseillers;
	
	
	 public Gerant() {
		    super();
		  }

	public List<Conseiller> getConseillers() {
		return conseillers;
	}

	public void setConseillers(List<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}
	
	

}
