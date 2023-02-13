package lecture06.examples;

public class MethodOverloading {
    public static void main(String[] args) {
        int myNum1 = sumNumbers(8, 5);
        double myNum2 = sumNumbers(4.3, 6.26);
        System.out.println("int: " + myNum1);
        System.out.println("double: " + myNum2);
    }
    static int sumNumbers(int x, int y) {
        return x + y;
    }
    static double sumNumbers(double x, double y) {
        return x + y;
    }
}
