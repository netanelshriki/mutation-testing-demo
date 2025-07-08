package com.example.mutationdemo;

/**
 * Simple Calculator demonstrating the gap between line coverage and mutation coverage.
 * 
 * This class contains business logic with conditions, boundaries, and mathematical operations
 * that are perfect for revealing weak tests through mutation testing.
 */
public class Calculator {

    /**
     * Adds two numbers with validation.
     * Demonstrates boundary conditions and mathematical operations.
     */
    public int add(int a, int b) {
        if (a < 0 || b < 0) {
            return 0;  // Business rule: no negative inputs
        }
        return a + b;
    }

    /**
     * Divides two numbers with zero check.
     * Perfect for demonstrating boundary testing.
     */
    public int divide(int a, int b) {
        if (b == 0) {
            return 0;  // Avoid division by zero
        }
        return a / b;
    }

    /**
     * Checks if a number is even.
     * Simple modulo operation perfect for mutation testing.
     */
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Returns grade based on score with multiple boundaries.
     * Demonstrates multiple conditional boundaries.
     */
    public String getGrade(int score) {
        if (score >= 90) {
            return "A";
        }
        if (score >= 80) {
            return "B";
        }
        if (score >= 70) {
            return "C";
        }
        return "F";
    }

    /**
     * Calculates discount based on age and amount.
     * Complex business logic with multiple conditions.
     */
    public double calculateDiscount(int age, double amount) {
        double discount = 0.0;
        
        if (age >= 65) {
            discount = 0.15;  // Senior discount
        } else if (age <= 12) {
            discount = 0.10;  // Child discount
        }
        
        if (amount > 100) {
            discount += 0.05;  // Large purchase bonus
        }
        
        return discount;
    }

    /**
     * Validates if a number is positive and within range.
     * Multiple conditions perfect for mutation testing.
     */
    public boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }
}