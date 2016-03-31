package com.supinfo.homeplanning.controller;

import com.supinfo.homeplanning.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(HttpServletRequest request, HttpServletResponse response){
        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
//        response.setHeader("X-CSRF-HEADER", token.getHeaderName());
//        response.setHeader("X-CSRF-PARAM", token.getParameterName());
//        response.setHeader("X-CSRF-TOKEN", token.getToken());

        response.addCookie(new Cookie("X-CSRF-TOKEN", token.getToken()));
        return new ModelAndView("admin", "adminModel",
                adminService.generateAdminModel());
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response){

        response.addCookie(new Cookie("JSESSIONID", null));
        return "redirect:/home";
    }
}
