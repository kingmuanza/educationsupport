/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author N9-T
 */
@Controller
public class HomeController {
    
     
    
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request){
        HttpSession session = request.getSession();
        String erreur_auth = (String) session.getAttribute("erreur_auth");
        session.setAttribute("erreur_auth", null);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("erreur_auth", erreur_auth);
        return mv;
    }
    
    
    
}
