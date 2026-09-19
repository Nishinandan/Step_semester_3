package Week2.Assignments;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StopWordFilteredWordFrequency {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter feedback paragraph:");
        String feedback = sc.nextLine();

        // Convert everything to lowercase
        feedback = feedback.toLowerCase();

        // Remove punctuation
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        // Split sentence into words
        String[] words = feedback.split("\\s+");

        // Stop words
        String[] stopWords = {
                "the", "was", "and", "a", "is", "of", "in"
        };

        // HashMap to store word and frequency
        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            boolean isStopWord = false;

            // Check whether word is a stop word
            for (int j = 0; j < stopWords.length; j++) {

                if (word.equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            // Skip stop words
            if (isStopWord) {
                continue;
            }

            // Count the word
            if (frequency.containsKey(word)) {

                int oldCount = frequency.get(word);

                frequency.put(word, oldCount + 1);

            } else {

                frequency.put(word, 1);
            }
        }

        // Convert HashMap entries into a list
        java.util.ArrayList<Map.Entry<String, Integer>> list =
                new java.util.ArrayList<>(frequency.entrySet());

        // Sort according to frequency
        list.sort((entry1, entry2) ->
                entry2.getValue() - entry1.getValue()
        );

        // Print result
        for (Map.Entry<String, Integer> entry : list) {

            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }

        sc.close();
    }
}