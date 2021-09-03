package com.interview.example.interviewprep.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GreetingTest {
    @Autowired
    Greeting greeting;

    @BeforeEach
    public void init() {
        greeting = new Greeting(1, "test");
    }

    @Test
    public void getIdRetCorrectValue() {
        assertEquals(1, greeting.getId());

        greeting.setId(2);
        assertEquals(2, greeting.getId());
    }

    @Test
    public void getContentRetCorrectValue() {
        assertEquals("test", greeting.getContent());

        //System.out.print("Test");

        greeting.setContent("Updated Name");
        assertEquals("Updated Name", greeting.getContent());
    }
}
