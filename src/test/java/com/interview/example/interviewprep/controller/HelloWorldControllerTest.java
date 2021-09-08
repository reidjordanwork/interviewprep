package com.interview.example.interviewprep.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import com.interview.example.interviewprep.delegate.PeopleDelegate;
import com.interview.example.interviewprep.dto.People;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HelloWorldControllerTest {
    @Mock
    private PeopleDelegate peopleDelegate;

    private HelloWorldController helloWorldController;

    @BeforeEach
    public void init() {
        helloWorldController = new HelloWorldController(peopleDelegate);
    }

    @Test
    public void getPeopleTest() {
        People temp = new People();
        temp.setName("Reid");
        temp.setAge(24);

        List<People> peopleList = new ArrayList<>();
        peopleList.add(temp);

        Mockito.when(peopleDelegate.getPeople(Mockito.anyList())).thenReturn(peopleList);
        List<People> controllerReturn = helloWorldController.getPeople();
        assertEquals(controllerReturn.get(0).getName(), peopleList.get(0).getName());
    }
}
