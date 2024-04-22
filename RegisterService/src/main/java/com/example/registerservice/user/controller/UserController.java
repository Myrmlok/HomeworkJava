package com.example.registerservice.user.controller;

import com.example.registerservice.user.User;
import com.example.registerservice.user.sirveces.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServices services;
    private final UserConverter userConverter;
    @PostMapping()
    ResponseEntity<UserResponse> addUser(@RequestBody UserRequest request){

        return ResponseEntity.ok(userConverter.convertToResponse(services.add(userConverter.convertToUser(request))));
    }
    @PatchMapping
     ResponseEntity<UserResponse> updateUser(@RequestBody User user){
        return ResponseEntity.ok(userConverter.convertToResponse(services.update(user)));
    }
    @DeleteMapping("/{id}")
    void deleteUSer(@PathVariable Long id){
        services.deleteById(id);
    }

}
