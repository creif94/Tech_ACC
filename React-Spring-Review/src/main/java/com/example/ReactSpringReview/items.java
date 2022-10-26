package com.example.ReactSpringReview;
import javax.persistence.*;
import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "content")
    private String content;
    @Column(name ="completed")
    private boolean completed;

    public items (){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
