package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Says that there are methods inside of Page Controller that should map to end points
public class PagesController {
    @GetMapping("/hello") // Path for the URL
    public String hello(){
        return "Hello world";
    }


}
