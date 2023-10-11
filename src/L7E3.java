import java.util.*;
public class L7E3 {
    public static int askQuestion(int num1, int num2) {
        Scanner scanner = new Scanner(System.in);
        System.out.format("What is %d + %d? ", num1, num2);
        int userAnswer = scanner.nextInt();
        return userAnswer;
    }


    public static int correctAnswer(int option) {
        System.out.println("CORRECT!");
        option++;
        return option;

    }

    public static int wrongAnswer(int answer, int lives) {
        System.out.format("WRONG! The answer is %d %n", answer);
        lives--;
        System.out.format("You have %d lives left. %n", lives);
        return lives;
    }
    public static void gameOver(int option, int lives) {
        System.out.format("GAME OVER. Your final score is %d %n", option);
        if (lives > 0) {
            System.out.println("Well done!");
        }
    }


    public static void main (String[]args){
            int option = 0;
            int lives = 3;
            int userAnswer = 0;
            int answer = 0;
            int count = 1;
            while (count <= 10 && lives > 0) {
                userAnswer = askQuestion(count, count * count);
                answer = count + (count * count);

                if (answer == userAnswer) {
                    option = correctAnswer(option);

                } else {
                    lives = wrongAnswer(answer, lives);
                }
                count++;
            }
            gameOver(option, lives);

        }
    }

