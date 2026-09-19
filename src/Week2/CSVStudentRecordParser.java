package Week2;

import java.util.Scanner;

public class CSVStudentRecordParser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record: ");
        String record = sc.nextLine();

        String[] details = record.split(",");

        if (details.length != 3) {

            System.out.println("Invalid Record");

        } else {

            String name = details[0];
            String rollNumber = details[1];
            String department = details[2];

            System.out.println("Name: " + name
                    + " | Roll No: " + rollNumber
                    + " | Dept: " + department);
        }

        sc.close();
    }
}