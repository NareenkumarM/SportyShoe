package com.sportyshoe.api;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.sportyshoe.api.ProductController.Product;

public class testcalculationservice {
	
	@Test
	public void testCalculateTotalPriceWithDiscount() {
	    // Arrange
	    Product product = new Product(1, "Running Shoes", 100.0);
	    DiscountCalculator discountCalculator = new DiscountCalculator();

	    // Act
	    double totalPrice = discountCalculator.calculateTotalPrice(product, 0.1); // 10% discount

	    // Assert
	    assertEquals(0.0, totalPrice, 0.01); // Check within a tolerance of 0.01
	}


}
