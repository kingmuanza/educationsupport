/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;
import edu.support.dao.AbsenceFacadeLocal;
import edu.support.dao.IndividuFacadeLocal;
import edu.support.entities.Absence;
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
@RequestMapping("/absence")
public class AbsenceController {
    
    @EJB(mappedName="java:app/edusupport/AbsenceFacade")
    private AbsenceFacadeLocal afl;
    
    @EJB(mappedName="java:app/edusupport/IndividuFacade")
    private IndividuFacadeLocal ifl;
    
    private final static String VUE_CREATE = "jsp/absence/create";
    private final static String VUE_EDIT = "jsp/absence/edit";
    private final static String VUE_LIST = "jsp/absence/list";
    private final static String VUE_VIEW = "jsp/absence/view";
    private final static String PATH_LIST = "/start#!/absence/list";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","jourAbsence","individuIdindividu"});
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        mv.addObject("individus", ifl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("absence")Absence absence,BindingResult result ,HttpServletRequest request, @RequestParam Map<String,String> params) throws ParseException{
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        absence.setJourAbsence(new SimpleDateFormat("yyyy-MM-dd").parse(params.get("jourAbsence")));
        absence.setIndividuIdindividu(ifl.find(Integer.parseInt(params.get("individuIdindividu"))));
        absence.setCreated(new Date());
        absence.setModified(new Date());
        afl.create(absence);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("absence", afl.find(id));
        mv.addObject("individus", ifl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("absence")Absence absence ,HttpServletRequest request, @RequestParam Map<String,String> params) throws ParseException{
        absence.setModified(new Date());
        absence.setCreated(afl.find(params.get("idabsence")).getCreated());
        absence.setJourAbsence(new SimpleDateFormat().parse(params.get("dateJour")));
        absence.setIndividuIdindividu(ifl.find(params.get("individuIdindividu")));
        afl.edit(absence);
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
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
