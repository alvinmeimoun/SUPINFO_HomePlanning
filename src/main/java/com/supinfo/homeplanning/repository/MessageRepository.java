package com.supinfo.homeplanning.repository;

import com.supinfo.homeplanning.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

}