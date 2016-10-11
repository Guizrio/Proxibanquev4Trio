package com.proxibanquev4trio.domaine;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 * Classe qui permet de creer un client
 * ses atributs sont :
 * 
 * id : Long numéro d'identification du client
 * prenom :String prénom du client
 * nom :String nom du client
 * telephone :String telephone du client
 * adresse :Adresse adresse du client
 * email :String email du client
 * listeCompte :List<Compte> liste de compte du client
 * conseiller :Conseiller conseiller du client
 * 
 * 
 * @author Lavelle-Rio-Blameble
 * 
 *
 */
@Entity
public class Client{
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	protected String prenom;
	protected String nom;
	protected String telephone;
	
	@OneToOne(cascade=CascadeType.ALL)
	protected Adresse adresse;
	
  private String email;
  
  @OneToMany(cascade=CascadeType.PERSIST, mappedBy="client", fetch=FetchType.EAGER)
  protected List<Compte> listeCompte;
  
  @ManyToOne(cascade=CascadeType.MERGE)
  private Conseiller conseiller;

  /**Constructeur de la classe Client, reprenant le constructeur de la classe Humain :
	 * @param firstname: le nom du client : String
	 * @param lastanme: le nom du client : String
	 * @param adresse: l'adresse du client : Adresse
	 * @param telephone: le numéro de téléphone du client : String
	 * @param id: le numéro ID du client : long
	 */
  
  
  public Client() {
    super();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }



public Conseiller getConseiller() {
	return conseiller;
}

public void setConseiller(Conseiller conseiller) {
	this.conseiller = conseiller;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) {
	this.telephone = telephone;
}

public Adresse getAdresse() {
	return adresse;
}

public void setAdresse(Adresse adresse) {
	this.adresse = adresse;
}

public List<Compte> getListeCompte() {
	return listeCompte;
}

public void setListeCompte(List<Compte> listeCompte) {
	this.listeCompte = listeCompte;
}

public boolean isDecouvert(){
	boolean decouvert=false;
	for (Compte e:listeCompte){
		if (e.getSolde()<0){
			decouvert=true;
		}
	}
	return decouvert;
	
}

  
}
