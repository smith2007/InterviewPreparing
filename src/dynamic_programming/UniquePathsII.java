package dynamic_programming;

public class UniquePathsII {

    /**
     * 147.UniquePathsII
     *
     * https://leetcode.com/problems/unique-paths-ii/
     *
     * У нас есть робот, он расположен в левом верхнем углу абстрактной матрицы размера m x n
     * робот может ходить только вниз или вправо по матрице
     * этот робот пытается дойти до правого нижнего угла данной матрицы
     * Сколько различных уникальных коомбинаций путей есть у этого робота???
     *
     * ТАК же дана матрица преград, через преграды нельзя пробраться
     *
     * Input:
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * Output: 2
     *
     */
    public static void main(String[] args) {

    }

    static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }

        for (int j = 0; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] != 1) {
                dp[0][j] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];

    }

}
