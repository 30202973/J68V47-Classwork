import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class L11E1 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Input a number: ");
            try {
                int base = input.nextInt();
                input.nextLine(); // Consume the newline character

                try (PrintWriter out = new PrintWriter(new FileWriter("output.txt"))) {
                    for (int count = 1; count <= 12; count++) {
                        out.println(base + " x " + count + " = " + (count * base));
                    }
                } catch (IOException e) {
                    System.out.println("Error occurred writing to file: " + e);
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}