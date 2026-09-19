package Week1;

import java.util.Scanner;

public class BMICalculator {

    // Method to find BMI status
    public static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        }
        else if (bmi < 25) {
            return "Normal";
        }
        else if (bmi < 30) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }


    // Method to print the wellness report
    public static void printWellnessReport(double[] heights, double[] weights) {

        System.out.println();
        System.out.println("========== WELLNESS REPORT ==========");

        System.out.println("Person\tHeight(m)\tWeight(kg)\tBMI\tStatus");

        for (int i = 0; i < heights.length; i++) {

            double height = heights[i];
            double weight = weights[i];

            double bmi = weight / (height * height);

            String status = getBmiStatus(bmi);

            System.out.printf(
                    "%d\t%.2f\t\t%.2f\t\t%.2f\t%s%n",
                    (i + 1),
                    height,
                    weight,
                    bmi,
                    status
            );
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        double[] heights = new double[n];
        double[] weights = new double[n];

        // Taking input
        for (int i = 0; i < n; i++) {

            System.out.println();
            System.out.println("Person " + (i + 1));

            System.out.print("Enter height in meters: ");
            heights[i] = sc.nextDouble();

            System.out.print("Enter weight in kg: ");
            weights[i] = sc.nextDouble();
        }

        // Print report
        printWellnessReport(heights, weights);

        sc.close();
    }
}