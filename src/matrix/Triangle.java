package matrix;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        int[][] matrix = {{2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}};

        List<List<Integer>> triangle = new ArrayList<>();

        for (int[] ints : matrix) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int anInt : ints) {
                list.add(anInt);
            }
            triangle.add(list);
        }

        System.out.println(minimumTotal(triangle));

    }

    static int minimumTotal(List<List<Integer>> triangle) {
        //задача решается через дп
        int[] dp = new int[triangle.size() + 1];

        //первый обрамляющий цикл - идем снизу вверх по строкам
        for (int i = triangle.size() - 1; i >= 0; i--) {
            //дальше ходим по столбцам
            for (int j = 0; j < triangle.get(i).size(); j++) {
                //выбираем минимум из того что
                int min = Math.min(dp[j], dp[j + 1]);
                dp[j] = min + triangle.get(i).get(j);

            }
        }
        return dp[0];
    }
}
