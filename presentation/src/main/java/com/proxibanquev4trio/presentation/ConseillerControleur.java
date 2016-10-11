package com.proxibanquev4trio.presentation;

import com.proxibanquev4trio.domaine.Conseiller;
import com.proxibanquev4trio.domaine.User;
import com.proxibanquev4trio.services.IConseillerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Guillaume on 10/10/2016.
 */
@Controller
@RequestMapping("/login")
public class ConseillerControleur {


    @Inject
    IConseillerService conseillerService;

    @Inject
    LoginBean loginBean;

    private String sortie;

    @RequestMapping(value = {"/entry"}, method = {RequestMethod.GET, RequestMethod.POST})
    protected ModelAndView listeEmployes(HttpServletRequest request,
                                         HttpServletResponse response) throws Exception {
		/*
		 * Lancement du Service et récupération données en base
		 */
        String login=request.getUserPrincipal().getName();
        User user = conseillerService.authentification(login);       //@Todo ça va pas du tout dans la dao et service : un user peut etre un gerant !!!!

        if(user == null){

            loginBean.setPassword(null);
            loginBean.setLogin(null);
            loginBean.setUser(null);

        }else if(user instanceof Conseiller){

            loginBean.setUser(user);
            loginBean.setGerant(false);
            loginBean.setLogin(request.getParameter("login"));
            loginBean.setPassword(request.getParameter("password"));

        }else if (request.isUserInRole("Gerant")) {
                loginBean.setUser(user);
                loginBean.setGerant(true);
                loginBean.setLogin(request.getParameter("login"));
                loginBean.setPassword(request.getParameter("password"));
        } else {
            loginBean.setGerant(false);
            loginBean.setPassword(null);
            loginBean.setLogin(null);
            loginBean.setUser(null);
            throw new IllegalStateException("le user est d'un type non supporté actuellement, désolé !");
        }

		/*
		 * Envoi Vue + Modèle MVC pour Affichage données vue
		 */
        return new ModelAndView("menuconseiller");
    }

    @RequestMapping(value = {"/disconnect"}, method = {RequestMethod.GET, RequestMethod.POST})
    protected ModelAndView disconnect(HttpServletRequest request,
                                         HttpServletResponse response) throws Exception {
        request.getSession().invalidate();
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
        return new ModelAndView("test");
    }


    public String getSortie() {
        return "/pages/login/entry";
    }

    public void setSortie(String sortie) {
        this.sortie = sortie;
    }
}
