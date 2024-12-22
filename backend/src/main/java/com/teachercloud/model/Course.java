package com.teachercloud.model;

import jakarta.persistence.Entity;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Course extends Entidad {

    private String name;
    private String description;

    // @JoinTable(name = "User_Course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    @ManyToMany
    private List<User> users;

    @OneToMany(mappedBy = "course")
    private List<Subject> subjects;

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}