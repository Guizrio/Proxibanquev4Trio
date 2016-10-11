package com.proxibanquev4trio.domaine;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * Classe qui hérite de User et qui permet de gérer les conseillers
 * 
 * elle a pour attributs :
 * 
 * clients : List<Client> liste des clients du conseiller
 * gerant : Gerant gérant du conseiller
 *@author Lavelle-Rio-Blameble
 */
@Entity
public class Conseiller  extends User{
  
  
  @OneToMany(fetch=FetchType.EAGER , mappedBy="conseiller", cascade=CascadeType.PERSIST)
  protected List<Client> clients;
  
  @ManyToOne(cascade=CascadeType.PERSIST)
  protected Gerant gerant;

  /**
   * Constructeur de la classe Conseiller avec comme paramètres :
   *
   * @param id        :
   *                  le numéro d'identification de l'humain : long.
   * @param firstname le prénom de l'humain : String,
   * @param lastname  : le nom de l'humain : String,
   * @param adresse   l'adresse de l'humain : Adresse,
   * @param telephone :
   *                  le téléphone de l'humain : String,
   */
 

  public Conseiller() {
    super();
  }

  public List<Client> getClients() {
    return clients;
  }

  public void setClients(List<Client> class1) {
    this.clients = class1;
  }

public Gerant getGerant() {
	return gerant;
}

public void setGerant(Gerant gerant) {
	this.gerant = gerant;
}
  
}
