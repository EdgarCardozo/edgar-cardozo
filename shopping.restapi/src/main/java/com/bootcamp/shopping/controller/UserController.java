package com.bootcamp.shopping.controller;

import com.bootcamp.shopping.model.User;
import com.bootcamp.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllItems(){
        return userService.find();
    }
    @PostMapping
    public User registerUser(@Valid @RequestBody User newUser){
        return userService.register(newUser);
    }

}
