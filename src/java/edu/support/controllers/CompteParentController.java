/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.CompteParentFacadeLocal;
import edu.support.dto.Notification;
import edu.support.entities.CompteParent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/compteparent")
public class CompteParentController {
    
    @EJB(mappedName="java:app/edusupport/CompteParentFacade")
    private CompteParentFacadeLocal cfl;
    
    private final static String VUE_CREATE = "jsp/compteparent/create";
    private final static String VUE_EDIT = "jsp/compteparent/edit";
    private final static String VUE_LIST = "jsp/compteparent/list";
    private final static String VUE_VIEW = "jsp/compteparent/view";
    private final static String PATH_LIST = "/start#!/compteparents";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified"});
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
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("compteparent")CompteParent compteparent,BindingResult result ,HttpServletRequest request){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        compteparent.setCreated(new Date());
        compteparent.setModified(new Date());
        cfl.create(compteparent);
        Notification.enregistrementNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("compteparent", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("compteparent")CompteParent compteparent ,@RequestParam("idcompteparent")int id,HttpServletRequest request){
        compteparent.setModified(new Date());
        compteparent.setCreated(cfl.find(id).getCreated());
        cfl.edit(compteparent);
        Notification.modificationNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("compteparent", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(HttpServletRequest request){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("compteparents", cfl.findAll());
        HttpSession session  = request.getSession();
        Notification notification = (Notification) session.getAttribute("notification");
        mv.addObject("notification", notification);
        session.setAttribute("notification", null);
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idcompteparent")int id,HttpServletRequest request){
        CompteParent c = cfl.find(id);
        cfl.remove(c);
        Notification.suppressionNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
