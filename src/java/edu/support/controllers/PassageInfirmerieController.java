/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.EleveFacadeLocal;
import edu.support.dao.PassageInfirmerieFacadeLocal;
import edu.support.entities.PassageInfirmerie;
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
@RequestMapping("/passageInfirmerie")
public class PassageInfirmerieController {
    
    @EJB(mappedName="java:app/edusupport/PassageInfirmerieFacade")
    private PassageInfirmerieFacadeLocal pifl;
    
    @EJB(mappedName="java:app/edusupport/EleveFacade")
    private EleveFacadeLocal efl;
    
    private final static String VUE_CREATE = "jsp/passageInfirmerie/create";
    private final static String VUE_EDIT = "jsp/passageInfirmerie/edit";
    private final static String VUE_LIST = "jsp/passageInfirmerie/list";
    private final static String VUE_VIEW = "jsp/passageInfirmerie/view";
    private final static String PATH_LIST = "/passageInfirmerie/list";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","dateJour","eleveIdeleve"});
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
    public Object postCreate(@Valid @ModelAttribute("passageInfirmerie")PassageInfirmerie passageInfirmerie,BindingResult result ,HttpServletRequest request ,@RequestParam Map <String,String> params) throws ParseException{
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        passageInfirmerie.setCreated(new Date());
        passageInfirmerie.setModified(new Date());
        passageInfirmerie.setDateJour(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateJour")));
        passageInfirmerie.setEleveIdeleve(efl.find(Integer.parseInt(params.get("eleveIdeleve"))));
        pifl.create(passageInfirmerie);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("passageInfirmerie", pifl.find(id));
        mv.addObject("eleves", efl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("passageInfirmerie")PassageInfirmerie passageInfirmerie  ,@RequestParam Map <String,String> params,HttpServletRequest request) throws ParseException{
        passageInfirmerie.setModified(new Date());
        passageInfirmerie.setCreated(pifl.find(Integer.parseInt(params.get("idpassageInfirmerie"))).getCreated());
        passageInfirmerie.setDateJour(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateJour")));
        passageInfirmerie.setEleveIdeleve(efl.find(Integer.parseInt(params.get("eleveIdeleve"))));
        pifl.edit(passageInfirmerie);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("passageInfirmerie", pifl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("passageInfirmeries", pifl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idpassageInfirmerie")int id,HttpServletRequest request){
        PassageInfirmerie c = pifl.find(id);
        pifl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
