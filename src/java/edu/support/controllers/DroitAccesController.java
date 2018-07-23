/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.DroitAccesFacadeLocal;
import edu.support.entities.DroitAcces;
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
@RequestMapping("/droitacces")
public class DroitAccesController {
    
    @EJB(mappedName="java:app/edusupport/DroitAccesFacade")
    private DroitAccesFacadeLocal cfl;
    
    private final static String VUE_CREATE = "jsp/droitacces/create";
    private final static String VUE_EDIT = "jsp/droitacces/edit";
    private final static String VUE_LIST = "jsp/droitacces/list";
    private final static String VUE_VIEW = "jsp/droitacces/view";
    private final static String PATH_LIST = "/droitacces/list";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified"});
    }
    
    @RequestMapping(value="/create", method=RequestMethod.GET)
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("droitacces")DroitAcces droitacces,BindingResult result ,HttpServletRequest request){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        droitacces.setCreated(new Date());
        droitacces.setModified(new Date());
        cfl.create(droitacces);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("droitacces", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("droitacces")DroitAcces droitacces ,@RequestParam("iddroitacces")int id,HttpServletRequest request){
        droitacces.setModified(new Date());
        droitacces.setCreated(cfl.find(id).getCreated());
        cfl.edit(droitacces);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method=RequestMethod.GET)
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("droitacces", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("droitaccess", cfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("iddroitacces")int id,HttpServletRequest request){
        DroitAcces c = cfl.find(id);
        cfl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
