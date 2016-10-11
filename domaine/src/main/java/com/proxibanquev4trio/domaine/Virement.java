package com.proxibanquev4trio.domaine;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe qui sert à enregistrer les virements en base de données
 * 
 * elle a pour attributs :
 * 
 * id : Long identifiant du virement
 * idCrediteur : Long identifiant du compte créditeur
 * idDebiteur : Long identifiant du compte débiteur
 * montant : double montant du virement
 * date : Date date à laquelle a été effectué le virement
 * 
 * @author Lavelle-Rio-Blameble
 */
@Entity
@XmlRootElement
public class Virement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long idCrediteur;
    private Long idDebiteur;
    private double montant;
    private Date date;



    public Long getIdCrediteur() {
        return idCrediteur;
    }

    public void setIdCrediteur(Long idCrediteur) {
        this.idCrediteur = idCrediteur;
    }

    public Long getIdDebiteur() {
        return idDebiteur;
    }

    public void setIdDebiteur(Long idDebiteur) {
        this.idDebiteur = idDebiteur;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
    
}
