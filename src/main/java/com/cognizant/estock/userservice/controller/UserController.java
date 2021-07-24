package com.cognizant.estock.userservice.controller;

import com.cognizant.estock.userservice.domain.User;
import com.cognizant.estock.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/market/users")
@CrossOrigin
@Slf4j
public class UserController {

    private UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping
    public ResponseEntity<User> getUser(@RequestBody String email) {
        return new ResponseEntity<User>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.register(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteUser(User user) {
        userService.deleteUser(user);
    }
}
