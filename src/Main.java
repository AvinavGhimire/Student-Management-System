public class Main {
    public static void main(String[] args) {

        GradeService gradeService = new GradeService();

        // Example marks
        Marks marks = new Marks(1, 1, 85); 


        boolean result = gradeService.assignGrade(marks);

        if (result) {
            System.out.println("Marks saved successfully!");
        } else {
            System.out.println("Error saving marks.");
        }
    }
}
