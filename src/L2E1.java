import java.util.*;
public class L2E1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("What is your hobby? ");
        String hobby = input.nextLine();

        System.out.println(name + "'s joy was " + hobby + "." + " Each Saturday she entered her studio, took up her brush, and immersed herself in color until a new creation emerged. " + "\n" + hobby + " allowed her creative spirit to flow freely.");

    }
}
