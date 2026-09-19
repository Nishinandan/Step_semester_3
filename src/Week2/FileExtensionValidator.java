package Week2;

import java.util.Scanner;

public class FileExtensionValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = sc.nextLine();

        int dotPosition = filename.lastIndexOf('.');

        if (dotPosition == -1) {

            System.out.println("Rejected — invalid file type");

        } else {

            String extension = filename.substring(dotPosition + 1);

            extension = extension.toLowerCase();

            if (extension.equals("pdf")
                    || extension.equals("docx")
                    || extension.equals("zip")) {

                System.out.println("Accepted");

            } else {

                System.out.println("Rejected — invalid file type");
            }
        }

        sc.close();
    }
}