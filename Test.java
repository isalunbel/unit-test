package org.example;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Test {


    @org.junit.jupiter.api.Test
    public void testConcat_validArgument_success() {
        final String original = "new_data.json";
        final String argument = Main.readString(original);
        final String expected = "new_data.json[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25}," +
                "{\"id\":2,\"firstName\":\"Inav\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";
        final String result = original.concat(argument);

        assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    public void testJsonToList() {
        String original = "new_data.json";
        List<Employee> result = Main.jsonToList(original);
        assertNotNull(result);
    }

}



