import java.util.*;
public class L4E3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your total purchase amount: £");
        double total = input.nextDouble();
        if (total < 50) {
            System.out.println("Shipping cost is = £10.00" );
            System.out.format("Your final total is = £" + (total+10));
        } else {
            System.out.println("Your final total is = £" + total);
        }




    }
}
