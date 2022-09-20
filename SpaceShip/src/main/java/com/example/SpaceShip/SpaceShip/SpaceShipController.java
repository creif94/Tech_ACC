package com.example.SpaceShip.SpaceShip;

import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.NoSuchElementException;

@RestController
@RequestMapping("/spaceShip")
public class SpaceShipController {

    SpaceShipRepo repo;

    //Default Constructor
    public SpaceShipController(SpaceShipRepo repo) {
        this.repo = repo;
    }

    @GetMapping(value = "")
    public List<SpaceShipEntity> getAll() {
         return this.repo.findAll();
    }

    @PostMapping("")
    public SpaceShipEntity createNewSpaceShip(@RequestBody SpaceShipEntity SpaceShip) {
        System.out.println("****** "+ SpaceShip + " ***********");
        return this.repo.save(SpaceShip);
    }


}
