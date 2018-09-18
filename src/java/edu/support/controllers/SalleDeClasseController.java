/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.ClasseFacadeLocal;
import edu.support.dao.SalleDeClasseFacadeLocal;
import edu.support.dao.SerieFacadeLocal;
import edu.support.entities.SalleDeClasse;
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
@RequestMapping("/salledeclasse")
public class SalleDeClasseController {
    
    @EJB(mappedName="java:app/edusupport/SalleDeClasseFacade")
    private SalleDeClasseFacadeLocal cfl;
    
    @EJB(mappedName="java:app/edusupport/SerieFacade")
    private SerieFacadeLocal seriefl;
    
    @EJB(mappedName="java:app/edusupport/ClasseFacade")
    private ClasseFacadeLocal classefl;
    
    private final static String VUE_CREATE = "jsp/salledeclasse/create";
    private final static String VUE_EDIT = "jsp/salledeclasse/edit";
    private final static String VUE_LIST = "jsp/salledeclasse/list";
    private final static String VUE_VIEW = "jsp/salledeclasse/view";
    private final static String PATH_LIST = "/start#!/sallesdeclasses";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified"});
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        mv.addObject("series", seriefl.findAll());
        mv.addObject("classes", classefl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("salleDeClasse")SalleDeClasse salleDeClasse,BindingResult result ,HttpServletRequest request){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        salleDeClasse.setCreated(new Date());
        salleDeClasse.setModified(new Date());
        cfl.create(salleDeClasse);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@RequestParam("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("salleDeClasse", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("salleDeClasse")SalleDeClasse salleDeClasse ,@RequestParam("idsalleDeClasse")int id,HttpServletRequest request){
        salleDeClasse.setModified(new Date());
        salleDeClasse.setCreated(cfl.find(id).getCreated());
        cfl.edit(salleDeClasse);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("salleDeClasse", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("salleDeClasses", cfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idsalleDeClasse")int id,HttpServletRequest request){
        SalleDeClasse c = cfl.find(id);
        cfl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
