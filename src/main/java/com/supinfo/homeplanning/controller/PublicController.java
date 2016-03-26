package com.supinfo.homeplanning.controller;

import com.supinfo.homeplanning.model.HomeModel;
import com.supinfo.homeplanning.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublicController {

    @Autowired
    PublicService publicService;

    @RequestMapping(path = { "/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home(){
        HomeModel model = publicService.generateHomeModel();
        return new ModelAndView("home", "homeModel", model);
    }


}
