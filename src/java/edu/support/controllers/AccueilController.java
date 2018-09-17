package edu.support.controllers;

import edu.support.dao.SalleDeClasseFacadeLocal;
import edu.support.entities.SalleDeClasse;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccueilController {
    
    @EJB(mappedName="java:app/edusupport/SalleDeClasseFacade")
    private SalleDeClasseFacadeLocal salleDeClasseFacadeLocal;
    
    private final static String PATH_START = "jsp/accueil";
    @RequestMapping(value = "/accueil", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getViewStart(){
        ModelAndView mv = new ModelAndView(PATH_START);
        List<SalleDeClasse> classes = salleDeClasseFacadeLocal.findAll();
        System.out.println(classes);
        for(SalleDeClasse c : classes){
        System.out.println(c.getEleveCollection().size());
            
        }
        mv.addObject("aujourdhui", new Date());
        mv.addObject("classes", classes);
        return mv;
    }
}
