package com.task1.fizzbuzz;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the FizzBuzzController.java class.
 */
@SpringBootTest
class FizzBuzzControllerTest {
    static FizzBuzzController controller = new FizzBuzzController();


    /**
     * Tests if FizzBuzzController.fizzBuzz(num) returns the right result and wether it is in the right format.
     *
     * @param controller
     */
    @Test
    public void isReturnValueAsExpected(@Autowired FizzBuzzController controller) {
        String expectedValue =  "[\"1\",\"2\",\"Fizz\",\"4\",\"Buzz\"," +
                                "\"Fizz\",\"7\",\"8\",\"Fizz\",\"Buzz\"" +
                                ",\"11\",\"Fizz\",\"13\",\"14\",\"FizzBuzz\"]";
        int testNumber = 15;
        assertEquals(expectedValue,controller.fizzBuzz(testNumber));
    }
}