/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.RapportFacadeLocal;
import edu.support.dao.ReunionFacadeLocal;
import edu.support.entities.Rapport;
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
@RequestMapping("/rapport")
public class RapportController {
    
    @EJB(mappedName="java:app/edusupport/RapportFacade")
    private RapportFacadeLocal rapfl;
    
    @EJB(mappedName="java:app/edusupport/ReunionFacade")
    private ReunionFacadeLocal rfl;
    
    private final static String VUE_CREATE = "jsp/rapport/create";
    private final static String VUE_EDIT = "jsp/rapport/edit";
    private final static String VUE_LIST = "jsp/rapport/list";
    private final static String VUE_VIEW = "jsp/rapport/view";
    private final static String PATH_LIST = "/rapport/list";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified"});
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        mv.addObject("reunions", rfl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("rapport")Rapport rapport,BindingResult result ,HttpServletRequest request ,@RequestParam Map <String,String> params){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        rapport.setCreated(new Date());
        rapport.setModified(new Date());
        rapport.setReunionIdreunion(rfl.find(params.get("reunionIdreunion")));
        rapfl.create(rapport);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("rapport", rapfl.find(id));
        mv.addObject("reunions", rfl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("rapport")Rapport rapport ,@RequestParam Map <String,String> params,HttpServletRequest request){
        rapport.setModified(new Date());
        rapport.setCreated(rapfl.find(params.get("idrapport")).getCreated());
        rapport.setReunionIdreunion(rfl.find(params.get("reunionIdreunion")));
        rapfl.edit(rapport);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("rapport", rapfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("rapports", rapfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idrapport")int id,HttpServletRequest request){
        Rapport c = rapfl.find(id);
        rapfl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
