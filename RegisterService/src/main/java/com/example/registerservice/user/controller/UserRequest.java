package com.example.registerservice.user.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
@Data
@Builder
public class UserRequest {

    @NonNull
     String name;
    @NonNull
     String email;
     String phone;
    @NonNull
     String password;
    @NonNull
     String role;

}
