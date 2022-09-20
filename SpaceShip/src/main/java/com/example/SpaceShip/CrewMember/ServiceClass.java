package com.example.SpaceShip.CrewMember;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import Exception.*;

@Service
public class ServiceClass {
    //Instanciating the Repo to interact with the DataBase
    CrewMemberRepo repo;
    public ServiceClass(CrewMemberRepo repo){
        this.repo = repo;
    }

    public List<CrewMember> findAll() {
        return this.repo.findAll();
    }
    public CrewMember findID(Long id) {
        try { return this.repo.findById(id).get();}
        catch (NoSuchElementException e) {
            throw new ApiRequestException("ID Not Found");
        }
    }
    public void creatingCrewMember(CrewMember member) {
        System.out.println("*******************************************************"+member.getCrewName()+"********************************************************************");
        Long memberID = member.getCrewMemberID();
        this.repo.save(member);
//        Optional<CrewMember> testing = this.repo.findById(memberID);
//        if(!testing.isPresent()){
//            this.repo.save(member);
//        } else{
//            throw new ApiRequestException("ID Already Exists");
//        }
    }

    public ResponseEntity<String> deleteMember(Long Id) {
        CrewMember member = this.repo.findById(Id).get();
        Long id = member.getCrewMemberID();
        try {
            Optional<CrewMember> testing = this.repo.findById(id);
            this.repo.delete(testing.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch(NoSuchElementException e){
            throw new ApiRequestException("ID Not Found", e);
        }
    }









}
