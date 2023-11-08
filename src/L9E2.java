import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class L9E2 {

    public static void exception1() {
        try {
            int exception1 = 10 / 0;
            System.out.println(exception1);
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
        }
    }

    public static void exception2() {
        try {
            int exception2 = Integer.MAX_VALUE + 1;
            System.out.println(exception2);
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
        }
    }

    public static void exception3() {
        try {
            int[] myArray3 = new int[5];
            int exception3 = myArray3[5];
            System.out.println(exception3);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
    }

    public static void exception4() {
        try {
            int[] myArray4 = null;
            int exception4 = myArray4[0];
            System.out.println(exception4);
        } catch (NullPointerException e) {
            System.out.println(e.toString());
        }
    }

    public static void exception5() {
        try {
            File exception5 = new File("exception5.txt");
            Scanner scanner = new Scanner(exception5);
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
    }

    public static void exception6() {
        try {
            String thisString = "Hello";
            int exception6 = Integer.parseInt(thisString);
            System.out.println(exception6);
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
        }
    }

    public static void exception7() {
        String exception7 = null;
        System.out.println(exception7.toUpperCase());

    }

    public static void main(String[] args) {
        exception1();
        exception2();
        exception3();
        exception4();
        exception5();
        exception6();
    }
}
