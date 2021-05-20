package com.example.project;

import java.util.ArrayList;
import java.util.List;

public class Question {
    String name;
    Integer url;

    Question(String name, Integer url) {
        this.name = name;
        this.url = url;
    }

    public Integer getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}
