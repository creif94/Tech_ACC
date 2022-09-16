package com.example.JPATesting;
import javax.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.PrimaryView.class)
    private Long id;
    @JsonView(Views.PrimaryView.class)
    private String title;


    @Column(columnDefinition = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonView(Views.LimitedView.class)
    private LocalDate deliveredOn;

    public Lesson() {}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeliveredOn() {
        return deliveredOn;
    }

    public void setDeliveredOn(LocalDate deliveredOn) {
        this.deliveredOn = deliveredOn;
    }
}