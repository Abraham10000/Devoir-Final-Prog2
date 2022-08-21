package com.example.demo.example.controller;


import com.example.demo.example.model.User;
import com.example.demo.example.service.PostService;
import com.example.demo.example.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
public class UserController {
    private UserService userService;
    private PostService postService;

    @GetMapping("/")
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getById(userId);
    }



    @PostMapping("/users")
    public List<User> saveUsers(@RequestBody List<User> users){
        return userService.saveAll(users);
    }
}
