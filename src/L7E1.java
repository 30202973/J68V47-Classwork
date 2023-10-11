import java.util.*;
public class L7E1 {
    public static void printMessage() {
        System.out.println("Menu");
        System.out.println("1. Say hello");
        System.out.println("2. Tell me the time");
        System.out.println("3. Tell me a joke");
        System.out.println("4. Quit");

        System.out.print("Input an option (1-4): ");

    }


    public static int getOption() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();

    }

    public static void main(String[] args) {
        int option;
        do {
            printMessage();
            option = getOption();
            System.out.format("You chose option %d %n", option);
            if (option == 1) {
                System.out.println("HELLO!");
            } else if (option == 2) {
                System.out.println("The time is now.");
            } else if (option == 3) {
                System.out.println("Knock knock. Who's there? ....... long pause ........ Java");
            } else if (option == 4) {
                System.out.println("Bye!");
            } else {
                System.out.println("This isn't a valid option. Try a number between 1 and 4.");
            }

        } while (option != 4);

    }
}
