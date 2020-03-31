package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {

    }

    /**
     * это классика - решается через приорити кюю -
     * самая большая загвостка это как раз как посчитать это ебучее евклидово расстояние
     *
     *  берем точку x, y - евклидово расстояние это квадрат x + квадрат y
     */

    static int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));

        int[][] res = new int[k][2];

        queue.addAll(Arrays.asList(points));

        for (int i = 0; i <k ; i++) {
            int[] polled = queue.poll();
            res[i][0] = polled[0];
            res[i][1] = polled[1];
        }

        return res;
    }
}
