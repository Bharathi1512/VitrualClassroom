package com.example.virtualclassroom;

import java.util.*;

public class Assignment {
    private final String title;
    private final String description;
    private final String dueDate;
    private final Map<String, Submission> submissions = new HashMap<>();

    public Assignment(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDueDate() { return dueDate; }
    public Map<String, Submission> getSubmissions() { return submissions; }
}
