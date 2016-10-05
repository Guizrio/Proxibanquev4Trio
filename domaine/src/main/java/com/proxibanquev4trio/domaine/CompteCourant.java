package com.proxibanquev4trio.domaine;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Classe CompteCourant qui hérite de la classe Compte.
 * Elle ajoute les propriétés:
 * decouvert: qui est le montant de l'autorisation de découvert du compte : double,
 * @author 
 *
 */
@Entity
public class CompteCourant extends Compte {
    
	private Double decouvert;
	
	@OneToOne
	private Client client;

    
    
    /**Constructeur de la classe CompteCourant avec comme paramètres :
	 * @param id: le numéro du compte: long,
	 * @param dateouverture: la date d'ouverture du compte : Timestamp,
	 * @param solde: le solde : double
	 * 
	 */
    public CompteCourant(Long id, Timestamp dateouverture, Double solde) {

        super(id, dateouverture, solde);
        type = "Courant";
    }


public CompteCourant (){
	
}
   



	public Double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Double decouvert) {
        this.decouvert = decouvert;
    }



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}
    
}
