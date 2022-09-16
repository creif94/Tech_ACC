package com.example.FirstSpringBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class endPointsController {
    @GetMapping("/")
    public String getIndex(){
        return "GET to index route";
    }
    @PostMapping("/task")
    public String postIndex(){
        return "Post to Index route";
    }
}
