/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.AutorisationSortieFacadeLocal;
import edu.support.dao.EleveFacadeLocal;
import edu.support.dao.MaladieFacadeLocal;
import edu.support.entities.AutorisationSortie;
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
@RequestMapping("/autorisationsortie")
public class AutorisationSortieController {
    
    @EJB(mappedName="java:app/edusupport/AutorisationSortieFacade")
    private AutorisationSortieFacadeLocal asfl;
    
    @EJB(mappedName="java:app/edusupport/EleveFacade")
    private EleveFacadeLocal efl;
    
    @EJB(mappedName="java:app/edusupport/MaladieFacade")
    private MaladieFacadeLocal mfl;
    
    private final static String VUE_CREATE = "jsp/autorisationsortie/create";
    private final static String VUE_EDIT = "jsp/autorisationsortie/edit";
    private final static String VUE_LIST = "jsp/autorisationsortie/list";
    private final static String VUE_VIEW = "jsp/autorisationsortie/view";
    private final static String PATH_LIST = "/start#!/autorisationsorties";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","dateJour","dateRetour","eleveIdeleve","maladieIdmaladie"});
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        mv.addObject("eleves", efl.findAll());
        mv.addObject("maladies", mfl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("autorisationsortie")AutorisationSortie autorisationsortie,BindingResult result,@RequestParam("eleveIdeleve") String[] eleveIdeleve ,HttpServletRequest request, @RequestParam Map<String,String> params) throws ParseException{
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        String eleves[] = eleveIdeleve;
        for(String s: eleves){
            autorisationsortie.setDateJour(new SimpleDateFormat("yyy-MM-ddd").parse(params.get("dateJour")));
            autorisationsortie.setDateRetour(new SimpleDateFormat("yyy-MM-ddd").parse(params.get("dateRetour")));
            autorisationsortie.setCreated(new Date());
            autorisationsortie.setModified(new Date());
            autorisationsortie.setEleveIdeleve(efl.find(Integer.parseInt(s)));
            String idmaladie = "";
            if(params.get("maladieIdmaladie") != null)
                idmaladie = params.get("maladieIdmaladie");
            if(idmaladie != null && !idmaladie.isEmpty())
                autorisationsortie.setMaladieIdmaladie(mfl.find(Integer.parseInt(params.get("maladieIdmaladie"))));
            asfl.create(autorisationsortie);
        }
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("autorisationsortie", asfl.find(id));
        mv.addObject("eleves", efl.findAll());
        mv.addObject("maladies", mfl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("autorisationsortie")AutorisationSortie autorisationsortie, @RequestParam("eleveIdeleve") String[] eleveIdeleve, @RequestParam Map<String,String> params,HttpServletRequest request) throws ParseException{
        String eleves[] = eleveIdeleve;
        for(String s: eleves){
            autorisationsortie.setDateJour(new SimpleDateFormat("yyy-MM-ddd").parse(params.get("dateJour")));
            autorisationsortie.setDateRetour(new SimpleDateFormat("yyy-MM-ddd").parse(params.get("dateRetour")));
            autorisationsortie.setCreated(new Date());
            autorisationsortie.setModified(new Date());
            autorisationsortie.setEleveIdeleve(efl.find(Integer.parseInt(s)));
            asfl.edit(autorisationsortie);
        }
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("autorisationsortie", asfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("autorisationsorties", asfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idautorisationsortie")int id,HttpServletRequest request){
        AutorisationSortie c = asfl.find(id);
        asfl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
