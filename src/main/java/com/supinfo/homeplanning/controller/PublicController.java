package com.supinfo.homeplanning.controller;

import com.supinfo.homeplanning.entity.CourseEntity;
import com.supinfo.homeplanning.model.HomeModel;
import com.supinfo.homeplanning.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class PublicController {

    @Autowired
    PublicService publicService;

    @RequestMapping(path = { "/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home(){
        //TODO set today date
        Date planningDate = Date.from(LocalDate.of(2015, Month.NOVEMBER, 3).atTime(00,00).atZone(ZoneId.systemDefault()).toInstant());
        //Date planningDate = new Date(System.currentTimeMillis());

        HomeModel model = publicService.generateHomeModel(planningDate);
        return new ModelAndView("home", "homeModel", model);
    }


}
