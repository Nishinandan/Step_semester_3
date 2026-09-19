package Week6.Assignments;

public class PlacementRecord {

    String studentName;
    double cgpa;
    int codingScore;

    // Constructor
    public PlacementRecord(String studentName, double cgpa, int codingScore) {

        this.studentName = studentName;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // Checks whether student is eligible
    boolean isEligible() {

        if (cgpa >= 7.0 && codingScore >= 60) {
            return true;
        }

        return false;
    }

    // Displays student details
    void displayRecord() {

        System.out.println(
                "Name: " + studentName
                        + ", CGPA: " + cgpa
                        + ", Coding Score: " + codingScore
                        + ", Eligible: " + isEligible()
        );
    }

    public static void main(String[] args) {

        PlacementRecord student1 =
                new PlacementRecord("Ravi", 8.2, 75);

        PlacementRecord student2 =
                new PlacementRecord("Aisha", 7.5, 82);

        PlacementRecord student3 =
                new PlacementRecord("Karan", 6.8, 70);

        student1.displayRecord();
        student2.displayRecord();
        student3.displayRecord();
    }
}