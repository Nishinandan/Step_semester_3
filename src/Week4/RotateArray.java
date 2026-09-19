package Week4.Assignments;

import java.util.Scanner;

public class RotateArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter number of rotations: ");
        int k = sc.nextInt();

        // Reduce k if it is greater than array length
        k = k % nums.length;

        int[] newArray = new int[nums.length];

        // Put every element in its new position
        for (int i = 0; i < nums.length; i++) {

            int newPosition = (i + k) % nums.length;

            newArray[newPosition] = nums[i];
        }

        // Copy new array back into nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }

        System.out.println("Rotated Array:");

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }
}