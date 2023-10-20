package com.example.lab2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {
    @GetMapping("/home")
    public String showDog(){
        return "home";
    }
}
