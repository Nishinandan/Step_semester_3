package Week2.Assignments;

import java.util.Scanner;

public class WordReversalEncoder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder reversedWord = new StringBuilder();

            for (int j = words[i].length() - 1; j >= 0; j--) {

                reversedWord.append(words[i].charAt(j));
            }

            result.append(reversedWord);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        System.out.println("Reversed sentence: " + result);

        sc.close();
    }
}