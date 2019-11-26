package heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    /**
     * решается элементарно через кучу, будь внимателен тут надо создавать
     * кучу с компаратором в reverseOrder
     * вот так  PriorityQueue<Integer> pq = new PriorityQueue<>((Comparator.reverseOrder()));
     */
    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};

        System.out.println(findKthLargest(arr, 4));
    }

    static int findKthLargest(int[] arr, int k) {
        if (arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);

        for (int i1 : arr) {
            pq.add(i1);
            if (pq.size() > k) {
                pq.poll();
            }
        }


        return pq.poll();

    }


}
