package attendance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    private List<Attendance> attendanceList = new ArrayList<>();
    private int attendanceCounter = 1;

    public boolean markAttendance(Attendance attendance) {
        if (attendanceExists(attendance.getStudentId(),
                attendance.getCourseId(),
                attendance.getDate())) {
            return false;
        }
        attendanceList.add(attendance);
        return true;
    }

    public boolean attendanceExists(int studentId, int courseId, LocalDate date) {
        for (Attendance a : attendanceList) {
            if (a.getStudentId() == studentId &&
                a.getCourseId() == courseId &&
                a.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

    public List<Attendance> getAttendanceByStudent(int studentId) {
        List<Attendance> result = new ArrayList<>();
        for (Attendance a : attendanceList) {
            if (a.getStudentId() == studentId) {
                result.add(a);
            }
        }
        return result;
    }

    public List<Attendance> getAttendanceByCourse(int courseId) {
        List<Attendance> result = new ArrayList<>();
        for (Attendance a : attendanceList) {
            if (a.getCourseId() == courseId) {
                result.add(a);
            }
        }
        return result;
    }

    public double calculateAttendancePercentage(int studentId, int courseId) {
        int total = 0;
        int present = 0;

        for (Attendance a : attendanceList) {
            if (a.getStudentId() == studentId && a.getCourseId() == courseId) {
                total++;
                if (a.getStatus().equalsIgnoreCase("PRESENT")) {
                    present++;
                }
            }
        }

        if (total == 0) return 0;
        return (present * 100.0) / total;
    }

    public int getNextAttendanceId() {
        return attendanceCounter++;
    }
}
