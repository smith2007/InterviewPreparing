package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTimeEffective {


    public static void main(String[] args) {

    }

    /**
     * подход который работает за время O(n log k) - он состоит в том что мы пользуемся идеей
     * о том что каждая строка отсортирована, затем используя PriorityQueue будем плясать
     */
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> schedule.get(a[0]).get(a[1]).start));

        for (int i = 0; i < schedule.size(); i++) {
            pq.add(new int[]{i, 0});
        }

        List<Interval> res = new ArrayList<>();
        int prev = schedule.get(pq.peek()[0]).get(pq.peek()[1]).start;
        while (!pq.isEmpty()) {

            int[] index = pq.poll();

            Interval interval = schedule.get(index[0]).get(index[1]);

            if (interval.start > prev) {
                res.add(new Interval(prev, interval.start));
            }

            prev = Math.max(prev, interval.end);
            if (schedule.get(index[0]).size() > index[1] + 1) {
                pq.add(new int[]{index[0], index[1] + 1});
            }
        }
        return res;
    }

    static class Interval {
        public int start;
        public int end;

        Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }
}


