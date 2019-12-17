package matrix;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}};

        System.out.println(numIslands(grid));
    }

    //DFS подход
    static int numIslands(char[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    findAndMark(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }


    static void findAndMark(char[][] matrix, int i, int j) {

        if (i >= 0
                && i <= matrix.length - 1
                && j >= 0
                && j <= matrix[0].length - 1
                && matrix[i][j] == '1') {

            matrix[i][j] = '0';
            findAndMark(matrix, i - 1, j); //move up
            findAndMark(matrix, i + 1, j); //move down
            findAndMark(matrix, i, j + 1); //move left
            findAndMark(matrix, i, j - 1); //move right
        }
    }
}
