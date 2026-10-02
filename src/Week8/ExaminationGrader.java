package Week8;

import java.util.Scanner;

interface Question {
    double grade(String correctAnswer, String studentAnswer, double points);
    String getType();
}

class MCQ implements Question {

    public double grade(String correctAnswer, String studentAnswer, double points) {
        if (correctAnswer.equals(studentAnswer)) {
            return points;
        }
        return 0;
    }

    public String getType() {
        return "MCQ";
    }
}

class TF implements Question {

    public double grade(String correctAnswer, String studentAnswer, double points) {
        if (correctAnswer.equals(studentAnswer)) {
            return points;
        }
        return 0;
    }

    public String getType() {
        return "TF";
    }
}

class Essay implements Question {

    public double grade(String correctAnswer, String studentAnswer, double points) {

        String[] keywords = correctAnswer.split(",");
        int count = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase().contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }

    public String getType() {
        return "ESSAY";
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split("\"");

            String type = parts[0].trim();

            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];

            String remaining = parts[6].trim();
            double points = Double.parseDouble(remaining);

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQ();
            } else if (type.equals("TF")) {
                question = new TF();
            } else {
                question = new Essay();
            }

            double score = question.grade(correctAnswer, studentAnswer, points);

            System.out.printf("%s: %.2f%n", question.getType(), score);

            total = total + score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}