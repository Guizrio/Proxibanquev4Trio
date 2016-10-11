package com.proxibanquev4trio.domaine;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Classe CompteEpargne qui hérite de la classe Compte.
 * Elle ajoute les propriétés:
 * tauxremuneration: qui est le montant des intérêts : double,
 * @author 
 *
 */
@Entity
public class CompteEpargne extends Compte{
   
	private Double taux;


    /**
	 * Constructeur de la classe CompteEpargne avec comme paramètres :
	 * @param id: le numéro du compte: long,
	 * @param dateouverture: la date d'ouverture du compte : Timestamp,
	 * @param solde: solde du compte : double.
	 *
	 */
    public CompteEpargne(Long id, Timestamp dateouverture, Double solde) {
        super(id, dateouverture, solde);
        type = "Epargne";
    }
    
    public CompteEpargne(){
    	
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    
}
