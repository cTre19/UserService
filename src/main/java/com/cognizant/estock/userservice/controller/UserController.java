package com.cognizant.estock.userservice.controller;

import com.cognizant.estock.userservice.domain.User;
import com.cognizant.estock.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/market/users")
@CrossOrigin
@Slf4j
public class UserController {

    private UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping
    public User getUser(String email) {
        return userService.getUserByEmail(email);
    }
}
