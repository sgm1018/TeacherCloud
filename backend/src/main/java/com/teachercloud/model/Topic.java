package com.teachercloud.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Topic extends Entidad {

    private String title;

    @ManyToOne
    private Forum forum;

    @OneToMany(mappedBy = "topic")
    private List<Comment> comments;

    // Getters y setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}