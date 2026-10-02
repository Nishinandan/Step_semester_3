package Week8.Assignments;

import java.util.Scanner;

interface Vehicle {
    double calculateCharge(int hours);
    String getType();
}

class Bike implements Vehicle {
    public double calculateCharge(int hours) {
        return hours * 10;
    }

    public String getType() {
        return "BIKE";
    }
}

class Car implements Vehicle {
    public double calculateCharge(int hours) {
        if (hours == 1) {
            return 30;
        }
        return 30 + (hours - 1) * 20;
    }

    public String getType() {
        return "CAR";
    }
}

class Truck implements Vehicle {
    public double calculateCharge(int hours) {
        double charge = hours * 50;

        if (charge < 100) {
            charge = 100;
        }

        return charge;
    }

    public String getType() {
        return "TRUCK";
    }
}

public class CampusParking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle;

            if (type.equals("BIKE")) {
                vehicle = new Bike();
            } else if (type.equals("CAR")) {
                vehicle = new Car();
            } else {
                vehicle = new Truck();
            }

            double charge = vehicle.calculateCharge(hours);

            System.out.printf("%s: %.2f%n", vehicle.getType(), charge);

            total = total + charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}