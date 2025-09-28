package com.example.virtualclassroom;

public class Submission {
    private final String studentId;
    private final String content;
    public Submission(String studentId, String content) {
        this.studentId = studentId;
        this.content = content;
    }
    public String getStudentId() { return studentId; }
    public String getContent() { return content; }
}
