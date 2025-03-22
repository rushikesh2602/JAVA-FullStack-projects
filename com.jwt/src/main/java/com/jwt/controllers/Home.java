package com.jwt.controllers;

import com.jwt.Entity.User;
import com.jwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class Home {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUser() {
        System.out.println("Getting Users");

        return userService.getUser();
    }

    @GetMapping("/current-user")
    public String getLoggedInuser(Principal principal) {
    return principal.getName();
    }
}
