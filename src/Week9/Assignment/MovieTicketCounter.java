package Week9.Assignment;

import java.util.Scanner;

abstract class SeatBooking {
    protected static final double CONVENIENCE_FEE = 20.0;
    protected int count;

    public SeatBooking(int count) {
        this.count = count;
    }

    public abstract double calculateAmount();
}

class RegularSeat extends SeatBooking {
    public RegularSeat(int count) {
        super(count);
    }

    @Override
    public double calculateAmount() {
        return (150.0 + CONVENIENCE_FEE) * count;
    }
}

class PremiumSeat extends SeatBooking {
    public PremiumSeat(int count) {
        super(count);
    }

    @Override
    public double calculateAmount() {
        return (250.0 + CONVENIENCE_FEE) * count;
    }
}

class ReclinerSeat extends SeatBooking {
    public ReclinerSeat(int count) {
        super(count);
    }

    @Override
    public double calculateAmount() {
        return (400.0 + CONVENIENCE_FEE) * count;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String seatType = scanner.next();
            int count = scanner.nextInt();
            SeatBooking booking = null;

            if (seatType.equalsIgnoreCase("REGULAR")) {
                booking = new RegularSeat(count);
            } else if (seatType.equalsIgnoreCase("PREMIUM")) {
                booking = new PremiumSeat(count);
            } else if (seatType.equalsIgnoreCase("RECLINER")) {
                booking = new ReclinerSeat(count);
            }

            if (booking != null) {
                double amount = booking.calculateAmount();
                total += amount;
                System.out.printf("%s: %.2f\n", seatType.toUpperCase(), amount);
            }
        }
        System.out.printf("Total: %.2f\n", total);
        scanner.close();
    }
}