import java.util.*;
public class L8E2 {
    public static void main(String[] args) {
        int[] scores = {35,67,80,13,73,66,33,91,11,55};
        for (int index  = 0; index  < scores.length; index ++) {
            System.out.println( scores[index] );
        }
        double average = (double)(scores[0] + scores[1] + scores[2] + scores[3] + scores[4] + scores[5] + scores[6] + scores[7] + scores[8] + scores[9]) / 10;
        System.out.println("The average exam score is: " + (average));

    }
}
