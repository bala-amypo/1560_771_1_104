package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.model.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserAccountService userService;

    public AuthController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody AuthRequest request) {
        UserAccount user = userService.findByEmail(request.getEmail());
        
        // Basic check to see if user exists (Simple logic for now)
        if (user == null) {
            return ResponseEntity.status(401).body("User not found");
        }

        // Returning a simple success message since JWT is removed
        return ResponseEntity.ok("Login successful for user: " + user.getEmail());
    }
}