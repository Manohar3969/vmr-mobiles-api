package com.manohar3969.vmrmobiles_api.service;

import com.manohar3969.vmrmobiles_api.models.User;
import com.manohar3969.vmrmobiles_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Register a new user
    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already registered.");
        }
        return userRepository.save(user);
    }

    // Login a user
    public Optional<User> loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        throw new IllegalArgumentException("Invalid email or password.");
    }
}

