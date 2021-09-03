package com.interview.example.interviewprep.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Data
public class Greeting {
    private long id;
    private String content;

    public Greeting(long id, String content) {
    this.id = id;
    this.content = content;
    }
}
