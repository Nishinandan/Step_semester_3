package Week4.Assignments;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter stock prices:");

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int lowestPrice = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }

            int currentProfit = prices[i] - lowestPrice;

            if (currentProfit > maximumProfit) {
                maximumProfit = currentProfit;
            }
        }

        System.out.println("Maximum Profit: " + maximumProfit);

        sc.close();
    }
}