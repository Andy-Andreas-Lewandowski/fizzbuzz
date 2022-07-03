package com.task1.fizzbuzz;

import com.task1.json.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller to manage requests regarding FizzBuzz.
 */
@RestController
@RequestMapping("/fizzbuzz")
public class FizzBuzzController {
    JsonService jsonService = new JsonService();

    @Autowired
    FizzBuzzService fizzBuzzService;

    /**
     * Takes a Number and returns a JSON-String representation of a list that includes FizzBuzz evaluations for
     * the number 1 to "number".
     *
     * @param number The number to which FizzBuzz should be evaluated.
     * @return
     */
    @GetMapping("/to/{number}")
    public String fizzBuzz(@PathVariable int number){
        List<String> fizzBuzzList = fizzBuzzService.getFizzBuzzList(number);
        String jsonOutput = jsonService.serialize(fizzBuzzList);

        return  jsonOutput;
    }

}
