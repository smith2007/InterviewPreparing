package array;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public static void main(String[] args) {

        int[][] a = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] b = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};


        int[][] res = intervalIntersection(a, b);

        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    static int[][] intervalIntersection(int[][] a, int[][] b) {

        if (a.length == 0 || b.length == 0) {
            return new int[0][0];
        }

        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            int[] first = a[i];
            int[] second = b[j];
            int low = Math.max(first[0], second[0]);
            int high = Math.min(first[1], second[1]);

            if (low <= high) {
                result.add(new int[]{low, high});
            }

            if (a[i][1] < b[j][1]) {
                i++;

            } else {
                j++;

            }
        }

        int[][] res = new int[result.size()][2];

        for (int k = 0; k < result.size(); k++) {
            res[k][0] = result.get(k)[0];
            res[k][1] = result.get(k)[1];
        }

        return res;
    }
}
