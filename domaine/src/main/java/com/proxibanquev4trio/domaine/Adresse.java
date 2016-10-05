package com.proxibanquev4trio.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Cette classe est composée des propriétés suivantes : numéro de rue, type de rue (rue, avenue...), nom de rue, code postal et ville.
 *Ils permettent de composer une adresse postale.
 * @author Lavelle-Theodorou
 *
 */
@Entity
public class Adresse {
	
	//Attributs
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	private String numeroDeRue;
	private String typeDeRue;
	private String nomDeRue;
	private String codePostal;
	private String ville;
	
	//Getters Setters
	
	public String getNumeroDeRue() {
		return numeroDeRue;
	}
	public void setNumeroDeRue(String numeroDeRue) {
		this.numeroDeRue = numeroDeRue;
	}
	public String getTypeDeRue() {
		return typeDeRue;
	}
	public void setTypeDeRue(String typeDeRue) {
		this.typeDeRue = typeDeRue;
	}
	public String getNomDeRue() {
		return nomDeRue;
	}
	public void setNomDeRue(String nomDeRue) {
		this.nomDeRue = nomDeRue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	//Constructeur
	
	/**Constructeur de la classe Adresse
	 * @param numeroDeRue : String correpondant au numéro de la rue
	 * @param typeDeRue: String correspondant au type de rue
	 * @param nomDeRue: String correspondant au nom de la rue
	 * @param codePostal: int correspondant au code postal de la ville
	 * @param ville: String correspondant au nom de la ville
	 */
	public Adresse(String numeroDeRue, String typeDeRue, String nomDeRue, String codePostal, String ville) {
		super();
		this.numeroDeRue = numeroDeRue;
		this.typeDeRue = typeDeRue;
		this.nomDeRue = nomDeRue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Adresse() {
	}

	//Methodes
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		
		return numeroDeRue+" " + typeDeRue + " "+ nomDeRue +" " +codePostal+ " "+ville ;
		
	}
	

}
