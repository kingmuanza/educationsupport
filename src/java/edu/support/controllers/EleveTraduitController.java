/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.ElevesTraduitsFacadeLocal;
import edu.support.dao.ConseilDisciplineFacadeLocal;
import edu.support.dao.EleveFacadeLocal;
import edu.support.dto.Notification;
import edu.support.entities.ElevesTraduits;
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
@RequestMapping("/elevetraduit")
public class EleveTraduitController {

    @EJB(mappedName = "java:app/edusupport/ElevesTraduitsFacade")
    private ElevesTraduitsFacadeLocal etfl;

    @EJB(mappedName = "java:app/edusupport/EleveFacade")
    private EleveFacadeLocal efl;

    @EJB(mappedName = "java:app/edusupport/ConseilDisciplineFacade")
    private ConseilDisciplineFacadeLocal cdfl;

    private final static String VUE_CREATE = "jsp/elevetraduit/create";
    private final static String VUE_EDIT = "jsp/elevetraduit/edit";
    private final static String VUE_LIST = "jsp/elevetraduit/list";
    private final static String VUE_VIEW = "jsp/elevetraduit/view";
    private final static String PATH_LIST = "/start#!/elevestraduits";

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields(new String[]{"created", "modified", "conseilDisciplineIdconseilDiscipline", "eleveIdeleve"});
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

    @RequestMapping(value = "/create", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException {
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        return mv;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("eleveTraduit") ElevesTraduits eleveTraduit, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView(VUE_CREATE);
            return mv;
        }
        String conseilDiscipline = request.getParameter("conseilDisciplineIdconseilDiscipline");
        eleveTraduit.setConseilDisciplineIdconseilDiscipline(cdfl.find(Integer.parseInt(conseilDiscipline)));
        String[] eleves = request.getParameterValues("eleveIdeleve");
        for (String m : eleves) {
            eleveTraduit.setEleveIdeleve(efl.find(Integer.parseInt(m)));
            eleveTraduit.setCreated(new Date());
            eleveTraduit.setModified(new Date());
            etfl.create(eleveTraduit);
        }
        Notification.enregistrementNotification(request);
        RedirectView rv = new RedirectView(request.getContextPath() + PATH_LIST);
        return rv;
    }

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("eleveTraduit", etfl.find(id));
        return mv;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("eleveTraduit") ElevesTraduits eleveTraduit, @RequestParam("idelevesTraduits") int id, HttpServletRequest request) {
        eleveTraduit.setModified(new Date());
        eleveTraduit.setCreated(etfl.find(id).getCreated());
        eleveTraduit.setConseilDisciplineIdconseilDiscipline(cdfl.find(Integer.parseInt(request.getParameter("conseilDisciplineIdconseilDiscipline"))));
        etfl.edit(eleveTraduit);
        RedirectView rv = new RedirectView(request.getContextPath() + PATH_LIST);
        return rv;
    }

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("idelevesTraduits") int id) {
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("eleveTraduit", etfl.find(id));
        return mv;
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList() {
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("elevesTraduits", etfl.findAll());
        return mv;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public RedirectView delete(@RequestParam("idelevesTraduits") int id, HttpServletRequest request) {
        ElevesTraduits cm = etfl.find(id);
        etfl.remove(cm);
        RedirectView rv = new RedirectView(request.getContextPath() + PATH_LIST);
        return rv;
    }
}
