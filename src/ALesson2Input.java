import java.util.*;
public class ALesson2Input {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("What is your favourite colour? ");
        String colour = input.nextLine();

        System.out.println("Hello " + name + " your favourite colour is a" + colour + "\n");

    }
}
