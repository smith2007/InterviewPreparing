package matrix;

public class Searcha2DMatrixStepSearchAlgorithm {

    public static void main(String[] args) {

        int[][] matr = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        System.out.println(searchMatrix(matr, 3));
    }


    static boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        //начинаем рассмотрение с перовой строки
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
