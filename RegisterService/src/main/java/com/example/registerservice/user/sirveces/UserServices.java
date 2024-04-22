package com.example.registerservice.user.sirveces;

import com.example.registerservice.user.User;

public interface UserServices {
    User add(User user);
    User update(User user);
    User get(Long id);
    User getByEmail(String email);
    User getByPhone(String phone);
    void deleteById(Long id);
}
