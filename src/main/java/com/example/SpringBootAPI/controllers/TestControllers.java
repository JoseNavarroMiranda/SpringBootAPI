package com.example.SpringBootAPI.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestControllers {

    @GetMapping("/hello")
    public String hello(){
        return "Spring api test";
    }
}
