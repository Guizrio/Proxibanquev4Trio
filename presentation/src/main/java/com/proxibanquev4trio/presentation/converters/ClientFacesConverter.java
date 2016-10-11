package com.proxibanquev4trio.presentation.converters;

import com.proxibanquev4trio.domaine.Client;
import com.proxibanquev4trio.presentation.LoginBean;
import com.proxibanquev4trio.services.IClientService;
import org.springframework.context.ApplicationContext;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Stagiaire on 11/10/2016.
 */
@FacesConverter("clientConverter")
public class ClientFacesConverter implements Converter {


    LoginBean loginBean;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
//                IClientService service = (IClientService) fc.getExternalContext().getApplicationMap().get("clientService");
                loginBean = (LoginBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
                ApplicationContext context = loginBean.getContext();
                IClientService clientService = context.getBean(IClientService.class);

                Client client = clientService.findById(Long.parseLong(value));

                return client;

            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid client"));
            }
        }
        else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Client) object).getId());
        }
        else {
            return null;
        }
    }

}
