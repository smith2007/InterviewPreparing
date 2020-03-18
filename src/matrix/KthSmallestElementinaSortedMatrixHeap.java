package matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrixHeap {

    public static void main(String[] args) {

        int[][] matrix = {{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};

        System.out.println(kthSmallest(matrix, 8));
    }


    static int kthSmallest(int[][] matrix, int k) {

        if (matrix.length == 0) {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.add(matrix[i][j]);
                if (pq.size()>k){
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
}
