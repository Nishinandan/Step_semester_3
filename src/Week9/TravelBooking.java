
package Week9;

import java.util.Scanner;
import java.util.Locale;

abstract class Booking {

    double distance;

    static final double BOOKING_FEE = 50;

    public Booking(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {

    public Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2;
    }
}

class Train extends Booking {

    public Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }
}

class Flight extends Booking {

    public Flight(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + (distance * 4);
    }
}

public class TravelBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++) {

            String mode = sc.next();
            double distance = sc.nextDouble();

            if (mode.equals("BUS")) {
                bookings[i] = new Bus(distance);
            } else if (mode.equals("TRAIN")) {
                bookings[i] = new Train(distance);
            } else if (mode.equals("FLIGHT")) {
                bookings[i] = new Flight(distance);
            }
        }

        for (int i = 0; i < n; i++) {

            double total = bookings[i].calculateTotal();

            System.out.printf(
                    Locale.US, "%s: %.2f%n",
                    getMode(bookings[i]), total
            );
        }

        sc.close();
    }

    static String getMode(Booking booking) {

        if (booking instanceof Bus) {
            return "BUS";
        } else if (booking instanceof Train) {
            return "TRAIN";
        } else {
            return "FLIGHT";
        }
    }
}
