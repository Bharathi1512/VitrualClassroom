package com.example.virtualclassroom;

public class CommandFactory {
    public static void execute(VirtualClassroomService service, String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];

        switch (command) {
            case "add_classroom":
                service.addClassroom(parts[1]);
                break;
            case "remove_classroom":
                service.removeClassroom(parts[1]);
                break;
            case "list_classrooms":
                service.listClassrooms();
                break;
            case "add_student": {
                String[] args = parts[1].split(" ");
                service.addStudent(args[0], args[1]);
                break;
            }
            case "list_students":
                service.listStudents(parts[1]);
                break;
            case "schedule_assignment": {
                String[] args = parts[1].split(" ", 4);
                service.scheduleAssignment(args[0], args[1], args[2], args[3]);
                break;
            }
            case "list_assignments":
                service.listAssignments(parts[1]);
                break;
            case "submit_assignment": {
                String[] args = parts[1].split(" ", 4);
                service.submitAssignment(args[0], args[1], args[2], args[3]);
                break;
            }
            case "help":
                service.help();
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}
