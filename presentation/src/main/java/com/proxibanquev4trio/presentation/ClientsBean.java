package com.proxibanquev4trio.presentation;

import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.services.IClientService;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.List;

/**
 * Created by Stagiaire on 11/10/2016.
 */
@ManagedBean
@ViewScoped
public class ClientsBean {


    LoginBean loginBean;

    private List<Client> clients;


    public ClientsBean() {
    }

    @PostConstruct
    public void init(){
        loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
        ApplicationContext context = loginBean.getContext();
        IClientService clientService = context.getBean(IClientService.class);

        clients = clientService.getAllClient();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
