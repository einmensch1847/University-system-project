package model;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private List<Course> courses;

    public CourseManager() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void editCourse(int courseId, Course updatedCourse) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == courseId) {
                courses.set(i, updatedCourse);
                break;
            }
        }
    }

    public void deleteCourse(int courseId) {
        courses.removeIf(course -> course.getId() == courseId);
    }

    public List<Course> getCourses() {
        return courses;
    }
}