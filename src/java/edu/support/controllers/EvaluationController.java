/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.ClasseFacadeLocal;
import edu.support.dao.EvaluationFacadeLocal;
import edu.support.dao.MatiereFacadeLocal;
import edu.support.dao.SequenceFacadeLocal;
import edu.support.entities.Evaluation;
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
@RequestMapping("/evaluation")
public class EvaluationController {
    
    @EJB(mappedName="java:app/edusupport/EvaluationFacade")
    private EvaluationFacadeLocal efl;
    
    @EJB(mappedName="java:app/edusupport/ClasseFacade")
    private ClasseFacadeLocal cfl;
    
    @EJB(mappedName="java:app/edusupport/MatiereFacade")
    private MatiereFacadeLocal mfl;
    
    @EJB(mappedName="java:app/edusupport/SequenceFacade")
    private SequenceFacadeLocal sfl;
    
    private final static String VUE_CREATE = "jsp/evaluation/create";
    private final static String VUE_EDIT = "jsp/evaluation/edit";
    private final static String VUE_LIST = "jsp/evaluation/list";
    private final static String VUE_VIEW = "jsp/evaluation/view";
    private final static String PATH_LIST = "/start#!/evaluations";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified","classeIdclasse","matiereIdmatiere","sequenceIdsequence"});
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        mv.addObject("classes", cfl.findAll());
        mv.addObject("matieres", mfl.findAll());
        mv.addObject("sequences", sfl.findAll());
        return mv;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("evaluation")Evaluation evaluation,BindingResult result ,HttpServletRequest request, @RequestParam Map<String,String> params){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        evaluation.setCreated(new Date());
        evaluation.setModified(new Date());
        evaluation.setClasseIdclasse(cfl.find(Integer.parseInt(params.get("classeIdclasse"))));
        evaluation.setMatiereIdmatiere(mfl.find(Integer.parseInt(params.get("matiereIdmatiere"))));
        evaluation.setSequenceIdsequence(sfl.find(Integer.parseInt(params.get("sequenceIdsequence"))));
        efl.create(evaluation);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("evaluation", efl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("evaluation")Evaluation evaluation ,@RequestParam Map<String,String> params, HttpServletRequest request){
        evaluation.setModified(new Date());
        evaluation.setCreated(efl.find(Integer.parseInt(params.get("idevaluation"))).getCreated());
        evaluation.setClasseIdclasse(cfl.find(Integer.parseInt(params.get("classeIdclasse"))));
        evaluation.setMatiereIdmatiere(mfl.find(Integer.parseInt(params.get("matiereIdmatiere"))));
        evaluation.setSequenceIdsequence(sfl.find(Integer.parseInt(params.get("sequenceIdsequence"))));
        efl.edit(evaluation);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("evaluation", efl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("evaluations", efl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idevaluation")int id,HttpServletRequest request){
        Evaluation c = efl.find(id);
        efl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
