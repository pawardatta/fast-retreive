package com.fastretreive.controller;

import com.fastretreive.entity.User;
import com.fastretreive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        long startTime = System.currentTimeMillis(); // Start time
        Optional<User> user = userService.getUserById(id);
        long endTime = System.currentTimeMillis(); // End time
        long timeTaken = endTime - startTime;
        System.out.println("Time taken by getUserById: " + timeTaken + " ms");

        return user;
    }
    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

}
