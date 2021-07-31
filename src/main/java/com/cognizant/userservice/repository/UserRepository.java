package com.cognizant.userservice.repository;

import com.cognizant.userservice.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findUserEntitiesByEmail(String email);

    UserEntity findUserEntitiesByEmailAndEncryptedPassword(String email, String encryptedPassword);

}
