package com.supinfo.homeplanning.service;

import com.supinfo.homeplanning.model.AdminModel;
import com.supinfo.homeplanning.repository.MessageRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService {

    @Resource
    MessageRepository messageRepository;

    public AdminModel generateAdminModel(){
        AdminModel model = new AdminModel();

        model.setMessages(messageRepository.findAll());

        return model;
    }

}
