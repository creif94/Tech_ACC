package com.example.JPATesting;


import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    private final LessonRepo repository; //!!!!!!!!!!! Need as this

    public LessonController(LessonRepo repository) {
        this.repository = repository;
    }

    @GetMapping("")
//    public Iterable<Lesson> all() {
    public List<Lesson> all() {
//        return this.repository.findAll();
        return this.repository.findAll(); // this.repository is how we always interact with the database
    }

    @GetMapping(value = "/{id}" , produces= "application/PrimaryView+json")
    @JsonView(Views.PrimaryView.class)
    public Lesson byId(@PathVariable Long id) {
        return this.repository.findById(id).get();
    }

    @GetMapping(value = "/{id}" , produces= "application/LimitedView+json")
    @JsonView(Views.LimitedView.class)
    public Lesson LimitedViewgetSingleID(@PathVariable Long id) {
        return this.repository.findById(id).get();
    }

//    @DeleteMapping(value = "/{id}")
//    public void delete(@PathVariable Long id) {
//        Optional<Lesson> lesson = this.repository.findById(id);
//        if (lesson.isPresent()) {
//            this.repository.delete(lesson.get());
//        }
//    }

    @DeleteMapping(value = "/{id}") //https://stackabuse.com/how-to-return-http-status-codes-in-a-spring-boot-application/
    public ResponseEntity<String> delete(@PathVariable Long id){
        Optional<Lesson> lesson = this.repository.findById(id);
        if (lesson.isPresent()) {
            this.repository.delete(lesson.get());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully deleted");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lesson not found");
        }
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        System.out.println(lesson);

        return this.repository.save(lesson);
    }

}
