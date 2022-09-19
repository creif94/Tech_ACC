package com.example.SpaceShip.CrewMember;

import javax.persistence.*;


@Entity
@Table(name = "crewMember")
public class CrewMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crewMemberID;

    // Instanciating a new Column crewName
    @Column(name = "crewName")
    private String crewName;

    // Default constructor
    public CrewMember(){}

    //Getters and Setters
    public Long getCrewMemberID() {
        return crewMemberID;
    }

    public void setCrewMemberID(Long crewMemberID) {
        this.crewMemberID = crewMemberID;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }
}
