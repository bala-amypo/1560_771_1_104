package com.example.demo.Model;

public class UserAccount {
     private long id;
     private String fullName;
     private String email;
     private String passwordHash;
     private String role;
     private Boolean active;

     public UserAccount {

     }
     public UserAccount(String fullName,String email,String passwordHash,String role,Boolean active){
        this.fullName = fullName;
        this.email = email;
        
     }
}