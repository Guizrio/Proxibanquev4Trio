package com.proxibanquev4trio.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Guillaume on 09/10/2016.
 */
@Entity
public class Virement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long idCrediteur;
    private Long idDebiteur;
    private double montant;



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
}
