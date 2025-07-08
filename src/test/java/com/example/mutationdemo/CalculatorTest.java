package com.example.mutationdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * WEAK TESTS - Demonstrating HIGH line coverage but LOW mutation coverage!
 * 
 * These tests execute all lines of code (high JaCoCo coverage) but use weak assertions
 * that don't properly verify the behavior, allowing many mutations to survive.
 * 
 * This perfectly demonstrates why traditional coverage metrics are insufficient!
 */
@DisplayName("Calculator Tests - WEAK VERSION (High Line Coverage, Low Mutation Coverage)")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test add method")
    void testAdd() {
        // This test executes the line but uses weak assertion
        int result = calculator.add(5, 3);
        assertTrue(result >= 0);  // ❌ WEAK: Should be assertEquals(8, result)
        
        // This executes the negative condition branch
        int negativeResult = calculator.add(-1, 5);
        assertTrue(negativeResult >= 0);  // ❌ WEAK: Should verify it returns exactly 0
    }

    @Test
    @DisplayName("Test divide method")
    void testDivide() {
        // Executes normal division
        int result = calculator.divide(10, 2);
        assertTrue(result > 0);  // ❌ WEAK: Should be assertEquals(5, result)
        
        // Executes division by zero condition
        int zeroResult = calculator.divide(10, 0);
        assertTrue(zeroResult >= 0);  // ❌ WEAK: Should verify it returns exactly 0
    }

    @Test
    @DisplayName("Test isEven method")
    void testIsEven() {
        // Executes the method but doesn't verify result!
        boolean result = calculator.isEven(4);
        // ❌ WORST: No assertion at all! Still counts as line coverage
        
        // Execute with odd number
        calculator.isEven(5);  // ❌ No assertion again!
    }

    @Test
    @DisplayName("Test getGrade method")
    void testGetGrade() {
        // Tests all grade boundaries but with weak assertions
        String gradeA = calculator.getGrade(95);
        assertNotNull(gradeA);  // ❌ WEAK: Should verify exact grade "A"
        
        String gradeB = calculator.getGrade(85);
        assertNotNull(gradeB);  // ❌ WEAK: Should verify exact grade "B"
        
        String gradeC = calculator.getGrade(75);
        assertNotNull(gradeC);  // ❌ WEAK: Should verify exact grade "C"
        
        String gradeF = calculator.getGrade(65);
        assertNotNull(gradeF);  // ❌ WEAK: Should verify exact grade "F"
    }

    @Test
    @DisplayName("Test calculateDiscount method")
    void testCalculateDiscount() {
        // Executes senior discount logic
        double seniorDiscount = calculator.calculateDiscount(70, 150);
        assertTrue(seniorDiscount > 0);  // ❌ WEAK: Should verify exact value 0.20
        
        // Executes child discount logic
        double childDiscount = calculator.calculateDiscount(10, 50);
        assertTrue(childDiscount >= 0);  // ❌ WEAK: Should verify exact value 0.10
        
        // Executes no discount scenario
        double noDiscount = calculator.calculateDiscount(30, 50);
        assertTrue(noDiscount >= 0);  // ❌ WEAK: Should verify exactly 0.0
    }

    @Test
    @DisplayName("Test isValidScore method")
    void testIsValidScore() {
        // Executes valid score
        boolean valid = calculator.isValidScore(50);
        // ❌ NO ASSERTION! Line is covered but behavior not verified
        
        // Executes invalid negative score
        calculator.isValidScore(-1);  // ❌ NO ASSERTION!
        
        // Executes invalid high score
        calculator.isValidScore(101);  // ❌ NO ASSERTION!
    }

    @Test
    @DisplayName("Test boundary conditions - but weakly")
    void testBoundaryConditions() {
        // These execute boundary lines but don't test boundaries properly
        calculator.getGrade(90);   // Boundary: should be "A"
        calculator.getGrade(89);   // Boundary: should be "B"
        calculator.getGrade(80);   // Boundary: should be "B"  
        calculator.getGrade(79);   // Boundary: should be "C"
        
        // ❌ NO ASSERTIONS for any of these critical boundary tests!
        assertTrue(true);  // Meaningless assertion just to have something
    }
}

/**
 * EXPECTED RESULTS:
 * 
 * JaCoCo Line Coverage: ~95-100%
 * - All lines are executed by these tests
 * - Looks great in traditional coverage reports!
 * 
 * PIT Mutation Coverage: ~25-40%
 * - Many mutations will survive because:
 *   - Weak assertions don't catch value changes
 *   - Missing assertions don't catch any changes
 *   - Boundary conditions aren't properly tested
 *   - Mathematical operations aren't verified
 * 
 * This demonstrates the critical gap between line coverage and test quality!
 */