/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.IndividuFacadeLocal;
import edu.support.dao.RetardFacadeLocal;
import edu.support.entities.Retard;
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
@RequestMapping("/retard")
public class RetardController {
    
    @EJB(mappedName="java:app/edusupport/RetardFacade")
    private RetardFacadeLocal rfl;
    
    @EJB(mappedName="java:app/edusupport/IndividuFacade")
    private IndividuFacadeLocal ifl;
    
    private final static String VUE_CREATE = "jsp/retard/create";
    private final static String VUE_EDIT = "jsp/retard/edit";
    private final static String VUE_LIST = "jsp/retard/list";
    private final static String VUE_VIEW = "jsp/retard/view";
    private final static String PATH_LIST = "/start#!/retards";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","jourRetard","individuIdindividu"});
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        mv.addObject("individus", ifl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("retard")Retard retard,BindingResult result ,HttpServletRequest request,@RequestParam("individuIdindividu")String[]individuIdindividu, @RequestParam Map <String,String> params) throws ParseException{
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        String individus[] = individuIdindividu;
        for(String s: individus){
            retard.setCreated(new Date());
            retard.setModified(new Date());
            retard.setJourRetard(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("jourRetard")));
            retard.setIndividuIdindividu(ifl.find(Integer.parseInt(params.get("individuIdindividu"))));
            rfl.create(retard);
        }
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("retard", rfl.find(id));
        mv.addObject("individus", ifl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("retard")Retard retard ,@RequestParam("individuIdindividu")String[]individuIdindividu,@RequestParam Map<String,String> params,HttpServletRequest request) throws ParseException{
        String individus[] = individuIdindividu;
        for(String s: individus){
            retard.setCreated(new Date());
            retard.setModified(new Date());
            retard.setJourRetard(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("jourRetard")));
            retard.setIndividuIdindividu(ifl.find(Integer.parseInt(params.get("individuIdindividu"))));
            rfl.create(retard);
        }
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("retard", rfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("retards", rfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idretard")int id,HttpServletRequest request){
        Retard c = rfl.find(id);
        rfl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
