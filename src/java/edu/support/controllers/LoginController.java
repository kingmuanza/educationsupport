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
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author N9-T
 */
@Controller
public class LoginController {
    @EJB(mappedName="java:app/edusupport/UtilisateurFacade")
    private UtilisateurFacadeLocal ufl;
    
    private final static String PATH_START = "url vers la vue start";
    private final static String PATH_AUTH = "url vers la vue d'authentification";
    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public ModelAndView handleFromAuth(@RequestParam Map<String,String>params, HttpServletRequest request){
        ModelAndView mv;
        String login = params.get("login");
        String pwd = params.get("motDePasse");
        Utilisateur u = ufl.findByCredentials(login, pwd);
        if(u != null){
            HttpSession session = request.getSession();
            session.setAttribute("utilisateur_courant", u);
            mv = new ModelAndView(PATH_START);
            return mv;
        }else{
            mv = new ModelAndView(PATH_AUTH);
            return mv;
        }
    }
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public ModelAndView getViewAuth(){
        ModelAndView mv = new ModelAndView(PATH_AUTH);
        return mv;
    }
}
