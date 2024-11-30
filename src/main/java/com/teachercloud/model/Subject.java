package com.teachercloud.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Subject extends Entidad {

    private String name;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "subject")
    private List<Task> tasks;

    @OneToMany(mappedBy = "subject")
    private List<Event> events;

    @OneToOne
    private Forum forum;

    // Getters y setters
}