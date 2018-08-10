/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.EleveFacadeLocal;
import edu.support.dao.RelanceFacadeLocal;
import edu.support.entities.Relance;
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
@RequestMapping("/relance")
public class RelanceController {
    
    @EJB(mappedName="java:app/edusupport/RelanceFacade")
    private RelanceFacadeLocal rfl;
    
    @EJB(mappedName="java:app/edusupport/EleveFacade")
    private EleveFacadeLocal efl;
    
    private final static String VUE_CREATE = "jsp/relance/create";
    private final static String VUE_EDIT = "jsp/relance/edit";
    private final static String VUE_LIST = "jsp/relance/list";
    private final static String VUE_VIEW = "jsp/relance/view";
    private final static String PATH_LIST = "/start#!/relances";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","echeance","eleveIdeleve"});
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
    public Object postCreate(@Valid @ModelAttribute("relance")Relance relance,BindingResult result ,HttpServletRequest request ,@RequestParam Map <String,String> params) throws ParseException{
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        relance.setEcheance(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("echeance")));
        relance.setEleveIdeleve(efl.find(Integer.parseInt(params.get("eleveIdeleve"))));
        relance.setCreated(new Date());
        relance.setModified(new Date());
        rfl.create(relance);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("relance", rfl.find(id));
        mv.addObject("eleves", efl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("relance")Relance relance ,@RequestParam Map <String,String> params,HttpServletRequest request) throws ParseException{
        relance.setModified(new Date());
        relance.setCreated(rfl.find(Integer.parseInt(params.get("relance"))).getCreated());
        relance.setEcheance(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("echeance")));
        relance.setEleveIdeleve(efl.find(Integer.parseInt(params.get("eleveIdeleve"))));
        rfl.edit(relance);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("relance", rfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("relances", rfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idrelance")int id,HttpServletRequest request){
        Relance c = rfl.find(id);
        rfl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
