package view;

import model.CourseSelectionManager;
import java.util.Scanner;

public class CourseSelectionView {
    private CourseSelectionManager courseSelectionManager;
    private Scanner scanner;

    public CourseSelectionView(CourseSelectionManager courseSelectionManager) {
        this.courseSelectionManager = courseSelectionManager;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Course Selection System:");
            System.out.println("1. Select Course");
            System.out.println("2. View Selected Courses");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    selectCourse();
                    break;
                case 2:
                    viewSelectedCourses();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void selectCourse() {
        System.out.println("Enter your student ID:");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter course ID to select:");
        int courseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        courseSelectionManager.selectCourse(studentId, courseId);
        System.out.println("Course selected successfully.");
    }

    private void viewSelectedCourses() {
        System.out.println("Enter your student ID:");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Selected Courses:");
        for (int courseId : courseSelectionManager.getStudentSelectedCourses(studentId)) {
            System.out.println("Course ID: " + courseId);
        }
    }
}