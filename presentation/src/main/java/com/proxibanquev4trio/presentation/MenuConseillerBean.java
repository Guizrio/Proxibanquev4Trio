package com.proxibanquev4trio.presentation;

import com.proxibanquev4trio.domaine.Adresse;
import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.domaine.Compte;
import com.proxibanquev4trio.logging.Loggable;
import com.proxibanquev4trio.services.IClientService;
import com.proxibanquev4trio.services.IConseillerService;

import javax.annotation.PostConstruct;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Stagiaire on 13/09/2016.
 */
@ManagedBean
@ViewScoped
public class MenuConseillerBean {

	private List<Client> clients;
	private Client selectedClient;
	private Client toModificateClient;

	private Client clientToCreate;

	private List<Compte> comptes;
	private LoginBean loginBean;
	private IClientService clientService;

	@PostConstruct
	public void init() {

		loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml");
		clientService = context.getBean(IClientService.class);
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
			e.printStackTrace();
		}
	}

	public MenuConseillerBean() {

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



	public String updateClient() {

//		LoginBean loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
//				.get("loginBean");

		try {

			clientService.updateClient(selectedClient);

		} catch (Exception e) {
			e.printStackTrace();
			return "erreurLogin.xhtml?faces-redirect=true";
			// return
			// loginBean.getNavigateBean().redirectToError(e.getMessage());
		}
		return "menuconseiller.xhtml?faces-redirect=true";
	}

	public String creerClient() {
		// ClientService clientService = new ClientService();
		// LoginBean loginBean = (LoginBean)
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");

		// clientToCreate.setConseiller(loginBean.getConseiller());

		try {

			clientService.creerClient(clientToCreate);
			// return loginBean.getNavigateBean().redirectToMenuConseiller();

		} catch (Exception e) {
			e.printStackTrace();

			// return
			// loginBean.getNavigateBean().redirectToError(e.getMessage());
		}
		return "menuconseiller.xhtml?faces-redirect=true";
	}
}
//
// public List<Client> getClients() {
// return clients;
// }
//
// public void setClients(List<Client> clients) {
// this.clients = clients;
// }
//
// public Client getSelectedClient() {
// return selectedClient;
// }
//
// public void setSelectedClient(Client selectedClient) {
// this.selectedClient = selectedClient;
// }
//
// public Client getToModificateClient() {
// return toModificateClient;
// }
//
// public void setToModificateClient(Client toModificateClient) {
// this.toModificateClient = toModificateClient;
// }
//
// public List<Compte> getComptes() {
// return comptes;
// }
//
// public void setComptes(List<Compte> comptes) {
// this.comptes = comptes;
// }
//
// public Client getClientToCreate() {
// return clientToCreate;
// }
//
// public void setClientToCreate(Client clientToCreate) {
// this.clientToCreate = clientToCreate;
// }
// }