package com.proxibanquev4trio.presentation;

//import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proxibanquev4trio.domaine.Conseiller;
import com.proxibanquev4trio.services.IConseillerService;
import java.io.Serializable;

/**
 * Created by Stagiaire on 12/09/2016.
 */

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String password;

	private boolean loggedIn;

	@Inject
	private IConseillerService conseillerService;

	private Conseiller conseiller;

	@ManagedProperty(value = "#{navigateBean}")
	@Inject
	private NavigateBean navigateBean;

	public LoginBean() {
		loggedIn = true;
		// authService = new AuthService();
		// conseillerService = new ConseillerService();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();

		String login = request.getUserPrincipal().getName();

		conseiller = conseillerService.authentification(login);
	}

	public boolean isGerant() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		if (request.isUserInRole("Gerant")) {
			return true;
		} else {
			return false;
		}

	}

	// public String doLogin() {

	// try {
	// boolean isValidConseiller = authService.authentification(login,
	// password);
	//
	// if(isValidConseiller){
	// loggedIn = true;
	// conseiller = conseillerService.lireUnConseiller(login);
	//
	// }else{
	// loggedIn = false;
	// conseiller = null;
	//
	// FacesMessage msg = new FacesMessage("Erreur de login ou de password
	// !", "MESSAGE D'ERREUR");
	// msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	// FacesContext.getCurrentInstance().addMessage(null, msg);
	// }
	//
	// }catch(
	//
	// DAOException e)
	// {
	//
	// e.printStackTrace();
	// loggedIn = false;
	// conseiller = null;
	//
	// ;
	//
	// }
	// return "plouf";
	// }

	public String disconnect() {
		loggedIn = false;
		password = null;
		login = null;
		//
		conseiller = null;
		//
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "plouf";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public void setNavigateBean(NavigateBean navigateBean) {
		this.navigateBean = navigateBean;
	}

	public NavigateBean getNavigateBean() {
		return navigateBean;
	}
}
