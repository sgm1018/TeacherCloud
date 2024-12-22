package com.teachercloud.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateCreation;
    private LocalDateTime dateUpdate;

    private String userIdCreator;
    private String userIdUpdater;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getUserIdCreator() {
        return userIdCreator;
    }

    public void setUserIdCreator(String userIdCreator) {
        this.userIdCreator = userIdCreator;
    }

    public String getUserIdUpdater() {
        return userIdUpdater;
    }

    public void setUserIdUpdater(String userIdUpdater) {
        this.userIdUpdater = userIdUpdater;
    }
}