package com.supinfo.homeplanning.controller;

import com.supinfo.homeplanning.model.AddMessageModel;
import com.supinfo.homeplanning.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping(path = "/admin/message/add", method = RequestMethod.POST)
    public @ResponseBody String addMessage(@RequestBody String message){
        //return messageService.addMessage(message.getMessage()).toString();
        System.out.println(message);
        return "12";
    }

    @RequestMapping(path = "/admin/message/delete", method = RequestMethod.GET)
    public @ResponseBody Boolean deleteMessage(@RequestParam(name = "messageId") Long messageId){
        messageService.deleteMessage(messageId);
        return true;
    }

}
