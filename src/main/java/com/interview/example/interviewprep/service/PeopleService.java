package com.interview.example.interviewprep.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.interview.example.interviewprep.dto.People;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    public PeopleService() {

    }
    
    public List<People> peopleService(List<People> peopleList) {
        People newPerson = new People();
        newPerson.setName("Teid");
        newPerson.setAge(24);
        peopleList.add(newPerson);

        //Get from JSON
        JSONParser parser = new JSONParser();
        
        JSONArray a;
        try {
            a = (JSONArray) parser.parse(new FileReader("/Users/reidjordan/Desktop/interviewprep/src/main/java/com/interview/example/interviewprep/data/People.json"));

            for (Object o : a)
            {
                JSONObject person = (JSONObject) o;

                People temp = new People();

                String name = (String) person.get("name");
                System.out.println(name);

                Long age =  (Long) person.get("age");
                int intAge = age.intValue(); 
                System.out.println(intAge);
                temp.setName(name);
                temp.setAge(intAge);
                peopleList.add(temp);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return peopleList;
    }
}
