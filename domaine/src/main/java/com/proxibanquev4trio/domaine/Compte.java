package com.proxibanquev4trio.domaine;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Classe abstraite compte, définissant les propriétés de base d'un compte
 * bancaire: 
 * 
 * id : long, numéro d'identification du compte
 *dateOuverture : Date date d'ouverture du compte
 *solde : double , solde du compte
 *type : String type de compte
 *client : Client client propriétaire du compte
 * 
 * @author Lavelle-Rio-Blameble 
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Compte {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Date dateOuverture;
    private Double solde;
    protected String type;

    @ManyToOne
	private Client client;
    
    /**
	 * Constructeur de la classe Compte avec comme paramètre :
	 * 
	 * @param id:
	 *            le numéro du compte : long,
	 * @param dateouverture:
	 *            la date d'ouverture du compte : Timestamp,
	 * @param solde:
	 *            le solde du compte : double
	 *            
	 */
    protected Compte(Long id, Timestamp dateouverture, Double solde) {
        this.id = id;
        this.dateOuverture = dateouverture;
        this.solde = solde;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(Date dateouverture) {
        this.dateOuverture = dateouverture;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public String getType() {
        return type;
    }

    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Compte() {
		super();
	}
}
