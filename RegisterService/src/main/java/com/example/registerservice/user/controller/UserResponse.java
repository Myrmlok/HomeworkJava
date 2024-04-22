package com.example.registerservice.user.controller;

import com.example.registerservice.role.RoleEnum;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    @NonNull
    Long id;
    @NonNull
    String name;
    @NonNull
    String email;
    String phone;
    @NonNull
    String role;
}
