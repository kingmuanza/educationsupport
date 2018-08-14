package edu.support.controllers;

import edu.support.dao.AbsenceFacadeLocal;
import edu.support.dao.AutorisationSortieFacadeLocal;
import edu.support.dao.ClasseFacadeLocal;
import edu.support.dao.RetardFacadeLocal;
import edu.support.dao.SanctionFacadeLocal;
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

    @EJB(mappedName = "java:app/edusupport/ClasseFacade")
    private ClasseFacadeLocal classeFacadeLocal;
    
    @EJB(mappedName="java:app/edusupport/AbsenceFacade")
    private AbsenceFacadeLocal afl;
    
    @EJB(mappedName="java:app/edusupport/RetardFacade")
    private RetardFacadeLocal rfl;
    
    @EJB(mappedName="java:app/edusupport/SanctionFacade")
    private SanctionFacadeLocal sfl;
    
    @EJB(mappedName="java:app/edusupport/AutorisationSortieFacade")
    private AutorisationSortieFacadeLocal asfl;

    private final static String PATH_START = "jsp/aujourdhui";

    @RequestMapping(value = "/aujourdhui", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getViewStart() {
        ModelAndView mv = new ModelAndView(PATH_START);
        List<Classe> classes = classeFacadeLocal.findAll();
        System.out.println(classes);
        for (Classe c : classes) {
            System.out.println(c.getEleveCollection().size());

        }
        mv.addObject("aujourdhui", new Date());
        mv.addObject("classes", classes);
        mv.addObject("autorisationsorties", asfl.findAll());
        mv.addObject("sanctions", sfl.findAll());
        mv.addObject("retards", rfl.findAll());
        mv.addObject("absences", afl.findAll());
        return mv;
    }
}
