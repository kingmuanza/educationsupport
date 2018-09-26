/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.ConseilDisciplineFacadeLocal;
import edu.support.dao.EleveFacadeLocal;
import edu.support.dao.ElevesTraduitsFacadeLocal;
import edu.support.dto.Notification;
import edu.support.entities.ConseilDiscipline;
import edu.support.entities.Eleve;
import edu.support.entities.ElevesTraduits;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author N9-T
 */
@Controller
@RequestMapping("/conseildiscipline")
public class ConseilDisciplineController {
    
    @EJB(mappedName="java:app/edusupport/ConseilDisciplineFacade")
    private ConseilDisciplineFacadeLocal cfl;
    
    @EJB(mappedName="java:app/edusupport/EleveFacade")
    private EleveFacadeLocal efl;
    
    @EJB(mappedName="java:app/edusupport/ElevesTraduitsFacade")
    private ElevesTraduitsFacadeLocal etfl;
    
    private final static String VUE_CREATE = "jsp/conseildiscipline/create";
    private final static String VUE_EDIT = "jsp/conseildiscipline/edit";
    private final static String VUE_LIST = "jsp/conseildiscipline/list";
    private final static String VUE_VIEW = "jsp/conseildiscipline/view";
    private final static String PATH_LIST = "/start#!/conseildisciplines";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","dateDebut","dateFin","eleves"});
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
    public Object postCreate(@Valid @ModelAttribute("conseildiscipline")ConseilDiscipline conseildiscipline,BindingResult result ,HttpServletRequest request, @RequestParam Map <String,String>params) throws ParseException{
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        conseildiscipline.setDateDebut(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateDebut")));
        conseildiscipline.setDateFin(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateFin")));
        conseildiscipline.setCreated(new Date());
        conseildiscipline.setModified(new Date());
        cfl.create(conseildiscipline);
        Notification.enregistrementNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id) throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        mv.addObject("conseildiscipline", cfl.find(id));
        mv.addObject("eleves", efl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("conseildiscipline")ConseilDiscipline conseildiscipline ,@RequestParam Map<String,String>params,HttpServletRequest request, MultipartFile multipart) throws ParseException{
        conseildiscipline.setDateDebut(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateDebut")));
        conseildiscipline.setDateFin(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateFin")));
        conseildiscipline.setModified(new Date());
        conseildiscipline.setCreated(cfl.find(Integer.parseInt(params.get("idconseilDiscipline"))).getCreated());
        //ici le code pour ecrire le fichier sur le serveur et enregistrer son chemin
        cfl.edit(conseildiscipline);
        String[] eleves = request.getParameterValues("eleves");
        for(String s: eleves){
            Eleve e = efl.find(Integer.parseInt(s));
            ElevesTraduits et = new ElevesTraduits();
            et.setConseilDisciplineIdconseilDiscipline(conseildiscipline);
            et.setCreated(new Date());
            et.setModified(new Date());
            et.setDeleted(false);
            et.setMotif("Motif par defaut");
            et.setEleveIdeleve(e);
            etfl.create(et);
        }
        Notification.modificationNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("conseildiscipline", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("conseildisciplines", cfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idconseildiscipline")int id,HttpServletRequest request){
        ConseilDiscipline c = cfl.find(id);
        cfl.remove(c);
        Notification.suppressionNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
