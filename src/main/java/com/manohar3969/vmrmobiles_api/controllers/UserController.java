package com.manohar3969.vmrmobiles_api.controllers;

import com.manohar3969.vmrmobiles_api.models.User;
import com.manohar3969.vmrmobiles_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    // Login a user
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String email, @RequestParam String password) {
        Optional<User> user = userService.loginUser(email, password);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().body(null));
    }
}

