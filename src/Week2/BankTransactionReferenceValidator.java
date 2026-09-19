package Week2;

import java.util.Scanner;

public class BankTransactionReferenceValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String reference = sc.nextLine();

        // Remove spaces from beginning and end
        reference = reference.trim();

        // Normalize first 3 characters to uppercase
        if (reference.length() >= 3) {

            String bankCode = reference.substring(0, 3);
            String remainingPart = reference.substring(3);

            bankCode = bankCode.toUpperCase();

            reference = bankCode + remainingPart;
        }

        // Step 1: Check length
        if (reference.length() != 14) {

            System.out.println("Invalid: wrong length");

        } else {

            // Step 2: Check first 3 characters are letters
            boolean validBankCode = true;

            for (int i = 0; i < 3; i++) {

                char ch = reference.charAt(i);

                if (!Character.isLetter(ch)) {
                    validBankCode = false;
                    break;
                }
            }

            if (validBankCode == false) {

                System.out.println("Invalid: bank code must be 3 letters");

            } else {

                // Step 3: Check remaining 11 characters are digits
                boolean validBody = true;

                for (int i = 3; i < reference.length(); i++) {

                    char ch = reference.charAt(i);

                    if (!Character.isDigit(ch)) {
                        validBody = false;
                        break;
                    }
                }

                if (validBody == false) {

                    System.out.println("Invalid: body must contain only digits");

                } else {

                    // Extract required parts
                    String bankCode = reference.substring(0, 3);
                    String date = reference.substring(3, 9);
                    String sequence = reference.substring(9, 14);

                    // Format date from ddMMyy to dd/MM/yy
                    String formattedDate =
                            date.substring(0, 2) + "/"
                                    + date.substring(2, 4) + "/"
                                    + date.substring(4, 6);

                    // Build final display
                    StringBuilder result = new StringBuilder();

                    result.append("[");
                    result.append(bankCode);
                    result.append("] DATE: ");
                    result.append(formattedDate);
                    result.append(" | SEQ: ");
                    result.append(sequence);

                    System.out.println(result);
                }
            }
        }

        sc.close();
    }
}