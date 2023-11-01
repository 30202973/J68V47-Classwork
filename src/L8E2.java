import java.util.*;
public class L8E2 {
    public static void main(String[] args) {
        int[] scores = {35,67,80,13,73};
        for (int index  = 0; index  < scores.length; index ++) {
            System.out.println( scores[index ] );
        }
        System.out.println("The average exam score is: " + ((scores[0] + scores[1] + scores[2] + scores[3] + scores[4]) / 5));

    }
}
