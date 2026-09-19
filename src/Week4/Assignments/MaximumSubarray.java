package Week4.Assignments;

import java.util.Scanner;

public class MaximumSubarray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int currentSum = nums[0];
        int maximumSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Decide whether to extend or start fresh
            if (currentSum + nums[i] > nums[i]) {
                currentSum = currentSum + nums[i];
            } else {
                currentSum = nums[i];
            }

            // Update maximum sum
            if (currentSum > maximumSum) {
                maximumSum = currentSum;
            }
        }

        System.out.println("Maximum Subarray Sum: " + maximumSum);

        sc.close();
    }
}