package com.proxibanquev4trio.presentation.converters;

import com.proxibanquev4trio.domaine.Compte;
import com.proxibanquev4trio.services.ICompteService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


/**
 * Created by Stagiaire on 11/10/2016.
 */
@FacesConverter("compteConverter")
public class CompteFacesConverter implements Converter {

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                ICompteService service = (ICompteService) fc.getExternalContext().getApplicationMap().get("compteService");
                return service.getAllCompte().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid compte"));
            }
        }
        else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Compte) object).getId());
        }
        else {
            return null;
        }
    }

}
