package com.proxibanquev4trio.domaine;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Guillaume on 09/10/2016.
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
