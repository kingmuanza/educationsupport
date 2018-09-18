/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.ConvocationFacadeLocal;
import edu.support.dao.EleveFacadeLocal;
import edu.support.entities.Convocation;
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
@RequestMapping("/convocation")
public class ConvocationController {
    
    @EJB(mappedName="java:app/edusupport/ConvocationFacade")
    private ConvocationFacadeLocal cfl;
    
    @EJB(mappedName="java:app/edusupport/EleveFacade")
    private EleveFacadeLocal efl;
    
    private final static String VUE_CREATE = "jsp/convocation/create";
    private final static String VUE_EDIT = "jsp/convocation/edit";
    private final static String VUE_LIST = "jsp/convocation/list";
    private final static String VUE_VIEW = "jsp/convocation/view";
    private final static String PATH_LIST = "/start#!/convocations";
    
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
    public Object postCreate(@Valid @ModelAttribute("convocation")Convocation convocation,BindingResult result ,HttpServletRequest request, @RequestParam Map<String,String> params){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        convocation.setCreated(new Date());
        convocation.setModified(new Date());
        convocation.setEleveIdeleve(efl.find(Integer.parseInt(params.get("eleveIdeleve"))));
        cfl.create(convocation);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id) throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        mv.addObject("convocation", cfl.find(id));
        mv.addObject("eleves", efl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("convocation")Convocation convocation , @RequestParam Map<String,String> params,HttpServletRequest request){
        convocation.setModified(new Date());
        convocation.setCreated(cfl.find(Integer.parseInt(params.get("idconvocation"))).getCreated());
        convocation.setEleveIdeleve(efl.find(Integer.parseInt(params.get("eleveIdeleve"))));
        cfl.edit(convocation);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("convocation", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("convocations", cfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idconvocation")int id,HttpServletRequest request){
        Convocation c = cfl.find(id);
        cfl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
