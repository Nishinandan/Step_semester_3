package Week4.Assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ThreeSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    String triplet =
                            "[" + nums[i] + ", "
                                    + nums[left] + ", "
                                    + nums[right] + "]";

                    result.add(triplet);

                    left++;
                    right--;

                    // Skip duplicate left values
                    while (left < right &&
                            nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // Skip duplicate right values
                    while (left < right &&
                            nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {

                    // Need a bigger sum
                    left++;

                } else {

                    // Need a smaller sum
                    right--;
                }
            }
        }

        System.out.println("Unique Triplets:");

        if (result.size() == 0) {
            System.out.println("No triplets found");
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        }

        sc.close();
    }
}