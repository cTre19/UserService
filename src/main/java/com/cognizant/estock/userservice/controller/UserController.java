package com.cognizant.estock.userservice.controller;

import com.cognizant.estock.userservice.model.response.UserDetailsResponse;
import com.cognizant.estock.userservice.model.Credentials;
import com.cognizant.estock.userservice.model.request.UserDetailsRequest;
import com.cognizant.estock.userservice.model.sharedDTO.UserDTO;
import com.cognizant.estock.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1.0/market/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping("/register/user")
    public ResponseEntity<UserDetailsResponse> registerNewUser(@RequestBody UserDetailsRequest userDetails) {
        UserDetailsResponse response = new UserDetailsResponse();

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userDetails, userDTO);

        UserDTO createdUser = userService.register(userDTO);
        BeanUtils.copyProperties(createdUser, response);

        return new ResponseEntity<UserDetailsResponse>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get/user/{email}")
    public ResponseEntity<UserDetailsResponse> getUser(@PathVariable String email) {
        log.info("Fetching user with email: " + email);

        HttpStatus status;

        UserDetailsResponse response = new UserDetailsResponse();
        UserDTO fetchedUser = userService.getUserByEmail(email);
        BeanUtils.copyProperties(fetchedUser, response);

        if(fetchedUser == null || fetchedUser.getEmail() == null) {
            log.info("User not found!");
            status = HttpStatus.NO_CONTENT;
        } else {
            status = HttpStatus.OK;
            log.info("User found");
        }
        return new ResponseEntity<UserDetailsResponse>(response, status);
    }

//    @GetMapping("/login")
//    public ResponseEntity<UserDetailsResponse> login(@RequestBody Credentials credentials) {
//        UserDetailsResponse user = userService.login(credentials.getEmail(), credentials.getPassword());
//        HttpStatus status;
//
//        if(user == null) {
//            log.info("User not found!");
//            status = HttpStatus.UNAUTHORIZED;
//        } else {
//            log.info("User successfully logged in!");
//            status = HttpStatus.OK;
//        }
//       return new ResponseEntity(user, status);
//    }
//
//
//    @PutMapping("/update/user")
//    public ResponseEntity updateUser(@RequestBody UserDetailsResponse user) {
//        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/user")
//    public void deleteUser(@RequestBody UserDetailsResponse user) {
//        userService.deleteUser(user);
//    }
}
