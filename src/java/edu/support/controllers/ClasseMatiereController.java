/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.ClasseMatiereFacadeLocal;
import edu.support.dao.MatiereFacadeLocal;
import edu.support.dao.SalleDeClasseFacadeLocal;
import edu.support.dto.Notification;
import edu.support.entities.ClasseMatiere;
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
@RequestMapping("/classematiere")
public class ClasseMatiereController {
    
    @EJB(mappedName="java:app/edusupport/ClasseMatiereFacade")
    private ClasseMatiereFacadeLocal cmfl;
    
    @EJB(mappedName="java:app/edusupport/SalleDeClasseFacade")
    private SalleDeClasseFacadeLocal scfl;
    
    @EJB(mappedName="java:app/edusupport/MatiereFacade")
    private MatiereFacadeLocal mfl;
    
    private final static String VUE_CREATE = "jsp/classematiere/create";
    private final static String VUE_EDIT = "jsp/classematiere/edit";
    private final static String VUE_LIST = "jsp/classematiere/list";
    private final static String VUE_VIEW = "jsp/classematiere/view";
    private final static String PATH_LIST = "/start#!/classesmatieres";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","matiereIdmatiere","salleDeClasseIdsalleDeClasse"});
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
        mv.addObject("salleDeClasses", scfl.findAll());
        mv.addObject("matieres", mfl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("classeMatiere")ClasseMatiere classeMatiere,BindingResult result ,HttpServletRequest request){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        String salleDeClasse = request.getParameter("salleDeClasseIdsalleDeClasse");
        String[] matieres = request.getParameterValues("matiereIdmatiere");
        classeMatiere.setSalleDeClasseIdsalleDeClasse(scfl.find(Integer.parseInt(salleDeClasse)));
        for(String m: matieres){
            classeMatiere.setMatiereIdmatiere(mfl.find(Integer.parseInt(m)));
            classeMatiere.setCreated(new Date());
            classeMatiere.setModified(new Date());
            cmfl.create(classeMatiere);
        }
        Notification.enregistrementNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("classeMatiere", cmfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("classeMatiere")ClasseMatiere classeMatiere ,@RequestParam("idclassesMatieres")int id,HttpServletRequest request){
        classeMatiere.setModified(new Date());
        classeMatiere.setCreated(cmfl.find(id).getCreated());
        classeMatiere.setMatiereIdmatiere(mfl.find(Integer.parseInt(request.getParameter("matiereIdmatiere"))));
        cmfl.edit(classeMatiere);
        Notification.modificationNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("idclassesMatieres")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("classeMatiere", cmfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("classesMatieres", cmfl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idclassesMatieres")int id,HttpServletRequest request){
        ClasseMatiere cm = cmfl.find(id);
        cmfl.remove(cm);
        Notification.suppressionNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
