package com.supinfo.homeplanning.controller;

import com.supinfo.homeplanning.model.HomeModel;
import com.supinfo.homeplanning.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

@Controller
public class PublicController {

    @Autowired
    PublicService publicService;

    @RequestMapping(path = { "/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home(@RequestParam(name = "date", required = false)
                                 @DateTimeFormat(pattern="dd-MM-yyyy") Date planningDate){
        Date selectedDate = planningDate != null ? planningDate : new Date(System.currentTimeMillis());

        HomeModel model = publicService.generateHomeModel(selectedDate);
        return new ModelAndView("home", "homeModel", model);
    }


}
