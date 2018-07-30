/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.EvaluationFacadeLocal;
import edu.support.entities.Evaluation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private EvaluationFacadeLocal cfl;
    
    private final static String VUE_CREATE = "jsp/evaluation/create";
    private final static String VUE_EDIT = "jsp/evaluation/edit";
    private final static String VUE_LIST = "jsp/evaluation/list";
    private final static String VUE_VIEW = "jsp/evaluation/view";
    private final static String PATH_LIST = "/evaluation/list";
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setDisallowedFields(new String[]{"created","modified"});
    }
    
    @RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException{
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        return mv;
    }
    
//    @RequestMapping(value="/create", method=RequestMethod.POST)
//    public Object postCreate(@Valid @ModelAttribute("evaluation")Evaluation evaluation,BindingResult result ,HttpServletRequest request){
//        if(result.hasErrors()){
//            ModelAndView mv = new ModelAndView(VUE_CREATE);
//            return mv;
//        }
//        evaluation.setCreated(new Date());
//        evaluation.setModified(new Date());
//        cfl.create(evaluation);
//        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
//        return rv;
//    }
//    
//    @RequestMapping(value="/edit/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
//    public ModelAndView getEdit(@PathVariable("id")int id){
//        ModelAndView mv = new ModelAndView(VUE_EDIT);
//        mv.addObject("evaluation", cfl.find(id));
//        return mv;
//    }
//    
//    @RequestMapping(value="/edit", method=RequestMethod.POST)
//    public RedirectView postEdit(@Valid @ModelAttribute("evaluation")Evaluation evaluation ,@RequestParam("idevaluation")int id,HttpServletRequest request){
//        evaluation.setModified(new Date());
//        evaluation.setCreated(cfl.find(id).getCreated());
//        cfl.edit(evaluation);
//        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
//        return rv;
//    }
    
    @RequestMapping(value="/view/{id}", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id")int id){
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("evaluation", cfl.find(id));
        return mv;
    }
    
    @RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("evaluations", cfl.findAll());
        return mv;
    }
    
    
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public RedirectView delete(@RequestParam("idevaluation")int id,HttpServletRequest request){
        Evaluation c = cfl.find(id);
        cfl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath()+PATH_LIST);
        return rv;
    }
}
