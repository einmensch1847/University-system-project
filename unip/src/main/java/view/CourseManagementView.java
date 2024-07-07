package view;

import model.CourseManager;
import model.Course;

import java.util.Scanner;

public class CourseManagementView {
    private CourseManager courseManager;
    private Scanner scanner;

    public CourseManagementView(CourseManager courseManager) {
        this.courseManager = courseManager;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Course Management:");
            System.out.println("1. Add Course");
            System.out.println("2. Edit Course");
            System.out.println("3. Delete Course");
            System.out.println("4. View Courses");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    editCourse();
                    break;
                case 3:
                    deleteCourse();
                    break;
                case 4:
                    viewCourses();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addCourse() {
        System.out.println("Enter course name:");
        String name = scanner.nextLine();
        System.out.println("Enter course description:");
        String description = scanner.nextLine();
        System.out.println("Enter professor ID:");
        int professorId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int id = courseManager.getCourses().size() + 1;
        Course course = new Course(id, name, description, professorId);
        courseManager.addCourse(course);

        System.out.println("Course added successfully.");
    }

    private void editCourse() {
        System.out.println("Enter course ID to edit:");
        int courseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter new course name:");
        String name = scanner.nextLine();
        System.out.println("Enter new course description:");
        String description = scanner.nextLine();
        System.out.println("Enter new professor ID:");
        int professorId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Course updatedCourse = new Course(courseId, name, description, professorId);
        courseManager.editCourse(courseId, updatedCourse);

        System.out.println("Course edited successfully.");
    }

    private void deleteCourse() {
        System.out.println("Enter course ID to delete:");
        int courseId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        courseManager.deleteCourse(courseId);
        System.out.println("Course deleted successfully.");
    }

    private void viewCourses() {
        for (Course course : courseManager.getCourses()) {
            System.out.println("ID: " + course.getId() + ", Name: " + course.getName() +
                    ", Description: " + course.getDescription() + ", Professor ID: " + course.getProfessorId());
        }
    }
}