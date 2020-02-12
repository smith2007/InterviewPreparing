package matrix;

public class SpiralMatrixII {

    public static void main(String[] args) {

        int[][] matrix = generateMatrix(4);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] generateMatrix(int n) {

        if (n == 0) {
            return new int[0][0];
        }

        int[][] res = new int[n][n];

        int seq = 1;

        int colStart = 0;
        int colEnd = n - 1;

        int rowStart = 0;
        int rowEnd = n-1;



        while (colStart <= colEnd && rowStart <= rowEnd) {

            for (int i = colStart; i <= colEnd; i++) {
                res[rowStart][i] = seq;
                seq++;
            }
            rowStart++;


            for (int i = rowStart; i <= rowEnd; i++) {
                res[i][colEnd] = seq;
                seq++;
            }
            colEnd--;


            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    res[rowEnd][i] = seq;
                    seq++;
                }
            }
            rowEnd--;

            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    res[i][colStart] = seq;
                    seq++;
                }
            }
            colStart++;

        }

        return res;
    }
}
