import java.util.*;
public class L4E2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Q1. What is the capital of France? ");
        String q1 = input.nextLine();
        if (!q1.toLowerCase().equals("paris")) {
           System.out.println("Sorry, the correct answer is PARIS.");
        }

        System.out.print("Q2. What is the capital of Senegal? ");
        String q2 = input.nextLine();
        if (!q2.toLowerCase().equals("dakar")){
           System.out.println("Sorry, the correct answer is DAKAR.");
        }

        System.out.print("Q3. What is the capital of South Korea? ");
        String q3 = input.nextLine();
        if (!q3.toLowerCase().equals("seoul")) {
           System.out.println("Sorry, the correct answer is SEOUL.");
        }

    }

}
