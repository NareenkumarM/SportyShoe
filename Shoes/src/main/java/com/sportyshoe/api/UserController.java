package com.sportyshoe.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class UserController {

    // Sample in-memory list of registered users
    private static List<User> userList = new ArrayList<>();

    // Initialize sample data
    static {
        userList.add(new User(1, "nareen@example.com", "Nareen Kumar"));
        userList.add(new User(2, "ruchi@example.com", "Ruchitha"));
        userList.add(new User(3, "manohar@example.com", "Manohar"));
        // Add more users as needed
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userList;
    }

    // Define a User class to represent a registered user
    public static class User {
        private int id;
        private String email;
        private String name;

        public User(int id, String email, String name) {
            this.id = id;
            this.email = email;
            this.name = name;
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }
    }
}
