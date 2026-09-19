package Week1;

import java.util.Scanner;

public class PalindromeChecker {

    // Method 1: Iterative
    public static boolean isPalindromeIterative(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {

            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }


    // Method 2: Recursive
    public static boolean isPalindromeRecursive(String text) {

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        String smallerText = text.substring(1, text.length() - 1);

        return isPalindromeRecursive(smallerText);
    }


    // Method 3: Array Reversal
    public static boolean isPalindromeArrayReversal(String text) {

        char[] array = text.toCharArray();

        int start = 0;
        int end = array.length - 1;

        while (start < end) {

            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }

        String reversed = new String(array);

        return text.equals(reversed);
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String text = sc.nextLine();

        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        if (iterative == true) {
            System.out.println("Iterative: Palindrome");
        } else {
            System.out.println("Iterative: Not Palindrome");
        }

        if (recursive == true) {
            System.out.println("Recursive: Palindrome");
        } else {
            System.out.println("Recursive: Not Palindrome");
        }

        if (arrayReversal == true) {
            System.out.println("Array Reversal: Palindrome");
        } else {
            System.out.println("Array Reversal: Not Palindrome");
        }

        sc.close();
    }
}