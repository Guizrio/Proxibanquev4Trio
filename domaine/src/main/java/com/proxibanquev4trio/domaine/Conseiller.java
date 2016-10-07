package com.proxibanquev4trio.domaine;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * Classe permettant de manipuler des objets de type Conseiller, qui sont avant tout des {@link Humain}
 * <p>
 * Un conseiller possède un identifiant, un prenom, un nom, une {@link Adresse}, un login et un mot de passe.
 *
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
