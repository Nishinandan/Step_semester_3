
package Week9;

import java.util.Scanner;
import java.util.Locale;

abstract class Connection {

    int units;

    public Connection(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Home extends Connection {

    public Home(int units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100) {
            return units * 5;
        } else {
            return (100 * 5) + ((units - 100) * 7);
        }
    }
}

class Shop extends Connection {

    public Shop(int units) {
        super(units);
    }

    double calculateBill() {
        return (units * 8) + 100;
    }
}

class Factory extends Connection {

    public Factory(int units) {
        super(units);
    }

    double calculateBill() {
        double bill = units * 6;

        if (bill < 1000) {
            bill = 1000;
        }

        return bill;
    }
}

public class ElectricityConnectionBilling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Connection[] connections = new Connection[n];

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            if (type.equals("HOME")) {
                connections[i] = new Home(units);
            } else if (type.equals("SHOP")) {
                connections[i] = new Shop(units);
            } else if (type.equals("FACTORY")) {
                connections[i] = new Factory(units);
            }
        }

        for (int i = 0; i < n; i++) {

            double bill = connections[i].calculateBill();

            System.out.printf(
                    Locale.US, "%s: %.2f%n",
                    getType(connections[i]), bill
            );

            total = total + bill;
        }

        System.out.printf(
                Locale.US, "Total: %.2f%n", total
        );

        sc.close();
    }

    static String getType(Connection connection) {

        if (connection instanceof Home) {
            return "HOME";
        } else if (connection instanceof Shop) {
            return "SHOP";
        } else {
            return "FACTORY";
        }
    }
}
