package com.example.demo.controller;

import com.example.demo.model.UserAccount;
import com.example.demo.service.UserAccountService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserAccountService userService;
    private final PasswordEncoder passwordEncoder;

    // Secret key for signing JWT (in real apps, load from config)
    private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expirationMs = 86400000; // 24 hours

    public AuthController(UserAccountService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        UserAccount user = userService.findByEmail(email);
        if (!passwordEncoder.matches(password, user.getPasswordHash())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        // Generate JWT directly here
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationMs);

        String token = Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getId())
                .claim("role", user.getRole())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey)
                .compact();

        return ResponseEntity.ok(
            Map.of(
                "token", token,
                "userId", user.getId(),
                "email", user.getEmail(),
                "role", user.getRole()
            )
        );
    }
}
