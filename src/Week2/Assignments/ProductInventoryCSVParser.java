package Week2.Assignments;

import java.util.Scanner;

public class ProductInventoryCSVParser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter inventory record: ");
        String record = sc.nextLine();

        String[] details = record.split(",");

        if (details.length != 3) {

            System.out.println("Invalid Record");

        } else {

            String productName = details[0];
            String sku = details[1];
            String quantity = details[2];

            System.out.println(
                    "Product: " + productName
                            + " | SKU: " + sku
                            + " | Qty: " + quantity
            );
        }

        sc.close();
    }
}