import java.util.Scanner;
public class L9E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String response = scanner.nextLine();

        if (response.length() == 0) {
            System.out.println("You didn't enter a name. Exiting program.");

        } else {
            int charactersToDisplay = Math.min(response.length(), 10);

            for (int i = charactersToDisplay; i > 0; i--) {
                String character = response.substring(0, 1);
                response = response.substring(1);
                System.out.print(character);
            }
        }
    }
}
