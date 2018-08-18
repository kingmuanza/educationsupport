/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.UtilisateursFonctionnalitesFacadeLocal;
import edu.support.dao.FonctionnaliteFacadeLocal;
import edu.support.dao.UtilisateurFacadeLocal;
import edu.support.entities.UtilisateursFonctionnalites;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author N9-T
 */
@Controller
@RequestMapping("/utilisateurfonctionnalite")
public class UtilisateurFonctionnaliteController {
    
    @EJB(mappedName="java:app/edusupport/UtilisateursFonctionnalitesFacade")
    private UtilisateursFonctionnalitesFacadeLocal uffl;
    
    @EJB(mappedName="java:app/edusupport/UtilisateurFacade")
    private UtilisateurFacadeLocal ufl;
    
    @EJB(mappedName="java:app/edusupport/FonctionnaliteFacade")
    private FonctionnaliteFacadeLocal ffl;
    
    private final static String VUE_CREATE = "jsp/utilisateurfonctionnalite/create";
    private final static String VUE_EDIT = "jsp/utilisateurfonctionnalite/edit";
    private final static String VUE_LIST = "jsp/utilisateurfonctionnalite/list";
    private final static String VUE_VIEW = "jsp/utilisateurfonctionnalite/view";
    private final static String PATH_LIST = "/start#!/utilisateursfonctionnalites";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","fonctionnaliteIdfonctionnalite","utilisateurIdutilisateur"});
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("utilisateurFonctionnalite")UtilisateursFonctionnalites utilisateurFonctionnalite,BindingResult result ,HttpServletRequest request){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        String Utilisateur = request.getParameter("utilisateurIdutilisateur");
        String[] fonctionnalites = request.getParameterValues("fonctionnaliteIdfonctionnalite");
        utilisateurFonctionnalite.setUtilisateurIdutilisateur(ufl.find(Integer.parseInt(Utilisateur)));
        for(String m: fonctionnalites){
            utilisateurFonctionnalite.setFonctionnaliteIdfonctionnalite(ffl.find(Integer.parseInt(m)));
            utilisateurFonctionnalite.setCreated(new Date());
            utilisateurFonctionnalite.setModified(new Date());
            uffl.create(utilisateurFonctionnalite);
        }
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("utilisateurFonctionnalite", uffl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("utilisateurFonctionnalite")UtilisateursFonctionnalites utilisateurFonctionnalite ,@RequestParam("idutilisateursFonctionnalites")int id,HttpServletRequest request){
        utilisateurFonctionnalite.setModified(new Date());
        utilisateurFonctionnalite.setCreated(uffl.find(id).getCreated());
        utilisateurFonctionnalite.setFonctionnaliteIdfonctionnalite(ffl.find(Integer.parseInt(request.getParameter("fonctionnaliteIdfonctionnalite"))));
        uffl.edit(utilisateurFonctionnalite);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("idutilisateursFonctionnalites")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("utilisateurFonctionnalite", uffl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("utilisateursFonctionnalites", uffl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idutilisateursFonctionnalites")int id,HttpServletRequest request){
        UtilisateursFonctionnalites cm = uffl.find(id);
        uffl.remove(cm);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
