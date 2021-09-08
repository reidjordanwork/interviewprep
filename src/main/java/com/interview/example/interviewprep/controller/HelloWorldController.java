package com.interview.example.interviewprep.controller;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import com.interview.example.interviewprep.delegate.PeopleDelegate;
import com.interview.example.interviewprep.dto.Greeting;
import com.interview.example.interviewprep.dto.People;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
  private PeopleDelegate peopleDelegate;

  @Autowired
  public HelloWorldController(PeopleDelegate peopleDelegate) {
    this.peopleDelegate = peopleDelegate;
  }

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();
  private int count = 0;
  private List<People> peopleList = new ArrayList<>();

  @GetMapping("/hello-world")
  @ResponseBody
  public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }

  @GetMapping("/people")
  @ResponseBody
  // @ResponseMapping
  public List<People> getPeople() {
    return peopleDelegate.getPeople(peopleList);
  }

  @PostMapping("/people")
  @ResponseBody
  // @ResponseMapping
  public List<People> addPeople(@RequestBody People person) {
    // return peopleList;
    return peopleDelegate.addPeople(peopleList, person);
  }

  @GetMapping("/increment")
  @ResponseBody
  // @ResponseMapping
  public int increment() {
    count++;
    return count;
  }
}
