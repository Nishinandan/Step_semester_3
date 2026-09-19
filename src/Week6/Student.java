package Week6;

public class Student {

    // Instance fields - different for every student
    String name;
    double attendance;

    // Static fields - shared by all students
    static String collegeName =
            "SRM Institute of Science and Technology";

    static int studentCount = 0;

    // Constructor
    public Student(String name, double attendance) {

        this.name = name;
        this.attendance = attendance;

        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {

        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {

        Student student1 = new Student("Ravi", 85.5);
        Student student2 = new Student("Aisha", 92.0);

        System.out.println("2 Student objects created");
        System.out.println();

        // Calling static method through class name
        Student.printCollegeInfo();
    }
}