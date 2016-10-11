package com.proxibanquev4trio.domaine;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;


/**
 * Classe Abstraite qui sert à factoriser les atributs commun aux gérants et aux conseillers
 * 
 * elle a pour attributs :
 * 
 * id : Long numéro d'identification du user
 * prenom : String prénom du user
 * nom : String nom du user
 * telephone : String telephone du user
 * adresse : Adresse adresse du user
 * role : String role du user
 * login : String login du user
 * pwd : String mot de passe du user
 * @author Lavelle-Rio-Blameble
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	protected String prenom;
	protected String nom;
	protected String telephone;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	protected Adresse adresse;
	
	private String role;
	protected String login;
	protected String pwd;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	
	
	
	

}
