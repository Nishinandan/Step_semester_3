package Week9.Assignment;

import java.util.Scanner;

interface SaverMode {
    double applySaver(double units);
}

abstract class Appliance {
    protected double hours;
    protected String mode;

    public Appliance(double hours, String mode) {
        this.hours = hours;
        this.mode = mode;
    }

    public abstract double getPowerRating();

    public double calculateUnits() throws IllegalArgumentException {
        if (mode != null && mode.equalsIgnoreCase("SAVER")) {
            throw new IllegalArgumentException("saver mode not supported");
        }
        double power = getPowerRating();
        return (power * hours) / 1000.0;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, String mode) {
        super(hours, mode);
    }

    @Override
    public double getPowerRating() {
        return 150.0;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    public AirConditioner(double hours, String mode) {
        super(hours, mode);
    }

    @Override
    public double getPowerRating() {
        return 1500.0;
    }

    @Override
    public double calculateUnits() {
        double power = getPowerRating();
        double units = (power * hours) / 1000.0;
        if (mode != null && mode.equalsIgnoreCase("SAVER")) {
            units = applySaver(units);
        }
        return units;
    }

    @Override
    public double applySaver(double units) {
        return units * 0.75;
    }
}

class Television extends Appliance {
    public Television(double hours, String mode) {
        super(hours, mode);
    }

    @Override
    public double getPowerRating() {
        return 100.0;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    public WashingMachine(double hours, String mode) {
        super(hours, mode);
    }

    @Override
    public double getPowerRating() {
        return 500.0;
    }

    @Override
    public double calculateUnits() {
        double power = getPowerRating();
        double units = (power * hours) / 1000.0;
        if (mode != null && mode.equalsIgnoreCase("SAVER")) {
            units = applySaver(units);
        }
        return units;
    }

    @Override
    public double applySaver(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String applianceType = scanner.next();
            double hours = scanner.nextDouble();
            String mode = null;
            if (scanner.hasNext("(?i)SAVER")) {
                mode = scanner.next();
            }

            Appliance appliance = null;
            if (applianceType.equalsIgnoreCase("FRIDGE")) {
                appliance = new Fridge(hours, mode);
            } else if (applianceType.equalsIgnoreCase("AC")) {
                appliance = new AirConditioner(hours, mode);
            } else if (applianceType.equalsIgnoreCase("TV")) {
                appliance = new Television(hours, mode);
            } else if (applianceType.equalsIgnoreCase("WASHER")) {
                appliance = new WashingMachine(hours, mode);
            }

            try {
                if (appliance != null) {
                    double units = appliance.calculateUnits();
                    double cost = units * 8.0;
                    totalCost += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f\n", applianceType.toUpperCase(), units, cost);
                }
            } catch (IllegalArgumentException e) {
                System.out.printf("%s: %s\n", applianceType.toUpperCase(), e.getMessage());
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
        scanner.close();
    }
}
