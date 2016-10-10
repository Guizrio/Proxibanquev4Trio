package com.proxibanquev4trio.presentation;


import com.proxibanquev4trio.domaine.Adresse;
import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.domaine.Compte;
import com.proxibanquev4trio.logging.Loggable;
import com.proxibanquev4trio.services.IClientService;


import javax.annotation.PostConstruct;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Stagiaire on 13/09/2016.
 */
@ManagedBean(name = "menuConseillerBean")
@Named
@javax.faces.view.ViewScoped
public class MenuConseillerBean implements Serializable{

    private static final long serialVersionUID = 5L;


    private List<Client> clients;

    private Client selectedClient;

    private Client toModificateClient;

    private Client clientToCreate;

    private List<Compte> comptes;

    @Inject
    private LoginBean loginBean;

    @Inject
    IClientService clientService; // = new ClientService();

    public MenuConseillerBean() {
    }

    @PostConstruct
    public void init(){
        //On est obligé de faire cette méthode, parce que les injections ne sont pas réalisées avant la fin de la construction des constructeurs !!!!
        //        LoginBean loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");

        try {

            clients = clientService.findByConseiller(loginBean.getConseiller());

            clientToCreate = new Client();
            clientToCreate.setPrenom("Choisir un prenom");
            clientToCreate.setNom("Choisir un nom");
            Adresse adresse = new Adresse();
            adresse.setNomDeRue("Choisir un nom de rue");
            adresse.setNumeroDeRue("Choisir un numéro de rue");
            adresse.setCodePostal("Choisir un code postal");
            adresse.setVille("Choisir une ville");
            clientToCreate.setAdresse(adresse);
            clientToCreate.setEmail("Choisir un mail");
            clientToCreate.setTelephone("Choisir un num de telephone");

        } catch (Exception e) {
//            la ligne suivante n'est pas possible car sinon on sort du contexte géré par le listener de JSF
//                FacesContext.getCurrentInstance().getExternalContext().redirect(loginBean.getNavigateBean().redirectToError(e.getMessage()));
            FacesContext fc = FacesContext.getCurrentInstance();
            NavigationHandler nh = fc.getApplication().getNavigationHandler();
            nh.handleNavigation(fc, null, loginBean.getNavigateBean().redirectToError(e.getMessage()));

        }
    }

    public String doRefresh(){
//        LoginBean loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
//        ClientService clientService = new ClientService();

        try {

            clients = clientService.findByConseiller(loginBean.getConseiller());
            selectedClient = null;
            clientToCreate = new Client();
            clientToCreate.setPrenom("Choisir un prenom");
            clientToCreate.setNom("Choisir un nom");
            Adresse adresse = new Adresse();
            adresse.setNomDeRue("Choisir un nom de rue");
            adresse.setNumeroDeRue("Choisir un numéro de rue");
            adresse.setCodePostal("choisir un code postal");
            adresse.setVille("Choisir une ville");
            clientToCreate.setAdresse(adresse);
            clientToCreate.setEmail("Choisir un mail");
            clientToCreate.setTelephone("Choisir un num de telephone");


        } catch (Exception e) {

            e.printStackTrace();
            return loginBean.getNavigateBean().redirectToError(e.getMessage());
        }

        return null;
    }

    public String updateClient(){
//        ClientService clientService = new ClientService();
//        LoginBean loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");

        try {

            clientService.updateClient(selectedClient);
            return loginBean.getNavigateBean().redirectToMenuConseiller();

        } catch (Exception e) {
            e.printStackTrace();
            return loginBean.getNavigateBean().redirectToError(e.getMessage());
        }
    }

    public String creerClient(){
//        ClientService clientService = new ClientService();
//        LoginBean loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");

        clientToCreate.setConseiller(loginBean.getConseiller());

        try {

            clientService.creerClient(clientToCreate);
            return loginBean.getNavigateBean().redirectToMenuConseiller();

        } catch (Exception e) {
            e.printStackTrace();

            return loginBean.getNavigateBean().redirectToError(e.getMessage());
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }

    public Client getToModificateClient() {
        return toModificateClient;
    }

    public void setToModificateClient(Client toModificateClient) {
        this.toModificateClient = toModificateClient;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public Client getClientToCreate() {
        return clientToCreate;
    }

    public void setClientToCreate(Client clientToCreate) {
        this.clientToCreate = clientToCreate;
    }
}