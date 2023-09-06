import java.util.*;
public class L2E3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of item 1: ");
        String name1 = input.nextLine();

        System.out.print("Enter the price of item 1: ");
        double price1 = input.nextDouble();

        System.out.print("Enter the name of item 2: ");
        String name2 = input.nextLine();
        name2 = input.nextLine();

        System.out.print("Enter the price of item 2: ");
        double price2 = input.nextDouble();


        System.out.print("Enter the name of item 3: ");
        String name3 = input.nextLine();
        name3 = input.nextLine();


        System.out.print("Enter the price of item 3: ");
        double price3 = input.nextDouble();




        System.out.format("NESMART" + "%n" + name1 + "........." + price1 + "%n" + name2 + "........." + price2 + "%n" + name3 +
                "........." + price3 + "%n");
        System.out.format("SUBTOTAL........." + (price1 + price2 +price3 ));

    }

}
