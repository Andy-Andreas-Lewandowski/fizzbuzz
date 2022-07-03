package com.task1.fizzbuzz;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


/**
 * Class to unit-test the FizzBuzzService.java class.
 */
class FizzBuzzServiceTest {
    static FizzBuzzService service = new FizzBuzzService();
    static List<String> fizzBuzzList;

    /**
     * Initializes the testing environment.
     */
    @BeforeAll
    private static void initializingTests(){
        fizzBuzzList = service.getFizzBuzzList(1000);
    }

    /**
     * Test wether every third element of the fizzbuzz-list is "Fizz", every fifteenth element excluded.
     */
    @Test
    public void fizzIfDivisibleByThree(){
        for(int i = 2; i < fizzBuzzList.size();i+=3){
            if((i+1)%15 == 0) continue;
            assertEquals("Fizz",fizzBuzzList.get(i),"FAIL: Number %s is not \"Fizz\"".formatted((i+1)));
        }
    }

    /**
     * Test wether every fifth element of the fizzbuzz-list is "Buzz, every fifteenth element excluded.
     */
    @Test
    public void buzzIfDivisibleByFive(){
        for(int i = 4; i < fizzBuzzList.size();i+=5){
            if((i+1)%15 == 0) continue;
            assertEquals("Buzz",fizzBuzzList.get(i),"FAIL: Number %s is not \"Buzz\"".formatted((i+1)));
        }
    }

    /**
     * Test wether every fifteenth element is exactly "FizzBuzz"
     */
    @Test
    public void fizzBuzzIfDivisibleByFifteen(){
        for(int i = 14; i < fizzBuzzList.size();i+=15){
            assertEquals("FizzBuzz",fizzBuzzList.get(i),"FAIL: Number %s is not \"FizzBuzz\"".formatted((i+1)));
        }
    }

    /**
     * Test wether a not by 3 or by 5 divisible number is displayed as such.
     */
    @Test
    public void numberIfNotDivisible(){
        for(int i = 0; i < fizzBuzzList.size();i++){
            int numberFromIndex = i+1;
            if(numberFromIndex % 5 == 0 || numberFromIndex % 3 == 0) continue;

            assertEquals(String.valueOf(numberFromIndex),fizzBuzzList.get(i),"FAIL: Number %s is not propagated".formatted((i+1)));
        }
    }

}