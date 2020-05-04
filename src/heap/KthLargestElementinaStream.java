package heap;

import java.util.PriorityQueue;

public class KthLargestElementinaStream {


    /**
     * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
     *
     * Example:
     *
     * int k = 3;
     * int[] arr = [4,5,8,2];
     * KthLargest kthLargest = new KthLargest(3, arr);
     * kthLargest.add(3);   // returns 4
     * kthLargest.add(5);   // returns 5
     * kthLargest.add(10);  // returns 5
     * kthLargest.add(9);   // returns 8
     * kthLargest.add(4);   // returns 8
     */


    PriorityQueue<Integer> que;
    int size;
    public KthLargestElementinaStream(int k, int[] nums) {
        size = k;
        que = new PriorityQueue<>((a,b) -> a - b);
        for(int num : nums){
            que.offer(num);
            if(que.size() > k){
                que.poll();
            }
        }

    }

    public int add(int val) {
        que.offer(val);
        if(que.size() > size){
            que.poll();
        }
        return que.peek();
    }
}
