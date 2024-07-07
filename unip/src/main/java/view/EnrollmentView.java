package view;

import model.EnrollmentManager;

import java.util.Scanner;

public class EnrollmentView {
    private EnrollmentManager enrollmentManager;
    private Scanner scanner;

    public EnrollmentView(EnrollmentManager enrollmentManager) {
        this.enrollmentManager = enrollmentManager;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Enrollment System:");
            System.out.println("1. Enroll in a Course");
            System.out.println("2. View Enrolled Courses");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    enrollInCourse();
                    break;
                case 2:
                    viewEnrolledCourses();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void enrollInCourse() {
        System.out.println("Enter your student ID:");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter course ID to enroll:");
        int courseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        enrollmentManager.enrollStudent(studentId, courseId);
        System.out.println("Enrolled in course successfully.");
    }

    private void viewEnrolledCourses() {
        System.out.println("Enter your student ID:");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enrolled Courses:");
        for (int courseId : enrollmentManager.getStudentCourses(studentId)) {
            System.out.println("Course ID: " + courseId);
        }
    }
}