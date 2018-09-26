/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.AnneeScolaireFacadeLocal;
import edu.support.entities.AnneeScolaire;
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
@RequestMapping("/anneescolaire")
public class AnneeScolaireController {
    
    @EJB(mappedName="java:app/edusupport/AnneeScolaireFacade")
    private AnneeScolaireFacadeLocal cfl;
    
    private final static String VUE_CREATE = "jsp/anneescolaire/create";
    private final static String VUE_EDIT = "jsp/anneescolaire/edit";
    private final static String VUE_LIST = "jsp/anneescolaire/list";
    private final static String VUE_VIEW = "jsp/anneescolaire/view";
    private final static String PATH_LIST = "/start#!/anneescolaires";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"dateDebut","dateFin","created","modified"});
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("anneescolaire")AnneeScolaire anneescolaire,BindingResult result ,HttpServletRequest request, @RequestParam Map<String,String> params) throws ParseException{
        if(result.hasErrors()){
            System.out.println(result.getFieldErrors().get(0).getRejectedValue() +" + "+result.getFieldErrors().get(0).getField());
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        //anneescolaire.setDateDebut(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateDebut")));
        //anneescolaire.setDateFin(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateFin")));
        anneescolaire.setCreated(new Date());
        anneescolaire.setModified(new Date());
        cfl.create(anneescolaire);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("anneescolaire", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("anneescolaire")AnneeScolaire anneescolaire ,@RequestParam Map<String,String> params,HttpServletRequest request) throws ParseException{
        //anneescolaire.setDateDebut(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateDebut")));
        //anneescolaire.setDateFin(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateFin")));
        anneescolaire.setModified(new Date());
        anneescolaire.setCreated(cfl.find(params.get("idanneescolaire")).getCreated());
        cfl.edit(anneescolaire);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("anneescolaire", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("anneesscolaires", cfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idanneescolaire")int id,HttpServletRequest request){
        AnneeScolaire c = cfl.find(id);
        cfl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
