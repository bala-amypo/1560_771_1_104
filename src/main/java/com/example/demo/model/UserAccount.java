package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "user_accounts",
       uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Email @NotBlank
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank @Size(min = 6)
    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @NotBlank
    @Column(name = "role", nullable = false, length = 30)
    private String role; // ADMIN, IT_OPERATOR, AUDITOR

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active = true;

    public UserAccount() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
