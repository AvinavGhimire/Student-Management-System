public class GradeService {

    private MarksDAO marksDAO = new MarksDAOImpl();

    public String calculateGrade(double marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else return "F";
    }

    public boolean assignGrade(Marks marks) {
        String grade = calculateGrade(marks.getMarks());
        marks.setGrade(grade);

        Marks existing = marksDAO.getMarks(marks.getStudentId(), marks.getCourseId());

        if (existing == null) {
            return marksDAO.addMarks(marks);
        } else {
            return marksDAO.updateMarks(marks);
        }
    }
}
