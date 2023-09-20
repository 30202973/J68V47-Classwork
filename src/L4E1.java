import java.util.*;
public class L4E1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstname = input.nextLine();

        System.out.print("Enter your surname: ");
        String surname = input.nextLine();

        System.out.print("Enter the total value of your order: £");
        double total = input.nextDouble();

        System.out.print("Enter the amount you wish to pay as deposit: £");
        double deposit = input.nextDouble();

        System.out.format("== RECEIPT ==" + "%n" + "Customer: " + firstname.substring(0,1) + " " + surname
                + "%n" + "Order Total £" + total + "%n" + "Deposit Paid £" + deposit + "%n" + "Remainder £" + (total - deposit) + "%n");

        if (deposit > 100) {
            System.out.println("You get a free toaster!");
        }
        System.out.println("Have a nice day");



    }
}
