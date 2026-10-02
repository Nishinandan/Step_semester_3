package Week8;

import java.util.Scanner;

interface Transport {
    double calculateFare(double distance, double peakHourFactor);
    String getType();
}

class Bus implements Transport {

    public double calculateFare(double distance, double peakHourFactor) {
        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }

    public String getType() {
        return "BUS";
    }
}

class Train implements Transport {

    public double calculateFare(double distance, double peakHourFactor) {
        return 3 + (0.15 * distance);
    }

    public String getType() {
        return "TRAIN";
    }
}

class Metro implements Transport {

    public double calculateFare(double distance, double peakHourFactor) {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    public String getType() {
        return "METRO";
    }
}

public class PublicTransport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();
            double peakHourFactor = 1.0;

            if (type.equals("METRO")) {
                peakHourFactor = sc.nextDouble();
            }

            Transport transport;

            if (type.equals("BUS")) {
                transport = new Bus();
            } else if (type.equals("TRAIN")) {
                transport = new Train();
            } else {
                transport = new Metro();
            }

            double fare = transport.calculateFare(distance, peakHourFactor);

            System.out.printf("%s: %.2f%n", transport.getType(), fare);

            total = total + fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}