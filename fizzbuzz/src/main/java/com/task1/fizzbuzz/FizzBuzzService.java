package com.task1.fizzbuzz;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class to do a FizzBuzz game on a iterable collection.
 *
 * @param <T> Data type on which a FizzBuzz game should be evaluated. (Does only support integers at the time beeing)
 */
@Service
public class FizzBuzzService<T> {

    /**
     * A List containing converters, the lower the index the higher the priority of the conversion rule.
     */
    private final List<Converter> rules = List.of(
            // Rule for FizzBuzz
            (Converter<Integer>) input -> {
                if(input % 15 == 0) return "FizzBuzz";
                return null;
            },
            // Rule for Fizz
            (Converter<Integer>) input -> {
                if(input % 3 == 0) return "Fizz";
                return null;
            },
            // Rule for Buzz
            (Converter<Integer>) input -> {
                if(input % 5 == 0) return "Buzz";
                return null;
            },
            // Default Rule to just stringify the input
            (Converter<Integer>) input -> input.toString()
    );

    /**
     * Calculates FizzBuzz from 1 to 'to' writes the results for each element into a List and returns the List.
     *
     * @param to Ending index, inclusive
     * @return A List filled with Strings
     */
    public List<String> getFizzBuzzList(int to){
        ArrayList<Integer> set = new ArrayList(); // Creates an iterable
        for(int i = 1; i <= to;i++) set.add(i); // Fills it with the the numbers 1 to "to"

        return getFizzBuzzList((Iterable<T>) set);
    }


    /**
     * Goes over an iterable and writes the FizzBuzz result for each element into a List and returns the List.
     * @param set a collection of elements.
     * @return A List filled with Strings
     */
    public List<String> getFizzBuzzList(Iterable<T> set){
        ArrayList<String> fizzBuzzList = new ArrayList();
        // Iterates over a given, iterable collection
        for(T elem : set){
            // Iterates for the current element over the given ruleset
            for(Converter converter : rules){
                String output = converter.convert(elem);
                // Breaks the search for an applicable rule when a rule allready applied.
                if(output != null){
                    fizzBuzzList.add(output);
                    break;
                }
            }
        }
        return fizzBuzzList;
    }
}
