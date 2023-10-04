import java.util.*;
public class L6E2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int option = 4;
        do{
            System.out.println("Options:" + "\n" + "1.Say “hello”"
                    + "\n" + "2.Tell me the time" + "\n" + "3.Tell me a joke" + "\n" + "4.Quit" + "\n");

            System.out.println("Choose an option:");
           option = input.nextInt();

        }
        while( option!=4 );

    }

}
