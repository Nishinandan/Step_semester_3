package Week4.Assignments;

import java.util.Scanner;

public class ContainsDuplicate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        boolean duplicateFound = false;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {

                    duplicateFound = true;
                    break;
                }
            }

            if (duplicateFound) {
                break;
            }
        }

        System.out.println("Contains Duplicate: " + duplicateFound);

        sc.close();
    }
}