import java.util.*;
public class L7E2 {
    public static void calculateSum(int firstNum, int secondNum){
        int calc = firstNum * secondNum;
        System.out.println("The sum is: " + calc);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int firstNum = input.nextInt();
        System.out.println("Enter the second number: ");
        int secondNum = input.nextInt();
        calculateSum(firstNum, secondNum);
    }

    }
