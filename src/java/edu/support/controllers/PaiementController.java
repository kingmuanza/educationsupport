/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.EleveFacadeLocal;
import edu.support.dao.PaiementFacadeLocal;
import edu.support.dto.Notification;
import edu.support.entities.Eleve;
import edu.support.entities.Paiement;
import edu.support.services.SolvabiliteService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    
    @EJB(mappedName="java:app/edusupport/SolvabiliteServiceImpl")
    private SolvabiliteService solser;
    
    private final static String VUE_CREATE = "jsp/paiement/create";
    private final static String VUE_EDIT = "jsp/paiement/edit";
    private final static String VUE_LIST = "jsp/paiement/list";
    private final static String VUE_VIEW = "jsp/paiement/view";
    private final static String PATH_LIST = "/start#!/paiements";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","dateJour","eleveIdeleve"});
    }
    
    @ExceptionHandler(value=Exception.class)
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public RedirectView ExceptionHandler(HttpServletRequest request){
        Notification n = Notification.getExceptionNotification();
        HttpSession session = request.getSession();
        session.setAttribute("notification", n);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        mv.addObject("eleves", efl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("paiement")Paiement paiement,BindingResult result ,HttpServletRequest request ,@RequestParam Map<String,String> params) throws ParseException{
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        paiement.setDateJour(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateJour")));
        paiement.setEleveIdeleve(efl.find(Integer.parseInt(params.get("eleveIdeleve"))));
        paiement.setCreated(new Date());
        paiement.setModified(new Date());
        pfl.create(paiement);
        Notification.enregistrementNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("eleves", efl.findAll());
        mv.addObject("paiement", pfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("paiement")Paiement paiement ,@RequestParam Map<String,String> params, HttpServletRequest request) throws ParseException{
        paiement.setModified(new Date());
        paiement.setCreated(pfl.find(Integer.parseInt(params.get("idpaiement"))).getCreated());
        paiement.setDateJour(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateJour")));
        paiement.setEleveIdeleve(efl.find(Integer.parseInt(params.get("eleveIdeleve"))));
        pfl.edit(paiement);
        Notification.modificationNotification(request);
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
        Notification.suppressionNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/insolvables/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getInsolvables() throws ParseException{
        ModelAndView mv = new ModelAndView("jsp/paiement/insolvables");
        mv.addObject("eleves", getInsolvablesList());
        mv.addObject("solvabiliteService", solser);
        return mv;
    }
    
    // processing methods
    
    private boolean isSolvable(Eleve e) {
        double som = 0.0;
        for(Paiement p: e.getPaiementCollection())
            som += p.getMontant();
        return e.getSalleDeClasseIdsalleDeClasse().getClasseIdclasse().getFraisScolarite() <= som;
    }
    
    private List<Eleve> getInsolvablesList(){
        List<Eleve> le = new ArrayList<Eleve>();
        for(Eleve e: efl.findAll()){
            if(!isSolvable(e))
                le.add(e);
        }
        return le;
    }
    
    public double getMontantPaye(Eleve e){
        double montant = 0.0;
        for(Paiement p: e.getPaiementCollection())
            montant += p.getMontant();
        return montant;
    }
    
    public double getMontantRestant(Eleve e){
        double montant = 0.0;
        for(Paiement p: e.getPaiementCollection())
            montant += p.getMontant();
        return e.getSalleDeClasseIdsalleDeClasse().getClasseIdclasse().getFraisScolarite() - montant;
    }
}
