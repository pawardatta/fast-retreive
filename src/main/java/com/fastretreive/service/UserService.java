package com.fastretreive.service;

import com.fastretreive.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User addUser(User user);
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();

}
