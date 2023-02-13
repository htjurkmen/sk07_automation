package lecture04.exercises;

public class Exercise5 {
    //    Find the largest number from a given array and print it in a console. Hint: use for loop
    public static void main(String[] args) {
        int [] numberArray = { 3, 2000, 6, 7, -100 };
        int maxNumber = numberArray[0];
        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i] > maxNumber) {
                maxNumber = numberArray[i];
            }
        }
        System.out.println("The largest number in the array is " + maxNumber);
    }
}
