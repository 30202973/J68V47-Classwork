import java.util.Scanner;
import java.util.InputMismatchException;
public class L9E3 {
    public static int askQuestion(int number1, int number2){
        Scanner scanner = new Scanner(System.in);
        int userAnswer = 0;
        boolean inputError = true;

        while (inputError) {
            try {
                System.out.format("What is %d + %d? ", number1, number2);
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Error: Empty input. Please provide a valid answer.");
                    continue;
                }

                if (input.matches("\\s+")) {
                    System.out.println("Error: Space key pressed. Please provide a valid answer.");
                    continue;
                }

                userAnswer = Integer.parseInt(input);
                inputError = false;

            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a numeric value.");
            }
        }

        return userAnswer;
    }

    public static int correctAnswer(int score) {
        System.out.println("CORRECT!");
        score++;
        return score;
    }

    public static int wrongAnswer(int answer, int lives) {
        System.out.format("WRONG! The answer is %d %n", answer);
        lives--;
        System.out.format("You have %d lives left. %n", lives);
        return lives;
    }

    public static void gameOver(int score, int lives, boolean errorFlag) {
        if (errorFlag) {
            System.out.println("Error(s) occurred during the quiz.");
        }

        System.out.format("GAME OVER. Your final score is %d %n", score);
        if (lives > 0) {
            System.out.println("Well done!");
        }
    }

    public static void main(String[] args) {
        int score = 0;
        int lives = 3;
        int userAnswer = 0;
        int answer = 0;
        int count = 1;
        boolean errorFlag = false;

        while (count <= 10 && lives > 0) {
            userAnswer = askQuestion(count, count * count);
            answer = count + (count * count);

            if (answer == userAnswer) {
                score = correctAnswer(score);
            } else {
                lives = wrongAnswer(answer, lives);
            }

            count++;
        }

        gameOver(score, lives, errorFlag);
    }
}
