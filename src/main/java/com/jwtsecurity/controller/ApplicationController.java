package com.jwtsecurity.controller;

import com.jwtsecurity.model.User;
import com.jwtsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/process")
    public String process(){
        return "Logged In successfully";
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        repository.save(user);
        return "User added!";
    }
}
