package com.cognizant.estock.userservice.repository;

import com.cognizant.estock.userservice.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findUserEntitiesByEmail(String email);

    UserEntity findUserEntitiesByEmailAndEncryptedPassword(String email, String encryptedPassword);

}
