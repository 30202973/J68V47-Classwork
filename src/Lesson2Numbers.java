import java.util.*;
public class Lesson2Numbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many items? ");
        int num = input.nextInt();

        System.out.print("Price per item £");
        double price = input.nextDouble();

        System.out.format("Total = £%.2f%n", (price * num));


    }


}
