package com.task1.json;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the JsonService.java class.
 */
class JsonServiceTest {
    static JsonService service = new JsonService();

    /**
     * Tests whether the JsonService serializes Objects correct.
     */
    @Test
    public void serializesCorrect(){
        // Testing whether a list is serialized correctly.
        List testList = List.of("22",2,1.0,"e");
        String expected = "[\"22\",2,1.0,\"e\"]";
        String serialized = service.serialize(testList);

        assertEquals(expected,serialized,"JsonService doesn't serialize lists correctly!");
    }

}