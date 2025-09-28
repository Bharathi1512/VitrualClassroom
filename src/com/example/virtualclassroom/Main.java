package com.example.virtualclassroom;

import java.util.Scanner;
import java.util.logging.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Configure logging: only warnings and errors will be shown
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.WARNING);

        VirtualClassroomService service = new VirtualClassroomService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Virtual Classroom Manager! Type 'help' for commands.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input == null || input.trim().isEmpty()) continue;
            if (input.equalsIgnoreCase("exit")) break;
            try {
                CommandFactory.execute(service, input.trim());
            } catch (Exception e) {
                logger.warning("Error: " + e.getMessage());
                //System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
