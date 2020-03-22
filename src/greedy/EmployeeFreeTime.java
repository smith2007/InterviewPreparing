package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFreeTime {

    public static void main(String[] args) {


//        [[[1,3],
//          [6,7]],
//
//
//          [[2,4]],
//
//          [[2,5],
//           [9,12]]]

        ArrayList<List<Interval>> schedule = new ArrayList<>();
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 7));
        schedule.add(intervals);

        ArrayList<Interval> intervals1 = new ArrayList<>();
        intervals1.add(new Interval(2, 4));
        schedule.add(intervals1);

        ArrayList<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(2, 5));
        intervals2.add(new Interval(9, 12));
        schedule.add(intervals2);
        List<Interval> intervals3 = employeeFreeTime(schedule);

        for (Interval interval : intervals3) {
            System.out.println(interval.start + " " + interval.end);
            System.out.println();
        }

    }

    static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {


        Comparator<Interval> comparator = Comparator.comparingInt(value -> value.start);

        List<Interval> intervals = schedule.stream()
                .flatMap(intervals1 -> intervals1.stream())
                .sorted(comparator)
                .collect(Collectors.toList());

        List<Interval> mergedList = new ArrayList<>();


        int i = 0;

        //мержим пересекающиеся интервалы
        Interval temp = null;
        while (i < intervals.size()) {

            if (temp == null) {
                temp = intervals.get(i);
            }

            while (i < intervals.size() && canMerge(temp, intervals.get(i))) {
                temp.start = Math.min(temp.start, intervals.get(i).start);
                temp.end = Math.max(temp.end, intervals.get(i).end);
                i++;
            }

            mergedList.add(temp);
            if (i < intervals.size() && !canMerge(temp, intervals.get(i))) {
                temp = intervals.get(i);
            }
        }

        //ищем разрывы смотря на предыдущий и текущий
        List<Interval> res = new ArrayList<>();
        for (int j = 1; j < mergedList.size(); j++) {
            Interval prev = mergedList.get(j - 1);
            Interval curr = mergedList.get(j);
            res.add(new Interval(prev.end, curr.start));
        }

        return res;
    }


    static boolean canMerge(Interval int1, Interval int2) {
        return int2.start <= int1.end;
    }

    static class Interval {
        public int start;
        public int end;

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

}
