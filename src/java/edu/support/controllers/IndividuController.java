/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import edu.support.dao.IndividuFacadeLocal;
import edu.support.entities.Individu;
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
@RequestMapping("/individu")
public class IndividuController {

    @EJB(mappedName = "java:app/edusupport/IndividuFacade")
    private IndividuFacadeLocal cfl;

    private final static String VUE_CREATE = "jsp/individu/create";
    private final static String VUE_EDIT = "jsp/individu/edit";
    private final static String VUE_LIST = "jsp/individu/list";
    private final static String VUE_VIEW = "jsp/individu/view";
    private final static String PATH_LIST = "/individu/list";

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields(new String[]{"created", "modified"});
    }

    @RequestMapping(value = "/create", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getCreate() throws ParseException {
        ModelAndView mv = new ModelAndView(VUE_CREATE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        mv.addObject("date", sdf.parse(sdf.format(new Date())));
        return mv;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object postCreate(@Valid @ModelAttribute("individu") Individu ind, BindingResult result, HttpServletRequest request) {
        System.out.println(ind);
        String dateNaissance = request.getParameter("dateNaissance");
        System.out.println(dateNaissance);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ind.setDateNaissance(sdf.parse(dateNaissance));
            
        } catch (ParseException ex) {
            
        }
        String email = request.getParameter("email");
        ind.setEmail(email);
        String genre = request.getParameter("sexe");
        ind.setSexe(genre);
        String lieuNaissance = request.getParameter("lieuNaissance");
        ind.setLieuNaissance(lieuNaissance);
        String matricule = request.getParameter("matricule");
        ind.setMatricule(matricule);
        String noms = request.getParameter("noms");
        ind.setNoms(noms);
        String prenoms = request.getParameter("prenoms");
        ind.setPrenoms(prenoms);
        String residence = request.getParameter("residence");
        ind.setResidence(residence);
        String telephone = request.getParameter("telephone");
        ind.setTelephone(telephone);
        
        
        ind.setCreated(new Date());
        ind.setModified(new Date());
        cfl.create(ind);
        RedirectView rv = new RedirectView("/start");
        return rv;
    }

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getEdit(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView(VUE_EDIT);
        mv.addObject("individu", cfl.find(id));
        return mv;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public RedirectView postEdit(@Valid @ModelAttribute("individu") Individu individu, @RequestParam("idindividu") int id, HttpServletRequest request) {
        individu.setModified(new Date());
        individu.setCreated(cfl.find(id).getCreated());
        cfl.edit(individu);
        RedirectView rv = new RedirectView(request.getContextPath() + PATH_LIST);
        return rv;
    }

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getView(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView(VUE_VIEW);
        mv.addObject("individu", cfl.find(id));
        return mv;
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getList() {
        ModelAndView mv = new ModelAndView(VUE_LIST);
        mv.addObject("individus", cfl.findAll());
        return mv;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public RedirectView delete(@RequestParam("idindividu") int id, HttpServletRequest request) {
        Individu c = cfl.find(id);
        cfl.remove(c);
        RedirectView rv = new RedirectView(request.getContextPath() + PATH_LIST);
        return rv;
    }
}
