package matrix;

public class LongestIncreasingPathinaMatrix {


    public static void main(String[] args) {

    }

    /**
     *
     */

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int result = 0;
        int n = matrix.length, m = matrix[0].length;
        //кэшируем в каждую точку - по принципу
        //к какой макс последовательности данная точка приведет
        int[][] cache = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curMaxLength = dfs(i, j, matrix, cache, Long.MAX_VALUE);
                result = Math.max(result, curMaxLength);
            }
        }
        return result;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] cache, long prev) {

        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] >= prev) {
            return 0;
        }

        // если считали ранее то смысла считать по новой нет - просто возвращаем это значение
        if (cache[i][j] > 0) {
            return cache[i][j];
        } else {
            int cur = matrix[i][j];
            int tempMax = 0;
            tempMax = Math.max(dfs(i - 1, j, matrix, cache, cur), tempMax);
            tempMax = Math.max(dfs(i + 1, j, matrix, cache, cur), tempMax);
            tempMax = Math.max(dfs(i, j - 1, matrix, cache, cur), tempMax);
            tempMax = Math.max(dfs(i, j + 1, matrix, cache, cur), tempMax);
            cache[i][j] = ++tempMax;
            return tempMax;
        }
    }
}
