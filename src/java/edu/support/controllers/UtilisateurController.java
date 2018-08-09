/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.DroitAccesFacadeLocal;
import edu.support.dao.UtilisateurFacadeLocal;
import edu.support.entities.Utilisateur;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
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
@RequestMapping("/utilisateur")
public class UtilisateurController {
    
    @EJB(mappedName="java:app/edusupport/UtilisateurFacade")
    private UtilisateurFacadeLocal cfl;
    
    @EJB(mappedName="java:app/edusupport/DroitAccesFacade")
    private DroitAccesFacadeLocal dafl;
    
    private final static String VUE_CREATE = "jsp/utilisateur/create";
    private final static String VUE_EDIT = "jsp/utilisateur/edit";
    private final static String VUE_LIST = "jsp/utilisateur/list";
    private final static String VUE_VIEW = "jsp/utilisateur/view";
    private final static String PATH_LIST = "/utilisateur/list";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","droitAccesIddroitAcces"});
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        mv.addObject("droitacces", dafl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("utilisateur")Utilisateur utilisateur,BindingResult result ,HttpServletRequest request,@RequestParam Map<String,String> params){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        utilisateur.setDroitAccesIddroitAcces(dafl.find(Integer.parseInt(params.get("droitAccesIddroitAcces"))));
        utilisateur.setCreated(new Date());
        utilisateur.setModified(new Date());
        cfl.create(utilisateur);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("utilisateur", cfl.find(id));
        
        mv.addObject("droitacces", dafl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("utilisateur")Utilisateur utilisateur ,@RequestParam Map<String,String> params,HttpServletRequest request){
        utilisateur.setModified(new Date());
        utilisateur.setDroitAccesIddroitAcces(dafl.find(Integer.parseInt(params.get("droitAccesIddroitAcces"))));
        utilisateur.setCreated(cfl.find(Integer.parseInt(params.get("idutilisateur"))).getCreated());
        cfl.edit(utilisateur);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("utilisateur", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("utilisateurs", cfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idutilisateur")int id,HttpServletRequest request){
        Utilisateur c = cfl.find(id);
        cfl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
