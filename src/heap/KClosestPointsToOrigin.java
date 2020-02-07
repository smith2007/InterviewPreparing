package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {

    }

    static int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));

        int[][] res = new int[k][2];

        for (int[] arr : points) {
            queue.add(arr);
        }

        for (int i = 0; i <k ; i++) {
            int[] polled = queue.poll();
            res[i][0] = polled[0];
            res[i][1] = polled[1];
        }

        return res;
    }
}
