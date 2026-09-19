package Week4.Assignments;

import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        HashMap<Integer, Integer> prefixFrequency = new HashMap<>();

        // Empty prefix
        prefixFrequency.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSum = currentSum + nums[i];

            int requiredSum = currentSum - k;

            if (prefixFrequency.containsKey(requiredSum)) {

                count = count + prefixFrequency.get(requiredSum);
            }

            if (prefixFrequency.containsKey(currentSum)) {

                int oldCount = prefixFrequency.get(currentSum);

                prefixFrequency.put(currentSum, oldCount + 1);

            } else {

                prefixFrequency.put(currentSum, 1);
            }
        }

        System.out.println("Number of Subarrays: " + count);

        sc.close();
    }
}