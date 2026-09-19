package Week1.Assignments;

public class MovieReviewWordLengthProfiler {

    public static void classifyWordLengths(String review) {

        // Split the review into individual words
        String[] words = review.split(" ");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        // Check each word
        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            int wordLength = word.length();

            if (wordLength >= 1 && wordLength <= 4) {

                shortWords++;

            } else if (wordLength >= 5 && wordLength <= 8) {

                mediumWords++;

            } else {

                longWords++;
            }
        }

        System.out.println(
                "Short: " + shortWords
                        + " | Medium: " + mediumWords
                        + " | Long: " + longWords
        );
    }

    public static void main(String[] args) {

        String review =
                "This movie was absolutely fantastic and thrilling";

        classifyWordLengths(review);
    }
}