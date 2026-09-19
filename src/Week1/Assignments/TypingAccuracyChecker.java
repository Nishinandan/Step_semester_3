package Week1.Assignments;

public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {

        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        for (int i = 0; i < original.length(); i++) {

            char originalCharacter = original.charAt(i);
            char typedCharacter = typed.charAt(i);

            if (originalCharacter == typedCharacter) {

                matchedCharacters++;

            } else {

                if (firstMismatchPosition == -1) {
                    firstMismatchPosition = i + 1;
                }
            }
        }

        double accuracy =
                (matchedCharacters * 100.0) / original.length();

        System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%%",
                matchedCharacters,
                original.length(),
                accuracy
        );

        if (firstMismatchPosition == -1) {

            System.out.println(" | No Mismatches");

        } else {

            char originalWrongCharacter =
                    original.charAt(firstMismatchPosition - 1);

            char typedWrongCharacter =
                    typed.charAt(firstMismatchPosition - 1);

            System.out.println(
                    " | First Mismatch at position "
                            + firstMismatchPosition
                            + " ('"
                            + originalWrongCharacter
                            + "' vs '"
                            + typedWrongCharacter
                            + "')"
            );
        }
    }

    public static void main(String[] args) {

        String original = "hello world";
        String typed = "hello worlt";

        checkTypingAccuracy(original, typed);
    }
}