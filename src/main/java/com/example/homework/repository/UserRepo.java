package com.example.homework.repository;

import com.example.homework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
    public Optional<User> findByName(String name);
}
