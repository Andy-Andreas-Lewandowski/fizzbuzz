package com.task1.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

/**
 * Service class to handle JSON serialization and deserialization.
 *
 * @param <T> Object-Type that shall be parsed from JSON to java objects.
 */
@Service
public class JsonService<T> {
    final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Takes an object and returns a string representing it as a JSON.
     * @param object To serialize as JSON.
     * @return Input object as string in JSON format.
     */
    public String serialize(T object){
        try{
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
