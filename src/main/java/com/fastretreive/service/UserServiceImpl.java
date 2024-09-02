package com.fastretreive.service;

import com.fastretreive.entity.User;
import com.fastretreive.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    HashMap<Long,User> cache = new HashMap<>();
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        if(cache.containsKey(id))
        {
            return Optional.ofNullable(cache.get(id));
        }
        else {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
            cache.put(user.getId(),user);
            return Optional.of(user);
        }

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
