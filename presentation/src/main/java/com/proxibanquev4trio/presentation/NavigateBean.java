package com.proxibanquev4trio.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Stagiaire on 12/09/2016.
 */
@ManagedBean
@Named
@SessionScoped
public class NavigateBean implements Serializable{

    private static final long serialVersionUID = 2L;

    private final static String BASE_PATH = "";

//    @ManagedProperty(value="#{errorBean}")
//    @Inject
//    private ErrorBean errorBean;

    public NavigateBean() {
    }

    /**
     * Permet d'effectuer une redirection vers la page de login de conseiller
     *
     * @return l'adresse de la page login
     */
    public String redirectToLogin(){
        return BASE_PATH + "/login.xhtml?faces-redirect=true";
    }

    /**
     * Permet de naviguer vers la page de login
     *
     * @return l'adresse relative de la page login
     */
    public String toLogin(){
        return BASE_PATH + "/login.xhtml";
    }




    public String redirectToRapportTransaction(){
        return BASE_PATH + "/rapporttransactions.xhtml?faces-redirect=true";
    }

    public String toRapportTransaction(){
    	return BASE_PATH + "/rapporttransactions.xhtml";
    }


    /**
     * Permet de rediriger vers la page des clients du conseiller
     *
     * @return l'adresse de la page menuconseiller
     */
    public String redirectToMenuConseiller(){
        return BASE_PATH + "/menuconseiller.xhtml?faces-redirect=true";
    }


    /**
     * Permet de naviguer vers la page des clients du conseiller
     *
     * @return l'adresse relative de la page menuconseiller
     */
    public String toMenuConseiller(){
        return BASE_PATH + "/menuconseiller.xhtml";
    }


    /**
     * Permet de rediriger vers la page des clients du conseiller
     *
     * @return l'adresse de la page menuconseiller
     */
    public String redirectToVirement(){
        return BASE_PATH + "/virement.xhtml?faces-redirect=true";
    }


    /**
     * Permet de naviguer vers la page pour faire des virements
     *
     * @return l'adresse relative de la page virement
     */
    public String toVirement(){
        return BASE_PATH + "/virement.xhtml";
    }



    /**
     * Permet de rediriger vers une page d'erreur personnalisée
     *
     * @return l'adresse de la page error.xhtml
     */
    public String redirectToError(String messagePerso){

//        try {
//
//            String urlEncoder = URLEncoder.encode(messagePerso, "UTF-8");   //Use URLDecoder.decode(url, "UTF-8") to reverse in bean error page
//            return "/secured_pages/error.xhtml?faces-redirect=true&message=" + urlEncoder;
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            return "/secured_pages/error.xhtml?faces-redirect=true";
//        }

//        errorBean.setMessage(messagePerso);
        return BASE_PATH + "/error.xhtml?faces-redirect=true";

    }


    /**
     * Permet de naviguer vers une page d'erreur personnalisée
     *
     * @return l'adresse relative de la page d'erreur
     */
    public String toError(String messagePerso){


//        try {
//
//            String urlEncoder = URLEncoder.encode(messagePerso, "UTF-8");   //Use URLDecoder.decode(url, "UTF-8") to reverse in bean error page
//            return "/secured_pages/error.xhtml?message=" + urlEncoder;
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            return "/secured_pages/error.xhtml";
//        }

//        errorBean.setMessage(messagePerso);
        return BASE_PATH + "/error.xhtml";

    }


//    public ErrorBean getErrorBean() {
//        return errorBean;
//    }
//
//    public void setErrorBean(ErrorBean errorBean) {
//        this.errorBean = errorBean;
//    }
    
    
    public String redirectToMenuGerant(){
    	return BASE_PATH + "/menugerant.xhtml?faces-redirect=true";
    }
}
