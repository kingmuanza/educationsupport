/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;
import edu.support.dao.AbsenceFacadeLocal;
import edu.support.dao.EleveFacadeLocal;
import edu.support.dto.Notification;
import edu.support.entities.Absence;
import edu.support.entities.Eleve;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author N9-T
 */
@Controller
@RequestMapping("/absence")
public class AbsenceController {
    
    @EJB(mappedName="java:app/edusupport/AbsenceFacade")
    private AbsenceFacadeLocal afl;
    
    @EJB(mappedName="java:app/edusupport/EleveFacade")
    private EleveFacadeLocal efl;
    
    private final static String VUE_CREATE = "jsp/absence/create";
    private final static String VUE_EDIT = "jsp/absence/edit";
    private final static String VUE_LIST = "jsp/absence/list";
    private final static String VUE_VIEW = "jsp/absence/view";
    private final static String PATH_LIST = "/start#!/absences";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"jourAbsence","created","modified","eleveIdeleve"});
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
        List<Eleve> li = efl.findAll();
        Collections.sort(li, (a,b) -> (a.getIndividuIdindividu().getNoms()).compareTo(b.getIndividuIdindividu().getNoms()) < 0 ? -1 : (a.getIndividuIdindividu().getNoms()).compareTo(b.getIndividuIdindividu().getNoms()) == 0 ? 0 : 1);
        mv.addObject("eleves", li);
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("absence")Absence absence,BindingResult result ,HttpServletRequest request,@RequestParam("eleveIdeleve")String[]eleveIdeleve, @RequestParam Map<String,String> params) throws ParseException{
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        String eleves[] = eleveIdeleve;
        for(String s: eleves){
            absence.setJourAbsence(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("jourAbsence")));
            absence.setEleveIdeleve(efl.find(Integer.parseInt(s)));
            absence.setCreated(new Date());
            absence.setModified(new Date());
            afl.create(absence);
        }
        Notification.enregistrementNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("absence", afl.find(id));
        List<Eleve> li = efl.findAll();
        Collections.sort(li, (a,b) -> (a.getIndividuIdindividu().getNoms()).compareTo(b.getIndividuIdindividu().getNoms()) < 0 ? -1 : (a.getIndividuIdindividu().getNoms()).compareTo(b.getIndividuIdindividu().getNoms()) == 0 ? 0 : 1);
        mv.addObject("eleves", li);
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("absence")Absence absence ,HttpServletRequest request,@RequestParam("eleveIdeleve")String[]eleveIdeleve, @RequestParam Map<String,String> params) throws ParseException{
        String eleves[] = eleveIdeleve;
        for(String s: eleves){
            absence.setJourAbsence(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("jourAbsence")));
            absence.setEleveIdeleve(efl.find(Integer.parseInt(s)));
            absence.setModified(new Date());
            afl.edit(absence);
        }
        Notification.modificationNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("absence", afl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("absences", afl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idabsence")int id,HttpServletRequest request){
        Absence c = afl.find(id);
        afl.remove(c);
        Notification.suppressionNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
