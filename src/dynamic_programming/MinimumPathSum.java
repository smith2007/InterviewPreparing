package dynamic_programming;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };

        System.out.println(minPathSum(matrix));
    }

    /**
     * дана матрица размера m x n, она заполнена не отрицательными числами,
     * задача состоит в том что бы найти путь из крайнего верхнего угла в
     * крайний нижний правый угол, так что бы сумма была минимальна
     * <p>
     * двигаться можно только вправо и вниз
     */

    static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            grid[0][j] = grid[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }
}
