import java.util.*;
public class L6E3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int score = 0;
        int life = 3;
        int count = 1;
        do{
            System.out.print("What is 2 x 3 ? ");
            int q1 = input.nextInt();
            count++;
            if (q1 != 6) {
                System.out.println("Sorry, the correct answer is 6.");
                life--;
            } else {
                score++;
            }
        }
        while ( life!=0 && count<=10);
        System.out.println("Score is: " + score);
        if (count == 10) {
            System.out.println("Well done");

        }


    }

}

