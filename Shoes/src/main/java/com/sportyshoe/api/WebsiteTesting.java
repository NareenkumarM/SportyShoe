package com.sportyshoe.api;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebsiteTesting {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
    	System.setProperty("webdriver.chrome.driver", "/bin/google-chrome");
    	WebDriver driver = new ChromeDriver();

        // Configure Chrome options (if needed)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize the browser window

        

        try {
            // Navigate to the Sporty Shoes website
            driver.get("https://sportyshoes.com/");

            // Test user interactions
            testSignUp(driver);
            testLogin(driver);
            testAddToCart(driver);
            testEditProfile(driver);
            testCheckout(driver);

        } finally {
            // Close the browser at the end of the tests
            driver.quit();
        }
    }

    // Test signing up
    private static void testSignUp(WebDriver driver) {
        // Navigate to the signup page
        driver.findElement(By.linkText("Sign Up")).click();

        // Fill in signup form fields
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement signUpButton = driver.findElement(By.id("sign-up-button"));

        emailField.sendKeys("testuser@example.com");
        passwordField.sendKeys("password123");
        signUpButton.click();

        // Verify successful signup (you might need to locate elements on the resulting page)
        // Assert.assertTrue(driver.findElement(By.id("success-message")).isDisplayed());
    }

    // Test logging in
    private static void testLogin(WebDriver driver) {
        // Navigate to the login page
        driver.findElement(By.linkText("Log In")).click();

        // Fill in login form fields
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        emailField.sendKeys("testuser@example.com");
        passwordField.sendKeys("password123");
        loginButton.click();

        // Verify successful login (you might need to locate elements on the resulting page)
        // Assert.assertTrue(driver.findElement(By.id("welcome-message")).isDisplayed());
    }

    // Test adding items to cart
    private static void testAddToCart(WebDriver driver) {
        // Navigate to a product listing page
        driver.findElement(By.linkText("Shop")).click();

        // Click on a product to view its details
        driver.findElement(By.linkText("Product Name")).click();

        // Add the product to the cart
        driver.findElement(By.id("add-to-cart-button")).click();

        // Verify that the item is added to the cart (you might need to locate cart elements)
        // Assert.assertTrue(driver.findElement(By.id("cart-item-count")).getText().equals("1"));
    }

    // Test editing profile
    private static void testEditProfile(WebDriver driver) {
        // Navigate to the user dashboard or profile page
        driver.findElement(By.linkText("My Account")).click();

        // Click on the "Edit Profile" button
        driver.findElement(By.id("edit-profile-button")).click();

        // Update profile information (e.g., change name)
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement updateButton = driver.findElement(By.id("update-profile-button"));

        nameField.clear();
        nameField.sendKeys("New Name");
        updateButton.click();

        // Verify profile update (you might need to locate elements on the resulting page)
        // Assert.assertTrue(driver.findElement(By.id("success-message")).isDisplayed());
    }

    // Test completing checkout
    private static void testCheckout(WebDriver driver) {
        // Navigate to the cart
        driver.findElement(By.id("cart-link")).click();

        // Click on the "Checkout" button
        driver.findElement(By.id("checkout-button")).click();

        // Fill in shipping information (address, payment details, etc.)
        WebElement addressField = driver.findElement(By.id("address"));
        WebElement paymentField = driver.findElement(By.id("payment"));

        addressField.sendKeys("123 Main St");
        paymentField.sendKeys("Credit Card Number");

        // Click the "Place Order" button
        driver.findElement(By.id("place-order-button")).click();

        // Verify order confirmation (you might need to locate elements on the resulting page)
        Assert.assertTrue(driver.findElement(By.id("order-confirmation")).isDisplayed());
    }
}

