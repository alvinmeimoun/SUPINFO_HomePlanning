package com.supinfo.homeplanning.controller;

import com.supinfo.homeplanning.service.PlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PlanningController {

    @Autowired
    PlanningService planningService;

    @RequestMapping(path = "/admin/planning/upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public String uploadPlanning(@RequestParam("file") MultipartFile file) throws Exception {
        try {
            planningService.uploadPlanning(file.getInputStream());

            return "redirect:/admin?success=true";
        }
        catch (Exception e)
        {
            return "redirect:/admin?success=false";
        }
    }

}
