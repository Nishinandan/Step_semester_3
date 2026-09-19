package Week2.Assignments;

import java.util.Scanner;

public class ATMPinLengthValidator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (pin.length() != 4) {

            System.out.println("Invalid PIN — must be exactly 4 digits.");

        } else {

            System.out.println("PIN length OK.");
        }

        sc.close();
    }
}