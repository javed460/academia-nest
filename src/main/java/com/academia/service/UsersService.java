package com.academia.service;

import com.academia.model.Users;
import com.academia.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public Optional<Users> getUser(String username, String password) {
        return usersRepository.findByUsernameAndPassword(username, password);
    }

    public void saveUser(Users user) {
        usersRepository.save(user);
    }
}
