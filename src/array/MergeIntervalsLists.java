package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervalsLists {

    public static void main(String[] args) {

        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        first.add(3);
        lists.add(first);

        ArrayList<Integer> second = new ArrayList<>();
        second.add(2);
        second.add(6);
        lists.add(second);

        ArrayList<Integer> third = new ArrayList<>();
        third.add(8);
        third.add(10);
        lists.add(third);

        ArrayList<Integer> fourth = new ArrayList<>();
        fourth.add(9);
        fourth.add(12);
        lists.add(fourth);
        List<List<Integer>> merge = merge(lists);

        merge.forEach(System.out::println);
    }

    static List<List<Integer>> merge(List<List<Integer>> collect) {

        Comparator<List<Integer>> tComparator = Comparator.comparingInt(l -> l.get(0));

        List<List<Integer>> lists = collect.stream().sorted(tComparator).collect(Collectors.toList());


        List<List<Integer>> result = new ArrayList<>();

        int i = 0;

        while (i + 1 < lists.size()) {
            Integer leftEdge1 = lists.get(i).get(0);
            Integer leftEdge2 = lists.get(i + 1).get(0);

            Integer rightEdge1 = lists.get(i).get(1);
            Integer rightEdge2 = lists.get(i + 1).get(1);

            List<Integer> merged = new ArrayList<>();

            if (leftEdge1 <= leftEdge2 && leftEdge2<=rightEdge1) {
                merged.add(leftEdge1);
                if (rightEdge2 >= rightEdge1) {
                    merged.add(rightEdge2);
                } else {
                    merged.add(rightEdge1);
                }
                i += 2;
            } else {
                merged.add(leftEdge1);
                merged.add(rightEdge1);
                i++;
            }
            result.add(merged);
        }

        return result;
    }
}
