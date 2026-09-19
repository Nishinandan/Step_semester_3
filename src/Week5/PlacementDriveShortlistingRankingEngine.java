package Week5;

import java.util.Arrays;

public class PlacementDriveShortlistingRankingEngine
        implements Comparable<PlacementDriveShortlistingRankingEngine> {

    private String name;
    private double cgpa;
    private int codingScore;

    // Constructor
    public PlacementDriveShortlistingRankingEngine(
            String name, double cgpa, int codingScore) {

        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // CGPA-only eligibility check
    static boolean isEligible(double cgpa) {

        // CGPA 7.0 or above is directly eligible
        return cgpa >= 7.0;
    }

    // CGPA + coding score eligibility check
    static boolean isEligible(double cgpa, int codingScore) {

        // Borderline CGPA between 6.5 and 6.99
        // can qualify with coding score 60 or above
        return cgpa >= 6.5 && cgpa < 7.0 && codingScore >= 60;
    }

    // Composite score
    private double getCompositeScore() {

        return (cgpa * 10) + codingScore;
    }

    // Comparable implementation
    @Override
    public int compareTo(
            PlacementDriveShortlistingRankingEngine other) {

        // Higher composite score should come first
        return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
        );
    }

    // Shortlist and rank candidates
    static String shortlistAndRank(
            PlacementDriveShortlistingRankingEngine[] candidates) {

        PlacementDriveShortlistingRankingEngine[] shortlisted =
                new PlacementDriveShortlistingRankingEngine[candidates.length];

        int count = 0;

        for (int i = 0; i < candidates.length; i++) {

            if (isEligible(candidates[i].cgpa) ||
                    isEligible(
                            candidates[i].cgpa,
                            candidates[i].codingScore)) {

                shortlisted[count] = candidates[i];
                count++;
            }
        }

        // Create an array containing only shortlisted candidates
        PlacementDriveShortlistingRankingEngine[] finalList =
                new PlacementDriveShortlistingRankingEngine[count];

        for (int i = 0; i < count; i++) {
            finalList[i] = shortlisted[i];
        }

        // Java's built-in sorting uses compareTo()
        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result = result
                    + (i + 1)
                    + ". "
                    + finalList[i].name
                    + " ("
                    + finalList[i].getCompositeScore()
                    + ")";

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        PlacementDriveShortlistingRankingEngine[] candidates = {

                new PlacementDriveShortlistingRankingEngine(
                        "Aisha", 8.2, 40),

                new PlacementDriveShortlistingRankingEngine(
                        "Rohit", 6.8, 65),

                new PlacementDriveShortlistingRankingEngine(
                        "Meena", 6.0, 90),

                new PlacementDriveShortlistingRankingEngine(
                        "Karan", 7.5, 20)
        };

        System.out.println(
                shortlistAndRank(candidates)
        );
    }
}