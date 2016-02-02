package com.supinfo.homeplanning.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MESSAGE")
public class MessageEntity {

    private Long id;
    private String message;
    private Date creationDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public MessageEntity setId(Long id) {
        this.id = id;
        return this;
    }

    @Lob
    @Column(name = "MESSAGE")
    public String getMessage() {
        return message;
    }

    public MessageEntity setMessage(String message) {
        this.message = message;
        return this;
    }

    @Column(name = "CREATION_DATE")
    public Date getCreationDate() {
        return creationDate;
    }

    public MessageEntity setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }
}
