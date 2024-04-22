package com.example.securiteproject.controllers;

import com.example.securiteproject.entity.User;
import com.example.securiteproject.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AppController {
    UserServices userServices;
    @GetMapping()
    private String get(Model model){
        return "index";
    }
    @PostMapping()
    private void addUser(@RequestBody User user){
        userServices.Save(user);
    }
}
