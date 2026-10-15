
package Week9;

import java.util.Scanner;
import java.util.Locale;

abstract class LibraryItem {

    String title;
    int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class Book extends LibraryItem {

    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 2;
    }
}

class DVD extends LibraryItem {

    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        double fine = daysLate * 5;

        if (fine > 50) {
            fine = 50;
        }

        return fine;
    }
}

class Magazine extends LibraryItem {

    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate;
    }
}

public class LibraryLateFineCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LibraryItem[] items = new LibraryItem[n];

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            if (type.equals("BOOK")) {
                items[i] = new Book(title, daysLate);
            } else if (type.equals("DVD")) {
                items[i] = new DVD(title, daysLate);
            } else if (type.equals("MAGAZINE")) {
                items[i] = new Magazine(title, daysLate);
            }
        }

        for (int i = 0; i < n; i++) {

            double fine = items[i].calculateFine();

            System.out.printf(
                    Locale.US, "%s: %.2f%n",
                    items[i].title, fine
            );

            total = total + fine;
        }

        System.out.printf(
                Locale.US, "Total Fines: %.2f%n", total
        );

        sc.close();
    }
}
