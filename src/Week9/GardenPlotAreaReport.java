
package Week9;

import java.util.Scanner;
import java.util.Locale;

abstract class Plot {

    String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();

    abstract String getShape();
}

class CirclePlot extends Plot {

    double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    String getShape() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {

    double length;
    double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }

    String getShape() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {

    double base;
    double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }

    String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Plot[] plots = new Plot[n];

        double totalArea = 0;

        for (int i = 0; i < n; i++) {

            String shape = sc.next();
            String owner = sc.next();

            if (shape.equals("CIRCLE")) {

                double radius = sc.nextDouble();

                plots[i] = new CirclePlot(owner, radius);

            } else if (shape.equals("RECTANGLE")) {

                double length = sc.nextDouble();
                double width = sc.nextDouble();

                plots[i] = new RectanglePlot(owner, length, width);

            } else if (shape.equals("TRIANGLE")) {

                double base = sc.nextDouble();
                double height = sc.nextDouble();

                plots[i] = new TrianglePlot(owner, base, height);
            }
        }

        for (int i = 0; i < n; i++) {

            double area = plots[i].calculateArea();

            System.out.printf(
                    Locale.US,
                    "%s (%s): %.2f%n",
                    plots[i].owner,
                    plots[i].getShape(),
                    area
            );

            totalArea = totalArea + area;
        }

        System.out.printf(
                Locale.US,
                "Total Area: %.2f%n",
                totalArea
        );

        sc.close();
    }
}
