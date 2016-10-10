package com.proxibanquev4trio.presentation;

import com.proxibanquev4trio.domaine.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

//import javax.faces.application.FacesMessage;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Stagiaire on 12/09/2016.
 */

@Component
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	private User user;
	private boolean gerant;

	public LoginBean() {
	}
	
	@PostConstruct
	public void init() {

	}

	public String disconnect() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.jsp?faces-redirect=true";
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


	public boolean isGerant() {
		return gerant;
	}

	public void setGerant(boolean gerant) {
		this.gerant = gerant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

