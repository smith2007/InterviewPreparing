package data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HitCounter {

    /**
     * ["HitCounter","hit","hit","hit","getHits","hit","getHits","getHits"]
     * [[],[1],[2],[3],[4],[300],[300],[301]]
     * @param args
     */

    public static void main(String[] args) {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);

        System.out.println(hitCounter.getHits(4));
        hitCounter.hit(300);
        System.out.println(hitCounter.getHits(300));

        System.out.println(hitCounter.getHits(301));
    }
    private List<Integer> timeline = Collections.synchronizedList(new ArrayList<>());

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {

    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        timeline.add(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int border = timestamp - 300;

        int count = 0;
        int i = timeline.size() - 1;
        for (; i >= 0; i--) {
            if (timeline.get(i) > border) {
                count++;
            } else {
                break;
            }
        }
        if (++i>0){
            timeline = timeline.subList(i, timeline.size());
        }
        return count;

    }
}
