package reports;

import java.util.*;

public class ReportDAO {

    public StudentReport generateStudentReport(int studentId) {
        List<String> courses = Arrays.asList("Math", "Science");
        List<Double> marks = Arrays.asList(75.5, 82.0);
        double attendance = 78.5;

        return new StudentReport(studentId, courses, marks, attendance);
    }

    public Map<String, Double> generateCourseAttendanceReport(int courseId) {
        Map<String, Double> attendanceMap = new HashMap<>();
        attendanceMap.put("Student A", 80.0);
        attendanceMap.put("Student B", 65.5);
        return attendanceMap;
    }

    public List<String> getDefaulterList(double minAttendance) {
        List<String> defaulters = new ArrayList<>();
        if (minAttendance > 70) {
            defaulters.add("Student B");
        }
        return defaulters;
    }
}
