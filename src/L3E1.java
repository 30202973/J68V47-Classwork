import java.util.*;
public class L3E1 {
    public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.print("Enter your first name: ");
    String name = input.nextLine();

    System.out.print("Enter your surname: ");
    String surname = input.nextLine();
    System.out.print("Enter your year of birth YYYY: ");
    int year = input.nextInt();



    System.out.println("Username: " + name.substring(0,1) + surname );
    System.out.println("Password: " + surname.substring(0,1).toLowerCase() + name.substring(0,3).toUpperCase() + year );


    }
}
