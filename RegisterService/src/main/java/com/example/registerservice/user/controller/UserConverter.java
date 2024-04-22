package com.example.registerservice.user.controller;

import com.example.registerservice.role.Role;
import com.example.registerservice.role.RoleEnum;
import com.example.registerservice.role.RoleRepository;
import com.example.registerservice.user.User;
import com.example.registerservice.user.controller.UserRequest;
import com.example.registerservice.user.controller.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public  class UserConverter {
    private final RoleRepository roleRepository;
    User convertToUser(UserRequest request){

        return User.builder()
                .phone(request.getPhone())
                .password(request.getPassword())
                .email(request.getEmail())
                .name(request.getName())
                .role(roleRepository.findByRole(RoleEnum.valueOf(request.getRole())).get())
                .build();
    }
    UserResponse convertToResponse(User user){

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getRole().getRole().name())
                .build();
    }
}
