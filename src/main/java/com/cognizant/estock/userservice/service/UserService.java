package com.cognizant.estock.userservice.service;

import com.cognizant.estock.userservice.domain.User;
import com.cognizant.estock.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email) {
        log.info("fetching user by email: " + email);
        return userRepository.findById(email).orElseGet(User::new);
    }

    public User register(User user) {
        log.info("Registering new user with id: " + user.getEmail());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        log.info("Fetching all registered users");
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        log.info("Updating user: " + user.getEmail());
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        log.info("Removing user: " + user.getEmail());
        userRepository.delete(user);
    }
}
