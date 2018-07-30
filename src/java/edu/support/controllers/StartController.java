/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author N9-T
 */
@Controller
public class StartController {
    
    private final static String PATH_START = "jsp/start";
    @RequestMapping(value = "/start", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ModelAndView getViewStart(){
        ModelAndView mv = new ModelAndView(PATH_START);
        return mv;
    }
}
