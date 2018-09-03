/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.SalleDeClasseFacadeLocal;
import edu.support.dao.EleveFacadeLocal;
import edu.support.dao.IndividuFacadeLocal;
import edu.support.entities.Eleve;
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
@RequestMapping("/eleve")
public class EleveController {
    
    @EJB(mappedName="java:app/edusupport/EleveFacade")
    private EleveFacadeLocal efl;
    
    @EJB(mappedName="java:app/edusupport/SalleDeClasseFacade")
    private SalleDeClasseFacadeLocal sclassefl;
    
    @EJB(mappedName="java:app/edusupport/IndividuFacade")
    private IndividuFacadeLocal ifl;
    
    private final static String VUE_CREATE = "jsp/eleve/create";
    private final static String VUE_EDIT = "jsp/eleve/edit";
    private final static String VUE_LIST = "jsp/eleve/list";
    private final static String VUE_VIEW = "jsp/eleve/view";
    private final static String PATH_LIST = "/start#!/eleves";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","individuIdindividu","${salleDeClasseIdsalleDeClasse}"});
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        
        mv.addObject("individus", ifl.findAll());
        mv.addObject("classes", sclassefl.findAll());
        
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("eleve")Eleve eleve,BindingResult result ,HttpServletRequest request, @RequestParam Map<String,String> params){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        eleve.setCreated(new Date());
        eleve.setModified(new Date());
        eleve.setSalleDeClasseIdsalleDeClasse(sclassefl.find(Integer.parseInt(params.get("salleDeClasseIdsalleDeClasse"))));
        eleve.setIndividuIdindividu(ifl.find(Integer.parseInt(params.get("individuIdindividu"))));
        efl.create(eleve);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("eleve", efl.find(id));
        mv.addObject("individus", ifl.findAll());
        mv.addObject("classes", sclassefl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("eleve")Eleve eleve ,@RequestParam Map<String,String>params,HttpServletRequest request){
        eleve.setModified(new Date());
        eleve.setCreated(efl.find(params.get("ideleve")).getCreated());
        eleve.setSalleDeClasseIdsalleDeClasse(sclassefl.find(Integer.parseInt(params.get("salleDeClasseIdsalleDeClasse"))));
        eleve.setIndividuIdindividu(ifl.find(Integer.parseInt(params.get("individuIdindividu"))));
        efl.edit(eleve);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("eleve", efl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("eleves", efl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("ideleve")int id,HttpServletRequest request){
        Eleve c = efl.find(id);
        efl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
