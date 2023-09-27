import java.util.*;
public class L5E1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a base number: ");
        int base = input.nextInt();

        for( int count=1; count<=12; count++ )
        {
            System.out.println(base + " x " + count + " = " + (count*base));
        }

    }
}
