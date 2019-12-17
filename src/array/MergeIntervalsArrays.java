package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsArrays {

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] merge = merge(arr);

        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0] + " " + merge[i][1]);
        }

    }

    /***
     * https://leetcode.com/problems/merge-intervals/
     * 
     */


    static int[][] merge(int[][] arr) {

        // ну первое надо искать те элементы
        //которые образуют интервал
        //как найти
        //первое надо взять начало итого интервала
        //далее взять конец итого интервала

        // и искать те элементы чейна как бы
        // начало которых меньше или равно концу первого интервала
        // ну первое надо искать те элементы
        //которые образуют интервал
        //как найти
        //первое надо взять начало итого интервала
        //далее взять конец итого интервала

        // и искать те элементы чейна как бы
        // начало которых меньше или равно концу первого интервала

        Arrays.sort(arr, Comparator.comparingInt(value -> value[0]));

        if (arr.length == 0 || arr[0].length == 0) {
            return new int[0][0];
        }
        if (arr.length == 1) {
            return arr;
        }

        List<List<Integer>> res = new ArrayList<>();

        int[] prev = arr[0];
        for (int i = 1; i < arr.length; i++) {

            int[] cur = arr[i];
            if (prev[0] <= cur[0] && prev[1] >= cur[1]) {
                continue;
            } else if (cur[0] <= prev[1]) {
                prev[1] = cur[1];
            } else {
                res.add(Arrays.asList(prev[0], prev[1]));
                prev = cur;
            }
        }
        res.add(Arrays.asList(prev[0], prev[1]));

        int[][] resp = new int[res.size()][2];

        for (int i = 0; i < resp.length; i++) {
            for (int j = 0; j < resp[0].length; j++) {
                resp[i][j] = res.get(i).get(j);
            }
        }
        return resp;
    }
}
