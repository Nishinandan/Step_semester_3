package Week1.Assignments;

public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {

        // Current streak information
        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        // Longest streak information
        char longestColor = signalLog.charAt(0);
        int longestStreak = 1;

        // Start checking from the second character
        for (int i = 1; i < signalLog.length(); i++) {

            char currentCharacter = signalLog.charAt(i);

            // If current character is same as previous character
            if (currentCharacter == signalLog.charAt(i - 1)) {

                currentStreak++;

            } else {

                // New color started
                currentStreak = 1;
                currentColor = currentCharacter;
            }

            // Check if current streak is the longest
            if (currentStreak > longestStreak) {

                longestStreak = currentStreak;
                longestColor = currentColor;
            }
        }

        System.out.println(
                "Longest Streak: '" + longestColor
                        + "' repeated " + longestStreak + " times"
        );
    }

    public static void main(String[] args) {

        String signalLog = "RRGGGYRR";

        System.out.println("Signal Log: " + signalLog);

        findLongestStreak(signalLog);
    }
}