/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.MatiereFacadeLocal;
import edu.support.dto.Notification;
import edu.support.entities.Matiere;
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
@RequestMapping("/matiere")
public class MatiereController {
    
    @EJB(mappedName="java:app/edusupport/MatiereFacade")
    private MatiereFacadeLocal mfl;
    
    private final static String VUE_CREATE = "jsp/matiere/create";
    private final static String VUE_EDIT = "jsp/matiere/edit";
    private final static String VUE_LIST = "jsp/matiere/list";
    private final static String VUE_VIEW = "jsp/matiere/view";
    private final static String PATH_LIST = "/start#!/matieres";
    
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
    public Object postCreate(@Valid @ModelAttribute("matiere")Matiere matiere,BindingResult result ,HttpServletRequest request){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        matiere.setCreated(new Date());
        matiere.setModified(new Date());
        mfl.create(matiere);
        Notification.enregistrementNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("matiere", mfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("matiere")Matiere matiere ,@RequestParam("idmatiere")int id,HttpServletRequest request){
        matiere.setModified(new Date());
        matiere.setCreated(mfl.find(id).getCreated());
        mfl.edit(matiere);
        Notification.modificationNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("matiere", mfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("matieres", mfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idmatiere")int id,HttpServletRequest request){
        Matiere c = mfl.find(id);
        mfl.remove(c);
        Notification.suppressionNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
