package attendance;

import java.time.LocalDate;

public class AttendanceService {

    private AttendanceDAO attendanceDAO = new AttendanceDAO();

    public boolean markPresent(int studentId, int courseId, LocalDate date) {
        Attendance attendance = new Attendance(
                attendanceDAO.getNextAttendanceId(),
                studentId,
                courseId,
                date,
                "PRESENT"
        );
        return attendanceDAO.markAttendance(attendance);
    }

    public boolean markAbsent(int studentId, int courseId, LocalDate date) {
        Attendance attendance = new Attendance(
                attendanceDAO.getNextAttendanceId(),
                studentId,
                courseId,
                date,
                "ABSENT"
        );
        return attendanceDAO.markAttendance(attendance);
    }
}
