import java.util.*;
public class L5E3 {
    public static void main(String[] args) {

        int score = 0;

        for( int count=1; count<=10; count++ ) {
            System.out.print("Q1. What is 2 x 3 ? ");
            Scanner input = new Scanner(System.in);
            int q1 = input.nextInt();
            if (q1 != 6) {
                System.out.println("Sorry, the correct answer is 6.");
            } else {
                score++;
            }
        }
        System.out.println("Score is: " + score);



    }
}
