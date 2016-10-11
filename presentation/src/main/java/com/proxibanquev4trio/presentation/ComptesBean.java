package com.proxibanquev4trio.presentation;

import com.proxibanquev4trio.domaine.Compte;
import com.proxibanquev4trio.services.ICompteService;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Stagiaire on 11/10/2016.
 */
@ManagedBean
@ViewScoped
public class ComptesBean {

    LoginBean loginBean;
    VirementBean virementBean;

    private List<Compte> comptes;


    public ComptesBean() {
    }

    @PostConstruct
    public void init(){
        loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
        ApplicationContext context = loginBean.getContext();
        ICompteService compteService = context.getBean(ICompteService.class);

        comptes = compteService.getAllCompte();
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
}
