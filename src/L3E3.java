import java.util.*;
public class L3E3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the cost of a loan: £");
        double cost = input.nextDouble();

        System.out.print("Enter the interest rate (APR %): ");
        double interest = input.nextDouble();

        System.out.print("Enter the number of years for the loan: ");
        double years = input.nextDouble();

        //System.out.println("Monthly payment for this loan is " + cost( interest / (1- ((int) Math.pow((1+interest),years)))) );

    }
}
