/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.EleveFacadeLocal;
import edu.support.dao.SanctionFacadeLocal;
import edu.support.entities.Sanction;
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
@RequestMapping("/sanction")
public class SanctionController {
    
    @EJB(mappedName="java:app/edusupport/SanctionFacade")
    private SanctionFacadeLocal sfl;
    
    @EJB(mappedName="java:app/edusupport/EleveFacade")
    private EleveFacadeLocal efl;
    
    private final static String VUE_CREATE = "jsp/sanction/create";
    private final static String VUE_EDIT = "jsp/sanction/edit";
    private final static String VUE_LIST = "jsp/sanction/list";
    private final static String VUE_VIEW = "jsp/sanction/view";
    private final static String PATH_LIST = "/start#!/sanctions";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","eleveIdeleve"});
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
    public Object postCreate(@Valid @ModelAttribute("sanction")Sanction sanction,BindingResult result ,HttpServletRequest request, @RequestParam Map <String,String> params){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        sanction.setCreated(new Date());
        sanction.setModified(new Date());
        sanction.setEleveIdeleve(efl.find(Integer.parseInt(params.get("eleveIdeleve"))));
        sfl.create(sanction);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id) throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        mv.addObject("sanction", sfl.find(id));
        mv.addObject("eleves", efl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("sanction")Sanction sanction ,@RequestParam Map<String,String> params,HttpServletRequest request){
        sanction.setModified(new Date());
        sanction.setEleveIdeleve(efl.find(Integer.parseInt(params.get("eleveIdeleve"))));
        sfl.edit(sanction);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("sanction", sfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("sanctions", sfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idsanction")int id,HttpServletRequest request){
        Sanction c = sfl.find(id);
        sfl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
