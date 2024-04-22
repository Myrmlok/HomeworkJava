package com.example.registerservice.user;

import com.example.registerservice.role.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "phone")
    String phone;
    @ManyToOne()
    Role role;
}
