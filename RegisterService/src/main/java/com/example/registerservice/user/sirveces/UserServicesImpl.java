package com.example.registerservice.user.sirveces;

import com.example.registerservice.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices{
    private final UserRepository repository;
    @Override
    public User add(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }


    @Override
    public User get(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }

    @Override
    public User getByPhone(String phone) {
        return repository.findByPhone(phone).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.delete(get(id));
    }
}
