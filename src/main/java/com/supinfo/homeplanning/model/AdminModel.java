package com.supinfo.homeplanning.model;

import com.supinfo.homeplanning.entity.MessageEntity;

import java.util.List;

public class AdminModel {

    private List<MessageEntity> messages;

    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }
}
