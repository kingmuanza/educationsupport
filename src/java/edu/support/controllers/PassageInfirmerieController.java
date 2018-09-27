/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.EleveFacadeLocal;
import edu.support.dao.PassageInfirmerieFacadeLocal;
import edu.support.dto.Notification;
import edu.support.entities.PassageInfirmerie;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author N9-T
 */
@Controller
@RequestMapping("/passageinfirmerie")
public class PassageInfirmerieController {
    
    @EJB(mappedName="java:app/edusupport/PassageInfirmerieFacade")
    private PassageInfirmerieFacadeLocal pifl;
    
    @EJB(mappedName="java:app/edusupport/EleveFacade")
    private EleveFacadeLocal efl;
    
    private final static String VUE_CREATE = "jsp/passageinfirmerie/create";
    private final static String VUE_EDIT = "jsp/passageinfirmerie/edit";
    private final static String VUE_LIST = "jsp/passageinfirmerie/list";
    private final static String VUE_VIEW = "jsp/passageinfirmerie/view";
    private final static String PATH_LIST = "/start#!/passageinfirmeries";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","dateJour","eleveIdeleve"});
    }
    
    @ExceptionHandler(value=Exception.class)
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public RedirectView ExceptionHandler(HttpServletRequest request){
        Notification n = Notification.getExceptionNotification();
        HttpSession session = request.getSession();
        session.setAttribute("notification", n);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
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
    public Object postCreate(@Valid @ModelAttribute("passageinfirmerie")PassageInfirmerie passageinfirmerie,BindingResult result ,HttpServletRequest request ,@RequestParam Map <String,String> params) throws ParseException{
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        passageinfirmerie.setCreated(new Date());
        passageinfirmerie.setModified(new Date());
        passageinfirmerie.setDateJour(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateJour")));
        passageinfirmerie.setEleveIdeleve(efl.find(Integer.parseInt(params.get("eleveIdeleve"))));
        pifl.create(passageinfirmerie);
        Notification.enregistrementNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("passageinfirmerie", pifl.find(id));
        mv.addObject("eleves", efl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("passageinfirmerie")PassageInfirmerie passageinfirmerie  ,@RequestParam Map <String,String> params,HttpServletRequest request) throws ParseException{
        passageinfirmerie.setModified(new Date());
        passageinfirmerie.setCreated(pifl.find(Integer.parseInt(params.get("idpassageinfirmerie"))).getCreated());
        passageinfirmerie.setDateJour(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateJour")));
        passageinfirmerie.setEleveIdeleve(efl.find(Integer.parseInt(params.get("eleveIdeleve"))));
        pifl.edit(passageinfirmerie);
        Notification.modificationNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("passageinfirmerie", pifl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("passageinfirmeries", pifl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idpassageinfirmerie")int id,HttpServletRequest request){
        PassageInfirmerie c = pifl.find(id);
        pifl.remove(c);
        Notification.suppressionNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
