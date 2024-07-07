package model;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentManager {
    private List<Enrollment> enrollments;

    public EnrollmentManager() {
        this.enrollments = new ArrayList<>();
    }

    public void enrollStudent(int studentId, int courseId) {
        Enrollment enrollment = new Enrollment(studentId, courseId);
        enrollments.add(enrollment);
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public List<Integer> getStudentCourses(int studentId) {
        List<Integer> studentCourses = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId) {
                studentCourses.add(enrollment.getCourseId());
            }
        }
        return studentCourses;
    }
}