package edu.support.controllers;

import edu.support.dao.ClasseFacadeLocal;
import edu.support.entities.Classe;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AujourdhuiController {
    
    @EJB(mappedName="java:app/edusupport/ClasseFacade")
    private ClasseFacadeLocal classeFacadeLocal;
    
    private final static String PATH_START = "jsp/aujourdhui";
    @RequestMapping(value = "/aujourdhui", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getViewStart(){
        ModelAndView mv = new ModelAndView(PATH_START);
        List<Classe> classes = classeFacadeLocal.findAll();
        System.out.println(classes);
        mv.addObject("aujourdhui", new Date());
        mv.addObject("classes", classes);
        return mv;
    }
}
