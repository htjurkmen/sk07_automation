package lecture07.exercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideExercise {
    public static void main(String[] args) {
        int num1, num2;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Please provide the first number: ");
            num1 = scanner.nextInt();
            System.out.println("Please provide the second number: ");
            num2 = scanner.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
            throw new RuntimeException("Please provide a valid whole number!");
        }
        System.out.println("Result after division:" + divideNumbers(num1, num2));
    }

    public static double divideNumbers(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot divide by 0!");
        }
    }
}

