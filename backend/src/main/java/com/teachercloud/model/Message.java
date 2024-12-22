package com.teachercloud.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Message extends Entidad {

    private String content;
    private LocalDateTime sendDate;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User recipient;

    // Getters y setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDateTime sendDate) {
        this.sendDate = sendDate;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}