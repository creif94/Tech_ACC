package com.example.springTest;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "donut")
public class donut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "topping")
    private String topping;
    @Column(name = "experation")
    private String experation;

    public donut() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getExperation() {
        return experation;
    }

    public void setExperation(String experation) {
        this.experation = experation;
    }
}
