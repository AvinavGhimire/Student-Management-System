import java.sql.*;
import java.util.*;

public class MarksDAOImpl implements MarksDAO {

    @Override
    public boolean addMarks(Marks marks) {
        String sql = "INSERT INTO marks(student_id, course_id, marks, grade) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, marks.getStudentId());
            ps.setInt(2, marks.getCourseId());
            ps.setDouble(3, marks.getMarks());
            ps.setString(4, marks.getGrade());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateMarks(Marks marks) {
        String sql = "UPDATE marks SET marks=?, grade=? WHERE student_id=? AND course_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, marks.getMarks());
            ps.setString(2, marks.getGrade());
            ps.setInt(3, marks.getStudentId());
            ps.setInt(4, marks.getCourseId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Marks getMarks(int studentId, int courseId) {
        String sql = "SELECT * FROM marks WHERE student_id=? AND course_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, courseId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Marks(
                    rs.getInt("marks_id"),
                    rs.getInt("student_id"),
                    rs.getInt("course_id"),
                    rs.getDouble("marks"),
                    rs.getString("grade")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Marks> getMarksByStudent(int studentId) {
        List<Marks> list = new ArrayList<>();
        String sql = "SELECT * FROM marks WHERE student_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Marks(
                    rs.getInt("marks_id"),
                    rs.getInt("student_id"),
                    rs.getInt("course_id"),
                    rs.getDouble("marks"),
                    rs.getString("grade")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
