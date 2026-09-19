package Week5.Assignments;

public class MatchStats {

    private static double calcAverage(int[] overs) {
        if (overs == null || overs.length == 0) {
            return 0.0;
        }

        double total = 0;
        for (int runs : overs) {
            total += runs;
        }

        return total / overs.length;
    }

    public static String getMatchReports(int[][] matchData, int targetRunRate) {
        StringBuilder report = new StringBuilder();

        for (int i = 0; i < matchData.length; i++) {
            double avg = calcAverage(matchData[i]);
            String status = (avg >= targetRunRate) ? "Power Surge" : "Normal";

            report.append("Match ").append(i).append(": ").append(status);

            if (i < matchData.length - 1) {
                report.append(" | ");
            }
        }

        return report.toString();
    }

    public static void main(String[] args) {
        int[][] runsGrid = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };

        int cutoff = 8;
        System.out.println(getMatchReports(runsGrid, cutoff));
    }
}
