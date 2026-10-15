package Week9.Assignment;

import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + 10.0 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + 15.0 * weight;
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return (40.0 + 10.0 * weight) + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * declaredValue;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();

            Parcel parcel = null;
            if (type.equalsIgnoreCase("STANDARD")) {
                parcel = new StandardParcel(weight, declaredValue);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                parcel = new ExpressParcel(weight, declaredValue);
            } else if (type.equalsIgnoreCase("FRAGILE")) {
                parcel = new FragileParcel(weight, declaredValue);
            }

            if (parcel != null) {
                double charge = parcel.calculateCharge();
                double insurance = 0.0;
                if (parcel instanceof Insurable) {
                    insurance = ((Insurable) parcel).calculateInsurance();
                }
                double total = charge + insurance;
                grandTotal += total;

                System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", type.toUpperCase(), charge, insurance, total);
            }
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        scanner.close();
    }
}