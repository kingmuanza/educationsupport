/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.ClasseMatiereFacadeLocal;
import edu.support.dao.EnseignantClasseMatiereFacadeLocal;
import edu.support.dao.EnseignantFacadeLocal;
import edu.support.entities.EnseignantClasseMatiere;
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
@RequestMapping("/enseignantclassematiere")
public class EnseignantClasseMatiereController {
    
    @EJB(mappedName="java:app/edusupport/ClasseMatiereFacade")
    private ClasseMatiereFacadeLocal cmfl;
    
    @EJB(mappedName="java:app/edusupport/EnseignantFacade")
    private EnseignantFacadeLocal ensfl;
    
    @EJB(mappedName="java:app/edusupport/EnseignantClasseMatiereFacade")
    private EnseignantClasseMatiereFacadeLocal ecmfl;
    
    private final static String VUE_CREATE = "jsp/enseignantclassematiere/create";
    private final static String VUE_EDIT = "jsp/enseignantclassematiere/edit";
    private final static String VUE_LIST = "jsp/enseignantclassematiere/list";
    private final static String VUE_VIEW = "jsp/enseignantclassematiere/view";
    private final static String PATH_LIST = "/start#!/enseignantsclassesmatieres";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","classesMatieresIdclassesMatieres","enseignantIdenseignant"});
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        mv.addObject("classesMatieres", cmfl.findAll());
        mv.addObject("enseignants", ensfl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("enseignantClasseMatiere")EnseignantClasseMatiere ecm,BindingResult result ,HttpServletRequest request){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        String[] classesMatieres = request.getParameterValues("classesMatieresIdclassesMatieres");
        for(String m: classesMatieres){
            ecm.setClassesMatieresIdclassesMatieres(cmfl.find(Integer.parseInt(m)));
            ecm.setCreated(new Date());
            ecm.setModified(new Date());
            ecmfl.create(ecm);
        }
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("enseignantClasseMatiere", ecmfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("enseignantClasseMatiere")EnseignantClasseMatiere ecm ,@RequestParam("idclassesMatieres")int id,HttpServletRequest request){
        ecm.setModified(new Date());
        ecm.setCreated(ecmfl.find(id).getCreated());
        ecm.setClassesMatieresIdclassesMatieres(cmfl.find(Integer.parseInt(request.getParameter("classesMatieresIdclassesMatieres"))));
        ecmfl.edit(ecm);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("idenseignantClasseMatiere")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("enseignantClasseMatiere", ecmfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("enseignantsClassesMatieres", ecmfl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idenseignantsClassesMatieres")int id,HttpServletRequest request){
        EnseignantClasseMatiere ecm = ecmfl.find(id);
        ecmfl.remove(ecm);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
