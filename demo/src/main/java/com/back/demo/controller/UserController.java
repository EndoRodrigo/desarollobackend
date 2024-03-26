package com.back.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.demo.model.User;
import com.back.demo.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    public static String MI_VARIABLE = "";

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User entity) { 
        return userService.createUser(entity);
    }

    @PostMapping("/validate")
    public String validUser(@RequestBody User entity) { 
        String token = userService.getUser(entity);
        logger.info("El token generado es: {}", token);
        MI_VARIABLE = token;
        return token;
        
    }
    

}
