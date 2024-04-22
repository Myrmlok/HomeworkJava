package com.example.securiteproject.services;

import com.example.securiteproject.entity.User;
import com.example.securiteproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServices {
    private UserRepository userRepository;
    private String encoder(String data){
        BCryptPasswordEncoder a=new BCryptPasswordEncoder(12);
        return a.encode(data);
    }
    public void Save(User user){
        user.setPassword(encoder(user.getPassword()));
        userRepository.save(user);

    }


}
