package com.proxibanquev4trio.presentation;


import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.domaine.Compte;
import com.proxibanquev4trio.logging.Loggable;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Stagiaire on 13/09/2016.
 */
@ManagedBean
@ViewScoped
@Component
public class MenuConseillerBean {

    private List<Client> clients;
    private Client selectedClient;
    private Client toModificateClient;

    private Client clientToCreate;

    private List<Compte> comptes;


    public MenuConseillerBean() {
        LoginBean loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
//        ClientService clientService = new ClientService();
//
//        try {
//
//            clients = clientService.lireToutesLesClientsByidConseiller(loginBean.getConseiller());
//
//            clientToCreate = new Client();
//            clientToCreate.setPrenom("Choisir un prenom");
//            clientToCreate.setNom("Choisir un nom");
//            Adresse adresse = new Adresse();
//            adresse.setNomDeRue("Choisir un nom de rue");
//            adresse.setNumeroDeRue("Choisir un numéro de rue");
//            adresse.setCodePostal("69003");
//            adresse.setVille("Choisir une ville");
//            clientToCreate.setAdresse(adresse);
//            clientToCreate.setEmail("Choisir un mail");
//            clientToCreate.setTelephone("Choisir un num de telephone");
//
//        } catch (DAOException e) {
////            la ligne suivante n'est pas possible car sinon on sort du contexte géré par le listener de JSF
////                FacesContext.getCurrentInstance().getExternalContext().redirect(loginBean.getNavigateBean().redirectToError(e.getMessage()));
//                FacesContext fc = FacesContext.getCurrentInstance();
//                NavigationHandler nh = fc.getApplication().getNavigationHandler();
//                nh.handleNavigation(fc, null, "plouf");
//
//        }



    }


//    public String doRefresh(){
//        LoginBean loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
//        ClientService clientService = new ClientService();
//
//        try {
//
//            clients = clientService.lireToutesLesClientsByidConseiller(loginBean.getConseiller());
//            selectedClient = null;
//            clientToCreate = new Client();
//            clientToCreate.setPrenom("Choisir un prenom");
//            clientToCreate.setNom("Choisir un nom");
//            Adresse adresse = new Adresse();
//            adresse.setNomDeRue("Choisir un nom de rue");
//            adresse.setNumeroDeRue("Choisir un numéro de rue");
//            adresse.setCodePostal("69003");
//            adresse.setVille("Choisir une ville");
//            clientToCreate.setAdresse(adresse);
//            clientToCreate.setEmail("Choisir un mail");
//            clientToCreate.setTelephone("Choisir un num de telephone");
//
//
//        } catch (DAOException e) {
//
//            e.printStackTrace();
//            return "plouf";
//        }
//
//        return null;
//    }

    @Loggable
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
