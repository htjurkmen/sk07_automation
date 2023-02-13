package lecture05.exercises;

public class Exercise6 {
    // Find sum of the diagonal of a given 2d matrix with 4 rows and 4 columns
    public static void main(String[] args) {
        int[][] matrix2d = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int sumDiagonal1 = 0;
        int sumDiagonal2 = 0;
        for(int row = 0; row < matrix2d.length; row++) {
            for(int column = 0; column < matrix2d[row].length; column++) {
                if (row == column) {
                    sumDiagonal1 += matrix2d[row][column];
                }
                if (column == (matrix2d.length - row -1)) {
                    sumDiagonal2 += matrix2d[row][column];
                }
            }
        }
        System.out.println("The sum of the first diagonal is: " + sumDiagonal1);
        System.out.println("The sum of the second diagonal is: " + sumDiagonal2);
    }
}
