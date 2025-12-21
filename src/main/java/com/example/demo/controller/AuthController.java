package com.example.demo.controller;

import com.example.demo.dto.AuthRequest; // Uncommented
import com.example.demo.dto.AuthResponse; // Uncommented
import com.example.demo.model.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserAccountService userService;
    private final JwtUtil jwtUtil; // Uncommented

    public AuthController(UserAccountService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil; // Uncommented
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest request) {
        UserAccount user = userService.findByEmail(request.getEmail());
        
        // Removed the stray closing brace that was here
        
        String token = jwtUtil.generateToken(user);
        
        // Added the token to the response (assuming AuthResponse takes a token)
        return ResponseEntity.ok(new AuthResponse(token)); 
    }
}