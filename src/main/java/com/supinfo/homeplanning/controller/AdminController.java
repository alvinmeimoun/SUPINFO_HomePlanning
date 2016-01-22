package com.supinfo.homeplanning.controller;

import com.supinfo.homeplanning.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(){
        return new ModelAndView("admin", "adminModel",
                adminService.generateAdminModel());
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("login");
    }

}
