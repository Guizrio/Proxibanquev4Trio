package com.proxibanquev4trio.presentation;

import com.proxibanquev4trio.domaine.Adresse;
import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.domaine.Compte;
import com.proxibanquev4trio.domaine.Conseiller;
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
public class MenuGerantBean {

	private List<Conseiller> conseillers;
	private Conseiller selectedConseiller;
	private Conseiller toModificateConseiller;

	private Conseiller conseillerToCreate;

	private LoginBean loginBean;
	private IConseillerService conseillerService;

	@PostConstruct
	public void init() {

		loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
		ApplicationContext context = loginBean.getContext();
		// new ClassPathXmlApplicationContext("spring-service.xml");
		conseillerService = context.getBean(IConseillerService.class);
		try {
			if (loginBean.isGerant()) {
				conseillers = conseillerService.getAllConseiller();

				conseillerToCreate = new Conseiller();
				conseillerToCreate.setPrenom("Choisir un prenom");
				conseillerToCreate.setNom("Choisir un nom");
				Adresse adresse = new Adresse();
				adresse.setNomDeRue("Choisir un nom de rue");
				adresse.setNumeroDeRue("Choisir un numéro de rue");
				adresse.setCodePostal("Choisir un code postal");
				adresse.setVille("Choisir une ville");
				conseillerToCreate.setAdresse(adresse);
				conseillerToCreate.setTelephone("Choisir un num de telephone");
				conseillerToCreate.setLogin("Choisir un Login");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MenuGerantBean() {

	}

	public List<Conseiller> getConseillers() {
		return conseillers;
	}

	public void setConseillers(List<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}

	public Conseiller getSelectedConseiller() {
		return selectedConseiller;
	}

	public void setSelectedConseiller(Conseiller selectedConseiller) {
		this.selectedConseiller = selectedConseiller;
	}

	public Conseiller getToModificateConseiller() {
		return toModificateConseiller;
	}

	public void setToModificateConseiller(Conseiller toModificateConseiller) {
		this.toModificateConseiller = toModificateConseiller;
	}

	
	public Conseiller getConseillerToCreate() {
		return conseillerToCreate;
	}

	public void setConseillerToCreate(Conseiller conseillerToCreate) {
		this.conseillerToCreate = conseillerToCreate;
	}

	public String updateConseiller() {

		// LoginBean loginBean = (LoginBean)
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
		// .get("loginBean");

		try {

			conseillerService.updateConseiller(selectedConseiller);

		} catch (Exception e) {
			e.printStackTrace();
			return "erreurLogin.xhtml?faces-redirect=true";
			// return
			// loginBean.getNavigateBean().redirectToError(e.getMessage());
		}
		return "menugerant.xhtml?faces-redirect=true";
	}

	public String creerConseiller() {
		// ClientService clientService = new ClientService();
		// LoginBean loginBean = (LoginBean)
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");

		// clientToCreate.setConseiller(loginBean.getConseiller());

		try {

			conseillerService.creerConseiller(conseillerToCreate);

			// return loginBean.getNavigateBean().redirectToMenuConseiller();

		} catch (Exception e) {
			e.printStackTrace();

			// return
			// loginBean.getNavigateBean().redirectToError(e.getMessage());
		}
		return "menugerant.xhtml?faces-redirect=true";
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