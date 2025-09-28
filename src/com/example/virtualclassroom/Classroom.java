package com.example.virtualclassroom;

import java.util.*;

public class Classroom {
    private final String name;
    private final List<Student> students = new ArrayList<>();
    private final Map<String, Assignment> assignments = new HashMap<>();

    public Classroom(String name) {
        this.name = name;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Map<String, Assignment> getAssignments() {
        return assignments;
    }

    public String getName() {
        return name;
    }
}
