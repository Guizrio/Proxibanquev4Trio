package com.proxibanquev4trio.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.proxibanquev4trio.domaine.Conseiller;
import com.proxibanquev4trio.domaine.Gerant;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import javassist.expr.Instanceof;

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

	// @Inject
	// private AuthService authService;
	// private ConseillerService conseillerService;
	private Conseiller conseiller;

	public LoginBean() {
		loggedIn = false;
		// authService = new AuthService();
		// conseillerService = new ConseillerService();
		conseiller = null;
	}

	public boolean isGerant() {
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		request.getUserPrincipal();
		if (request.isUserInRole("admin")) {
			return false;
		} else {
			return true;
		}

	}

	public String doLogin() {

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
//	}
//
//	}catch(
//
//	DAOException e)
//	{
//
//            e.printStackTrace();
//            loggedIn = false;
//            conseiller = null;
//
//           ;
//
//        }
		return"plouf";
	}

	public String disconnect() {
//		loggedIn = false;
//		password = null;
//		login = null;
//
//		conseiller = null;
//
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
}
