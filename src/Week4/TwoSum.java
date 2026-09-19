package Week4.Assignments;

import java.util.Scanner;

public class TwoSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        boolean found = false;

        // Check every possible pair
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {

                    System.out.println(
                            "Indices: [" + i + ", " + j + "]"
                    );

                    System.out.println(
                            nums[i] + " + " + nums[j]
                                    + " = " + target
                    );

                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        sc.close();
    }
}