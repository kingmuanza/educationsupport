/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.AutorisationSortieFacadeLocal;
import edu.support.entities.AutorisationSortie;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author N9-T
 */
@Controller
@RequestMapping("/autorisationsortie")
public class AutorisationSortieController {
    
    @EJB(mappedName="java:app/edusupport/AutorisationSortieFacade")
    private AutorisationSortieFacadeLocal cfl;
    
    private final static String VUE_CREATE = "jsp/autorisationsortie/create";
    private final static String VUE_EDIT = "jsp/autorisationsortie/edit";
    private final static String VUE_LIST = "jsp/autorisationsortie/list";
    private final static String VUE_VIEW = "jsp/autorisationsortie/view";
    private final static String PATH_LIST = "/autorisationsortie/list";
    
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
    public Object postCreate(@Valid @ModelAttribute("autorisationsortie")AutorisationSortie autorisationsortie,BindingResult result ,HttpServletRequest request){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        autorisationsortie.setCreated(new Date());
        autorisationsortie.setModified(new Date());
        cfl.create(autorisationsortie);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("autorisationsortie", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("autorisationsortie")AutorisationSortie autorisationsortie ,@RequestParam("idautorisationsortie")int id,HttpServletRequest request){
        autorisationsortie.setModified(new Date());
        autorisationsortie.setCreated(cfl.find(id).getCreated());
        cfl.edit(autorisationsortie);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method=RequestMethod.GET)
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("autorisationsortie", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("autorisationsorties", cfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idautorisationsortie")int id,HttpServletRequest request){
        AutorisationSortie c = cfl.find(id);
        cfl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
