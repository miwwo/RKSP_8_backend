package com.project.crud.service.interfaces;

import com.project.crud.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserEntity> getUserById(Long userId);

    Optional<UserEntity> getUserByEmail(String email);

    List<UserEntity> getAllUsers();

}
