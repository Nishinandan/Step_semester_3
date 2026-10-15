package Week9.Assignment;

import java.util.Scanner;

interface NightServiceable {
    double applyNightSurcharge(double baseFare);
}

abstract class CabTrip {
    protected double km;
    protected String time;

    public CabTrip(double km, String time) {
        this.km = km;
        this.time = time;
    }

    public abstract double calculateFare() throws IllegalArgumentException;
}

class MiniCab extends CabTrip {
    public MiniCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double calculateFare() {
        if (time.equalsIgnoreCase("NIGHT")) {
            throw new IllegalArgumentException("night service not available");
        }
        double fare = km * 10.0;
        return Math.max(fare, 100.0);
    }
}

class SedanCab extends CabTrip implements NightServiceable {
    public SedanCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double calculateFare() {
        double fare = km * 14.0;
        fare = Math.max(fare, 100.0);
        if (time.equalsIgnoreCase("NIGHT")) {
            fare = applyNightSurcharge(fare);
        }
        return fare;
    }

    @Override
    public double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }
}

class SuvCab extends CabTrip implements NightServiceable {
    public SuvCab(double km, String time) {
        super(km, time);
    }

    @Override
    public double calculateFare() {
        double fare = km * 18.0;
        fare = Math.max(fare, 100.0);
        if (time.equalsIgnoreCase("NIGHT")) {
            fare = applyNightSurcharge(fare);
        }
        return fare;
    }

    @Override
    public double applyNightSurcharge(double baseFare) {
        return baseFare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            CabTrip trip = null;
            if (cabType.equalsIgnoreCase("MINI")) {
                trip = new MiniCab(km, time);
            } else if (cabType.equalsIgnoreCase("SEDAN")) {
                trip = new SedanCab(km, time);
            } else if (cabType.equalsIgnoreCase("SUV")) {
                trip = new SuvCab(km, time);
            }

            try {
                if (trip != null) {
                    double fare = trip.calculateFare();
                    total += fare;
                    System.out.printf("%s: %.2f\n", cabType.toUpperCase(), fare);
                }
            } catch (IllegalArgumentException e) {
                System.out.printf("%s: %s\n", cabType.toUpperCase(), e.getMessage());
            }
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}