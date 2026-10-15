package Week9.Assignment;

import java.util.Scanner;

interface Transportable {
    double getTransportFee();
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateFee();
}

class DayScholar extends Student implements Transportable {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateFee() {
        return 40000.0 + getTransportFee();
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateFee() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements Transportable {
    public ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    public double calculateFee() {
        return 20000.0 + getTransportFee();
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            Student student = null;
            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equalsIgnoreCase("HOSTELLER")) {
                student = new Hosteller(name);
            } else if (type.equalsIgnoreCase("SCHOLAR")) {
                student = new ScholarshipStudent(name);
            }

            if (student != null) {
                double fee = student.calculateFee();
                totalCollected += fee;
                System.out.printf("%s: %.2f\n", student.name, fee);
            }
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
        scanner.close();
    }
}