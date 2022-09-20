package com.example.SpaceShip.CrewMember;

import org.springframework.data.jpa.repository.JpaRepository;

// This is how JPA interacts with the DataBase SPACESHIP
// <This is the Entity Class, this is the Type for the PK>
public interface CrewMemberRepo extends JpaRepository<CrewMember, Long> {

}
