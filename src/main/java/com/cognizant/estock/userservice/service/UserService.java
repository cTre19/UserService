package com.cognizant.estock.userservice.service;

import com.cognizant.estock.userservice.model.entity.UserEntity;
import com.cognizant.estock.userservice.model.sharedDTO.UserDTO;
import com.cognizant.estock.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO register(UserDTO user) {
        log.info("Registering new user with id: " + user.getEmail());

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDTO returnValue = new UserDTO();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }

    public UserDTO getUserByEmail(String email) {
        log.info("fetching user by email: " + email);

        UserDTO returnValue = new UserDTO();
        UserEntity userEntity = userRepository.findUserEntitiesByEmail(email);
        BeanUtils.copyProperties(userEntity, returnValue);
        return returnValue;
    }

//    public UserDTO login(String email, String password) {
//        log.info("logging in user with email: " + email);
//
//        return userRepository.findByEmailAndPassword(email, password);
//    }
//
//
//    public List<UserDTO> getAllUsers() {
//        log.info("Fetching all registered users");
//        return userRepository.findAll();
//    }
//
//    public UserDTO updateUser(UserDTO user) {
//        log.info("Updating user: " + user.getEmail());
//        return userRepository.save(user);
//    }
//
//    public void deleteUser(UserDTO user) {
//        log.info("Removing user: " + user.getEmail());
//        userRepository.delete(user);
//    }
}
