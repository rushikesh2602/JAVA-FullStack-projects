package com.jwt.services;

import com.jwt.Entity.User;
import com.jwt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

 public List<User> getUser() {
    return userRepository.findAll();
 }

public User createUser(User user) {

     user.setUserId(UUID.randomUUID().toString());
     user.setPassword(passwordEncoder.encode(user.getPassword()));
     return  userRepository.save(user);
}
}

