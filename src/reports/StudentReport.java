package reports;

import java.util.List;

public class StudentReport {

    private int studentId;
    private List<String> courses;
    private List<Double> marks;
    private double attendancePercentage;

    public StudentReport(int studentId, List<String> courses,
                         List<Double> marks, double attendancePercentage) {
        this.studentId = studentId;
        this.courses = courses;
        this.marks = marks;
        this.attendancePercentage = attendancePercentage;
    }

    public int getStudentId() {
        return studentId;
    }

    public List<String> getCourses() {
        return courses;
    }

    public List<Double> getMarks() {
        return marks;
    }

    public double getAttendancePercentage() {
        return attendancePercentage;
    }
}
