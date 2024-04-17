package com.app.SpringSecurity.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class TestAuthController {
    
    @GetMapping("/")
    public String helloGet(){
        return "Hello World - GET";
    }

    @PostMapping("/")
    public String helloPost(){
        return "Hello World - POST";
    }

    @PutMapping("/")
    public String helloPut(){
        return "Hello World - PUT";
    }

    @DeleteMapping("/")
    public String helloDelete(){
        return "Hello World - DELETE";
    }

    @PatchMapping("/")
    public String helloPatch(){
        return "Hello World - REFACTOR";
    }
    
}
