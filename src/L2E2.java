import java.util.*;
public class L2E2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the first number? ");
        int num1 = input.nextInt();

        System.out.print("What is the second number? ");
        int num2 = input.nextInt();

        float divResult = (float) num1 / (float) num2;

        System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
        System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
        System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
        System.out.println(num1 + "/" + num2 + "=" + (num1 / num2));
        System.out.println(num1 + "%" + num2 + "=" + (num1 % num2));
        System.out.println(num1 + "^" + num2 + "=" + (int) Math.pow(num1,num2));

    }


}
