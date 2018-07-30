/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.EleveFacadeLocal;
import edu.support.dao.PaiementFacadeLocal;
import edu.support.entities.Eleve;
import edu.support.entities.Paiement;
import edu.support.utils.StaticVars;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@RequestMapping("/paiement")
public class PaiementController {
    
    @EJB(mappedName="java:app/edusupport/PaiementFacade")
    private PaiementFacadeLocal pfl;
    
    @EJB(mappedName="java:app/edusupport/EleveFacade")
    private EleveFacadeLocal efl;
    
    private final static String VUE_CREATE = "jsp/paiement/create";
    private final static String VUE_EDIT = "jsp/paiement/edit";
    private final static String VUE_LIST = "jsp/paiement/list";
    private final static String VUE_VIEW = "jsp/paiement/view";
    private final static String PATH_LIST = "/paiement/list";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified"});
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("paiement")Paiement paiement,BindingResult result ,HttpServletRequest request){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        paiement.setCreated(new Date());
        paiement.setModified(new Date());
        pfl.create(paiement);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("paiement", pfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("paiement")Paiement paiement ,@RequestParam("idpaiement")int id,HttpServletRequest request){
        paiement.setModified(new Date());
        paiement.setCreated(pfl.find(id).getCreated());
        pfl.edit(paiement);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("paiement", pfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("paiements", pfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idpaiement")int id,HttpServletRequest request){
        Paiement c = pfl.find(id);
        pfl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getInsolvables() throws ParseException{
        ModelAndView mv = new ModelAndView("jsp/paiement/insolvables");
        mv.addObject("insolvables", efl.findAll().removeAll(getInsolvablesList()));
        return mv;
    }
    
    // processing methods
    
    private boolean isSolvable(Eleve e) {
        double som = 0.0;
        for(Paiement p: e.getPaiementCollection())
            som += p.getMontant();
        return StaticVars.FRAIS_EXIGIBLES <= som;
    }
    
    private List<Eleve> getInsolvablesList(){
        List<Eleve> le = new ArrayList<Eleve>();
        for(Eleve e: efl.findAll()){
            if(!isSolvable(e))
                le.add(e);
        }
        return le;
    }
}
