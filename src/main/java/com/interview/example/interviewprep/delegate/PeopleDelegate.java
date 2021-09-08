package com.interview.example.interviewprep.delegate;

import java.util.*;

import com.interview.example.interviewprep.dto.People;
import com.interview.example.interviewprep.service.PeopleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeopleDelegate {
    PeopleService peopleService;

    @Autowired
    public PeopleDelegate(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    public List<People> getPeople(List<People> peopleList) {
        return peopleService.peopleService(peopleList);
        
    }

    public List<People> addPeople(List<People> peopleList, People person) {
        People newPerson = new People();
        newPerson.setName(person.getName());
        newPerson.setAge(person.getAge());
        peopleList.add(newPerson);
        return peopleList;
    }
}
