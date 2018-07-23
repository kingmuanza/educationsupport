/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.UtilisateurFacadeLocal;
import edu.support.entities.Utilisateur;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author N9-T
 */
@Controller
public class LoginController {
    @EJB(mappedName="java:app/edusupport/UtilisateurFacade")
    private UtilisateurFacadeLocal ufl;
    
    private final static String PATH_START = "/start";
    private final static String PATH_AUTH = "/";
    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public RedirectView handleFormAuth(@RequestParam Map<String,String>params, HttpServletRequest request){
        RedirectView mv;
        String login = params.get("login");
        String pwd = params.get("passe");
        Utilisateur u = ufl.findByCredentials(login, pwd);
        if(u != null){
            HttpSession session = request.getSession();
            session.setAttribute("utilisateur_courant", u);
            mv = new RedirectView(request.getContextPath()+PATH_START);
            return mv;
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("erreur_auth", "Login ou mot de passe incorrect");
            mv = new RedirectView(request.getContextPath()+PATH_AUTH);
            return mv;
        }
    }
    
}
