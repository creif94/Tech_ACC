package com.example.SpaceShip.CrewMember;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
//import java.util.NoSuchElementException;
import Exception.*;


@RestController
@RequestMapping("/crewMember")
public class CrewMemberController {

    // Notes:
    // 404 -- Requested Page Not Avaliable
    // 500 -- Error in Logic
//    CrewMemberRepo repo; // Moving over to the Service Class
    ServiceClass service; // Service Class Instanciating
//    public CrewMemberController(CrewMemberRepo repo){
//        this.repo = repo;
//    }
    public CrewMemberController(ServiceClass service){
        this.service = service;
    }
    //Gets
    //Get All Crew Members
    @GetMapping("")
    public List<CrewMember> getAllCrewMembers(){
         return this.service.findAll();
//        return this.repo.findAll(); // Calling the instance of repo, finding all the crew members with .findAll()
    }
    // Get Single Crew Member
    @GetMapping("/{id}")
    public CrewMember getCrewMemberById(@PathVariable("id") Long id){
        return this.service.findID(id);
//        try { return this.repo.findById(id).get();}
//        catch (NoSuchElementException e ){
//            throw new ApiRequestException("ID: %d not found");
//        }
    }

    //Posts
    @PostMapping("")
    // @RequestBody is taking in the body of a Json, and passing the var's to the PoJo crewMember
//    public CrewMember postCrewMember(@RequestBody CrewMember crewMember){
      public void postCrewMember(@RequestBody CrewMember crewMember){
        System.out.println("**********"+crewMember.getCrewName()+"********************************************************************");
//        return this.repo.save(crewMember);
        this.service.creatingCrewMember(crewMember);
    }

    //Deletes
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCrewMember(@PathVariable("id") Long id) {
        return this.service.deleteMember(id);

//        try {
//            Optional<CrewMember> crewMember = this.repo.findById(id);
//            if (crewMember.isPresent()) {
////                crewMember crewMember1 = this.repo.findById(id).get();
//                System.out.println("***************** "+ crewMember.get().getCrewName()+" Was Deleted ****************");
//                this.repo.delete(crewMember.get());
//            }
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        } catch (NoSuchElementException e) {
//            throw new ApiRequestException("ID: %d not found");
//        }
    }
}
