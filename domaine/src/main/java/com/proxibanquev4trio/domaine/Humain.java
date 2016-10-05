package com.proxibanquev4trio.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 * Classe abstraite Humain définissant les propriétés de base d'un humain:
 *  le nom : String, 
 *  le prénom : String, 
 *  l'adresse : Adresse, 
 *  le téléphone : String,
 *  un numéro d'identification : long.
 * 
 * @author Lavel-Theodorou
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Humain {

	// Attributs

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	protected String prenom;
	protected String nom;
	protected String telephone;
	
	@OneToOne
	protected Adresse adresse;

	// Getters Setters


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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	// Constructeur
		/**
		 * Constructeur de la classe Humain avec comme paramètres :
		 * 
		 * @param nom
		 *            : le nom de l'humain : String,
		 * @param prenom:
		 *            le prénom de l'humain : String,
		 * @param adresse:
		 *            l'adresse de l'humain : Adresse,
		 * @param telephone:
		 *            le téléphone de l'humain : String,
		 * @param numeroId:
		 *            le numéro d'identification de l'humain : int.
		 */
	public Humain(Long id, String prenom, String nom, Adresse adresse, String telephone) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	public Humain(){}
}
