package com.example.virtualclassroom;

import java.util.*;
import java.util.logging.Logger;

public class VirtualClassroomService {
    private static final Logger logger = Logger.getLogger(VirtualClassroomService.class.getName());
    private final Map<String, Classroom> classrooms = new HashMap<>();
    private final Map<String, String> studentToClassroom = new HashMap<>();

    public void addClassroom(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Classroom name cannot be empty");
        if (classrooms.containsKey(name)) throw new IllegalStateException("Classroom [" + name + "] already exists.");
        classrooms.put(name, new Classroom(name));
        logger.info("Created classroom: " + name);
        System.out.println("Classroom [" + name + "] has been created.");
    }

    public void removeClassroom(String name) {
        if (!classrooms.containsKey(name)) throw new IllegalStateException("No classroom found with name [" + name + "]");
        classrooms.remove(name);
        logger.info("Removed classroom: " + name);
        System.out.println("Classroom [" + name + "] has been removed.");
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
            return;
        }
        System.out.println("Classrooms:");
        classrooms.keySet().forEach(c -> System.out.println(" - " + c));
    }

    public void addStudent(String id, String className) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Student ID cannot be empty");
        if (!classrooms.containsKey(className)) throw new IllegalStateException("No classroom found with name [" + className + "]");
        if (studentToClassroom.containsKey(id)) throw new IllegalStateException("Student [" + id + "] is already enrolled in another classroom.");
        classrooms.get(className).addStudent(new Student(id));
        studentToClassroom.put(id, className);
        logger.info("Student " + id + " enrolled in " + className);
        System.out.println("Student [" + id + "] has been enrolled in [" + className + "].");
    }

    public void listStudents(String className) {
        Classroom c = classrooms.get(className);
        if (c == null) throw new IllegalStateException("No classroom found with name [" + className + "]");
        if (c.getStudents().isEmpty()) {
            System.out.println("No students enrolled in [" + className + "].");
            return;
        }
        System.out.println("Students in [" + className + "]:");
        c.getStudents().forEach(s -> System.out.println(" - " + s.getId()));
    }

    public void scheduleAssignment(String className, String title, String description, String dueDate) {
        Classroom c = classrooms.get(className);
        if (c == null) throw new IllegalStateException("No classroom found with name [" + className + "]");
        if (c.getAssignments().containsKey(title)) throw new IllegalStateException("Assignment [" + title + "] already exists for [" + className + "].");
        Assignment a = new Assignment(title, description, dueDate);
        c.getAssignments().put(title, a);
        logger.info("Assignment " + title + " scheduled in " + className);
        System.out.println("Assignment for [" + className + "] has been scheduled.");
    }

    public void listAssignments(String className) {
        Classroom c = classrooms.get(className);
        if (c == null) throw new IllegalStateException("No classroom found with name [" + className + "]");
        if (c.getAssignments().isEmpty()) {
            System.out.println("No assignments in [" + className + "].");
            return;
        }
        System.out.println("Assignments for [" + className + "]:");
        c.getAssignments().values().forEach(a ->
            System.out.println(" - " + a.getTitle() + " (Due: " + a.getDueDate() + ")")
        );
    }

    public void submitAssignment(String studentId, String className, String title, String content) {
        Classroom c = classrooms.get(className);
        if (c == null) throw new IllegalStateException("No classroom found with name [" + className + "]");
        Assignment a = c.getAssignments().get(title);
        if (a == null) throw new IllegalStateException("No assignment [" + title + "] in [" + className + "]");
        if (a.getSubmissions().containsKey(studentId)) throw new IllegalStateException("Student [" + studentId + "] has already submitted [" + title + "] in [" + className + "].");
        a.getSubmissions().put(studentId, new Submission(studentId, content));
        logger.info("Submission recorded for " + studentId + " in " + className + " assignment " + title);
        System.out.println("Assignment submitted by Student [" + studentId + "] in [" + className + "].");
    }

    public void help() {
        System.out.println("Available commands:");
        System.out.println(" add_classroom <name>");
        System.out.println(" remove_classroom <name>");
        System.out.println(" list_classrooms");
        System.out.println(" add_student <id> <class>");
        System.out.println(" list_students <class>");
        System.out.println(" schedule_assignment <class> <title> <desc> <due>");
        System.out.println(" list_assignments <class>");
        System.out.println(" submit_assignment <studentId> <class> <title> <content>");
        System.out.println(" help");
        System.out.println(" exit");
    }
}
