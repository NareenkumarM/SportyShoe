package com.sportyshoe.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    // Sample in-memory list of products
    private static List<Product> productList = new ArrayList<Product>();

    // Initialize sample data
    static {
        productList.add(new Product(1, "Running Shoes", 99.99));
        productList.add(new Product(2, "Soccer Cleats", 79.99));
        productList.add(new Product(3, "Basketball Sneakers", 109.99));
        // Add more products as needed
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productList;
    }

    // Define a Product class to represent a product
    public static class Product {
        private int id;
        private String name;
        private double price;

        public Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

     // Getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        // Setters
        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

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

        // Setters
        public void setId(int id) {
            this.id = id;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
