package dynamic_programming;

public class RangeSumQuery2DImmutable {

    public static void main(String[] args) {

    }

    int[][] dp;

    /**
     * решаем препроцессингом через динамическое программирование, матрица dp будет cодержать как бы кумулятивную сумму
     * и в итоге для того что бы получить результат - необходимо взять дальнюю диагональ ,
     * вычесть из нее краевые как бы значения и сложить с ближней диагональю
     */

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //матрица будет на одну строку и один столбец больше так как там будут нули для удобства складывания
        dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //делаем кумулятивную сумму
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}
