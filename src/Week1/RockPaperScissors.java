package Week1;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int rounds = 5;

        String[] moves = {"Rock", "Paper", "Scissors"};

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < rounds; i++) {

            System.out.println("Round " + (i + 1));

            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            String player = sc.nextLine();

            int randomNumber = random.nextInt(3);
            String computer = moves[randomNumber];

            String result;

            if (player.equalsIgnoreCase(computer)) {

                result = "Draw";
                draws++;

            } else if (
                    (player.equalsIgnoreCase("Rock") && computer.equals("Scissors")) ||
                            (player.equalsIgnoreCase("Paper") && computer.equals("Rock")) ||
                            (player.equalsIgnoreCase("Scissors") && computer.equals("Paper"))
            ) {

                result = "Player Wins";
                wins++;

            } else {

                result = "Computer Wins";
                losses++;
            }

            playerMoves[i] = player;
            computerMoves[i] = computer;
            results[i] = result;

            System.out.println("Computer: " + computer);
            System.out.println("Result: " + result);
            System.out.println();
        }

        System.out.println("========== FINAL SUMMARY ==========");

        System.out.println("Round\tPlayer\t\tComputer\tResult");

        for (int i = 0; i < rounds; i++) {

            System.out.println(
                    (i + 1) + "\t" +
                            playerMoves[i] + "\t\t" +
                            computerMoves[i] + "\t\t" +
                            results[i]
            );
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println();
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");

        sc.close();
    }
}