package com.supinfo.homeplanning.controller;

import com.supinfo.homeplanning.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(path = "/admin/message/add", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public String addMessage(@RequestParam(name = "message") String message){
        messageService.addMessage(message);
        return "redirect:/admin#tabs-2";

    }

    @RequestMapping(path = "/api/admin/message/delete", method = RequestMethod.GET)
    public @ResponseBody String deleteMessage(@RequestParam(name = "messageId") Long messageId){
        messageService.deleteMessage(messageId);
        return "true"; //For beauty ^^
    }

}
