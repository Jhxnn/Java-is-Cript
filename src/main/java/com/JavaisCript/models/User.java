package com.JavaisCript.models;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID userId;

    private String email;

    private String pass;

    public User(UUID userId, String email, String pass) {
        this.userId = userId;
        this.email = email;
        this.pass = pass;
    }

    public User() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}


