package com.proxibanquev4trio.presentation;

import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.domaine.Compte;
import com.proxibanquev4trio.services.IClientService;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Stagiaire on 11/10/2016.
 */
@ManagedBean
@ViewScoped
public class VirementBean {

    LoginBean loginBean;
    IClientService clientService;

    private List<Client> clients;

    private HashMap<Client, List<Compte>> hashMapComptes;


    private List<Compte> comptesDuDebiteur;
    private List<Compte> comptesDuCrediteur;


    private Client clientCrediteur;
    private Client clientDebiteur;

    private Compte compteCrediteur;
    private Compte compteDebiteur;


    private Client clientdefault;


    public VirementBean() {
    }

    @PostConstruct
    public void init(){
        loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
        ApplicationContext context = loginBean.getContext();
        clientService = context.getBean(IClientService.class);


        clients = clientService.getAllClient();
        clientdefault = new Client();
        clientdefault.setNom("default");

    }


    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }


    public Client getClientCrediteur() {
        return clientCrediteur;
    }

    public void setClientCrediteur(Client clientCrediteur) {
        this.clientCrediteur = clientCrediteur;
    }

    public Client getClientDebiteur() {
        return clientDebiteur;
    }

    public void setClientDebiteur(Client clientDebiteur) {
        this.clientDebiteur = clientDebiteur;
    }

    public Compte getCompteCrediteur() {
        return compteCrediteur;
    }

    public void setCompteCrediteur(Compte compteCrediteur) {
        this.compteCrediteur = compteCrediteur;
    }

    public Compte getCompteDebiteur() {
        return compteDebiteur;
    }

    public void setCompteDebiteur(Compte compteDebiteur) {
        this.compteDebiteur = compteDebiteur;
    }




    public void updateCompteDebiteur(ValueChangeEvent event){
        System.out.println(event.getNewValue());
        comptesDuDebiteur = clientDebiteur.getListeCompte();
    }


    public void setComptesDuDebiteur(List<Compte> comptesDuDebiteur) {
        this.comptesDuDebiteur = comptesDuDebiteur;
    }

    public void setComptesDuCrediteur(List<Compte> comptesDuCrediteur) {
        this.comptesDuCrediteur = comptesDuCrediteur;
    }

    public List<Compte> getComptesDuDebiteur() {

        if(clientDebiteur != null){
            return clientDebiteur.getListeCompte();
        }else{
            return new ArrayList<>();
        }

    }

    public List<Compte> getComptesDuCrediteur() {
        return comptesDuCrediteur;
    }

    public Client getClientdefault() {
        return clientdefault;
    }

}
