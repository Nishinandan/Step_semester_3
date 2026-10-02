package Week8;

import java.time.LocalDate;
import java.util.Scanner;

interface LibraryItem {
    int getBorrowDays();
    String getTitle();
}

class Book implements LibraryItem {
    private String title;

    Book(String title) {
        this.title = title;
    }

    public int getBorrowDays() {
        return 14;
    }

    public String getTitle() {
        return title;
    }
}

class DVD implements LibraryItem {
    private String title;

    DVD(String title) {
        this.title = title;
    }

    public int getBorrowDays() {
        return 7;
    }

    public String getTitle() {
        return title;
    }
}

class Magazine implements LibraryItem {
    private String title;

    Magazine(String title) {
        this.title = title;
    }

    public int getBorrowDays() {
        return 3;
    }

    public String getTitle() {
        return title;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String input = sc.nextLine();

            int space = input.indexOf(" ");
            String type = input.substring(0, space);
            String title = input.substring(space + 1);

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            LocalDate dueDate = currentDate.plusDays(item.getBorrowDays());

            System.out.println(item.getTitle() + ": " + dueDate);
        }

        sc.close();
    }
}