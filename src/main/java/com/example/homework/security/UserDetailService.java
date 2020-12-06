package com.example.homework.security;

import com.example.homework.model.User;
import com.example.homework.repository.UserRepo;
import com.example.homework.security.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user=userRepo.findByName(username);
        user.orElseThrow(()-> new UsernameNotFoundException("Not Found : "+username));
        return new UserDetail(user.get());
    }
}
