package model;

import java.util.ArrayList;
import java.util.List;

public class CourseSelectionManager {
    private List<CourseSelection> courseSelections;

    public CourseSelectionManager() {
        this.courseSelections = new ArrayList<>();
    }

    public void selectCourse(int studentId, int courseId) {
        CourseSelection selection = new CourseSelection(studentId, courseId);
        courseSelections.add(selection);
    }

    public List<CourseSelection> getCourseSelections() {
        return courseSelections;
    }

    public List<Integer> getStudentSelectedCourses(int studentId) {
        List<Integer> selectedCourses = new ArrayList<>();
        for (CourseSelection selection : courseSelections) {
            if (selection.getStudentId() == studentId) {
                selectedCourses.add(selection.getCourseId());
            }
        }
        return selectedCourses;
    }
}