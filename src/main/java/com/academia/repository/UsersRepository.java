package com.academia.repository;

import com.academia.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<Users, Integer> {

    Optional<Users> findByUsernameAndPassword(String username, String password);
}
