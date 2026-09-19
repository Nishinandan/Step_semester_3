package Week2;

import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        // Check whether phone number has exactly 10 digits
        boolean valid = true;

        if (phone.length() != 10) {
            valid = false;
        } else {

            for (int i = 0; i < phone.length(); i++) {

                char ch = phone.charAt(i);

                if (ch < '0' || ch > '9') {
                    valid = false;
                    break;
                }
            }
        }

        if (valid == false) {

            System.out.println("Invalid phone number");

        } else {

            // Get the last 4 digits
            String lastFourDigits = phone.substring(6);

            // Create masked number
            StringBuilder maskedNumber = new StringBuilder("XXXXXX");

            // Insert "-" after the mask
            maskedNumber.insert(6, "-");

            // Add last 4 digits
            maskedNumber.append(lastFourDigits);

            System.out.println(maskedNumber);
        }

        sc.close();
    }
}