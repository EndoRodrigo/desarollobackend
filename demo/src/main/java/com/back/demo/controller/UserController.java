package com.back.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.demo.model.User;
import com.back.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth/login")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User entity) { 
        return userService.createUser(entity);
    }

    @PostMapping("/validate")
    public String validUser(@RequestBody User entity) { 
        return userService.getUser(entity);
    }
    

}
