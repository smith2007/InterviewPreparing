package heap;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String[] args) {

        String[] strs = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        topKFrequent(strs, 4).forEach(System.out::println);

    }


    static List<String> topKFrequent(String[] words, int k) {

        if (words.length == 0 || k == 0) {
            return new ArrayList<>();
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
            if (pq.size() > k) {
                pq.poll();
            }
        }

        ArrayList<String> res = new ArrayList<>(pq);
        Collections.reverse(res);
        return res;
    }
}
