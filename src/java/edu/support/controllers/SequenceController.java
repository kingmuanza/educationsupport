/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.AnneeScolaireFacadeLocal;
import edu.support.dao.SequenceFacadeLocal;
import edu.support.dao.TrimestreFacadeLocal;
import edu.support.dto.Notification;
import edu.support.entities.Sequence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("/sequence")
public class SequenceController {
    
    @EJB(mappedName="java:app/edusupport/SequenceFacade")
    private SequenceFacadeLocal cfl;
    
    @EJB(mappedName="java:app/edusupport/TrimestreFacade")
    private TrimestreFacadeLocal tfl;
    
    @EJB(mappedName="java:app/edusupport/AnneeScolaireFacade")
    private AnneeScolaireFacadeLocal asfl;
    
    private final static String VUE_CREATE = "jsp/sequence/create";
    private final static String VUE_EDIT = "jsp/sequence/edit";
    private final static String VUE_LIST = "jsp/sequence/list";
    private final static String VUE_VIEW = "jsp/sequence/view";
    private final static String PATH_LIST = "/start#!/sequences";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","anneeScolaireIdanneeScolaire","trimestreIdtrimestre"});
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
        mv.addObject("trimestres", tfl.findAll());
        mv.addObject("anneescolaires", asfl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("sequence")Sequence sequence,BindingResult result ,HttpServletRequest request, @RequestParam Map<String,String> params){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        sequence.setAnneeScolaireIdanneeScolaire(asfl.find(Integer.parseInt(params.get("anneeScolaireIdanneeScolaire"))));
        sequence.setTrimestreIdtrimestre(tfl.find(Integer.parseInt(params.get("trimestreIdtrimestre"))));
        sequence.setCreated(new Date());
        sequence.setModified(new Date());
        cfl.create(sequence);
        Notification.enregistrementNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("sequence", cfl.find(id));
        mv.addObject("trimestres", tfl.findAll());
        mv.addObject("anneescolaires", asfl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("sequence")Sequence sequence ,HttpServletRequest request,@RequestParam Map<String,String> params){
        sequence.setModified(new Date());
        sequence.setAnneeScolaireIdanneeScolaire(asfl.find(Integer.parseInt(params.get("anneeScolaireIdanneeScolaire"))));
        sequence.setTrimestreIdtrimestre(tfl.find(Integer.parseInt(params.get("trimestreIdtrimestre"))));
        sequence.setCreated(cfl.find(Integer.parseInt(params.get("idsequence"))).getCreated());
        cfl.edit(sequence);
        Notification.modificationNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("sequence", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("sequences", cfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idsequence")int id,HttpServletRequest request){
        Sequence c = cfl.find(id);
        cfl.remove(c);
        Notification.suppressionNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
