package Week8.Assignments;

import java.util.Scanner;

interface Customer {
    double calculateAmount(double amount);
    String getType();
}

class Student implements Customer {
    public double calculateAmount(double amount) {
        return amount * 0.90;
    }

    public String getType() {
        return "STUDENT";
    }
}

class Staff implements Customer {
    public double calculateAmount(double amount) {
        return amount * 0.95;
    }

    public String getType() {
        return "STAFF";
    }
}

class Guest implements Customer {
    public double calculateAmount(double amount) {
        return amount + 10;
    }

    public String getType() {
        return "GUEST";
    }
}

public class CanteenBillingCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            if (type.equals("STUDENT")) {
                customer = new Student();
            } else if (type.equals("STAFF")) {
                customer = new Staff();
            } else {
                customer = new Guest();
            }

            double finalAmount = customer.calculateAmount(amount);

            System.out.printf("%s: %.2f%n", customer.getType(), finalAmount);

            total = total + finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}