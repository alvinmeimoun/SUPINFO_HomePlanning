package com.supinfo.homeplanning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublicController {

    @RequestMapping(path = { "/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home(){
        return new ModelAndView("home");
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public ModelAndView hello(){
        return new ModelAndView("hello");
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("login");
    }
}
