package com.example.securiteproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String password;
    String email;
    @ManyToOne
    Roles roles=new Roles(1L,"user");
}
