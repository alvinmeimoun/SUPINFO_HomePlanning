package com.supinfo.homeplanning.controller;

import com.supinfo.homeplanning.service.PlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class AdminController {

    @Autowired
    PlanningService planningService;


    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(){
        return new ModelAndView("admin");
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping(path = "/admin/planning/upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public String uploadPlanning(@RequestParam("file") MultipartFile file) throws Exception {
        planningService.uploadPlanning(file.getInputStream());
        return "redirect:/admin";
    }
}
