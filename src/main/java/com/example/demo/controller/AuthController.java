package com.example.demo.controller;

import com.example.demo.model.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserAccountService userService;

    public AuthController(UserAccountService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        
        UserAccount user = userService.findByEmail(email);
        
        if (user == null) {
            return ResponseEntity.status(401).body("Authentication Failed: User not found");
        }

        return ResponseEntity.ok("Login successful for: " + user.getEmail());
    }
}