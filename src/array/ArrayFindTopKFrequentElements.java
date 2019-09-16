package array;

import java.util.*;

public class ArrayFindTopKFrequentElements {


    public static void main(String[] args) {

        int[] arr = {1, 4, 1, 2, 6, 8, 2, 3, 3};
        int k = 3;


        //find(arr, k).forEach(System.out::println);


        List<Integer> res = find1(arr, k);

    }

    static List<Integer> find(int[] arr, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // инициализируем очередь с приоритетом
        //указываем на как будет расчитываться приоритет нашего элемента
        //(n1, n2) -> map.get(n1) - map.get(n2)
        //приоритет будем считать на основе разницы в каунтах у кого самый
        // маленький каунт тот и приоритетнее
        PriorityQueue<Integer> heap =
                new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

        // keep k top frequent elements in the heap
        for (int n : map.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // build output list
        LinkedList<Integer> topK = new LinkedList<>();
        while (!heap.isEmpty()) {
            topK.add(heap.poll());
        }
        Collections.reverse(topK);
        return topK;
    }



    public static List<Integer> find1(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        for(int i =0; i<k;i++){
            res.add(0);
        }
        Map<Integer,Integer> map = new HashMap<>();

        for(int elm : nums){
            map.put(elm, map.getOrDefault(elm,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((e1,e2)->map.get(e1)-map.get(e2));

        for(int elm:map.keySet()){
            pq.add(elm);
            if(pq.size()>k){
                pq.poll();
            }
        }

        for(int i = k-1; i>=0; i--){
            res.set(i, pq.poll());
        }

        return res;
    }
}
