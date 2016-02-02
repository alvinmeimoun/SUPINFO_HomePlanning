package com.supinfo.homeplanning.service;

import com.supinfo.homeplanning.entity.MessageEntity;
import com.supinfo.homeplanning.repository.MessageRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class MessageService {

    @Resource
    MessageRepository messageRepository;

    public Long addMessage(String message){
        MessageEntity entity = new MessageEntity().setCreationDate(new Date(System.currentTimeMillis()))
                .setMessage(message);
        messageRepository.save(entity);

        return entity.getId();
    }

    public void deleteMessage(Long messageId){
        messageRepository.delete(messageId);
    }

}
