package Week2.Assignments;

import java.util.Scanner;

public class LibraryISBNNormalizerValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN code: ");
        String code = sc.nextLine();

        // Remove leading and trailing spaces
        code = code.trim();

        // Convert only first 3 characters to uppercase
        if (code.length() >= 3) {

            String publisherCode = code.substring(0, 3);
            String remainingPart = code.substring(3);

            publisherCode = publisherCode.toUpperCase();

            code = publisherCode + remainingPart;
        }

        // Step 1: Check length
        if (code.length() != 13) {

            System.out.println("Invalid: wrong length");

        } else {

            // Step 2: Check first 3 characters are letters
            boolean validPublisher = true;

            for (int i = 0; i < 3; i++) {

                char ch = code.charAt(i);

                if (!Character.isLetter(ch)) {
                    validPublisher = false;
                    break;
                }
            }

            if (validPublisher == false) {

                System.out.println(
                        "Invalid: publisher code must be 3 letters"
                );

            } else {

                // Step 3: Check remaining 10 characters are digits
                boolean validBody = true;

                for (int i = 3; i < code.length(); i++) {

                    char ch = code.charAt(i);

                    if (!Character.isDigit(ch)) {
                        validBody = false;
                        break;
                    }
                }

                if (validBody == false) {

                    System.out.println(
                            "Invalid: body must contain only digits"
                    );

                } else {

                    // Extract parts
                    String publisherCode = code.substring(0, 3);
                    String year = code.substring(3, 7);
                    String catalog = code.substring(7, 13);

                    // Build final output
                    StringBuilder result = new StringBuilder();

                    result.append("[");
                    result.append(publisherCode);
                    result.append("] YEAR: ");
                    result.append(year);
                    result.append(" | CATALOG: ");
                    result.append(catalog);

                    System.out.println(result);
                }
            }
        }

        sc.close();
    }
}