import java.util.*;
public class L3E2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String f = "The capital of France is Paris.";
        String s = "The capital of Senegal is Dakar.";
        String k = "The capital of South Korea is Seoul.";

        System.out.print("Q1. What is the capital of France? ");
        String q1 = input.nextLine();
        System.out.println(f.toLowerCase().toUpperCase().contains("PARIS"));

        System.out.print("Q2. What is the capital of Senegal? ");
        String q2 = input.nextLine();
        System.out.println(s.toLowerCase().toUpperCase().contains("DAKAR"));

        System.out.print("Q3. What is the capital of South Korea? ");
        String q3 = input.nextLine();
        System.out.println(k.toLowerCase().toUpperCase().contains("SEOUL"));


    }

}
