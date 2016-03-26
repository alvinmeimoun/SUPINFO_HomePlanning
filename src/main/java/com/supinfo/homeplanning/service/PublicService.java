package com.supinfo.homeplanning.service;

import com.supinfo.homeplanning.controller.MessageController;
import com.supinfo.homeplanning.entity.MessageEntity;
import com.supinfo.homeplanning.model.HomeModel;
import com.supinfo.homeplanning.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PublicService {

    @Autowired
    MessageService messageService;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    PlanningService planningService;

    public HomeModel generateHomeModel(){
        HomeModel model = new HomeModel();

        model.setMessages(messageRepository.findAll().stream().map(MessageEntity::getMessage)
                .collect(Collectors.toList()));

        return model;
    }

}
