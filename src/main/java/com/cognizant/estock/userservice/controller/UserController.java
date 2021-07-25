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

    @GetMapping("/get/user/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        return new ResponseEntity<User>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @PostMapping("/register/user")
    public ResponseEntity<User> registerNewUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.register(user), HttpStatus.CREATED);
    }

    @PutMapping("/update/user")
    public ResponseEntity updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/delete/user")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }
}
