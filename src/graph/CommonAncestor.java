package graph;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class CommonAncestor {

    static class Pair {
        Integer parent;
        Integer child;

        public Pair(Integer parent, Integer child) {
            this.parent = parent;
            this.child = child;
        }
    }

    public static void main(String[] args) {
        List<Pair> list = List.of(
                new Pair(1, 3),
                new Pair(2, 3),
                new Pair(3, 6),
                new Pair(5, 6),
                new Pair(5, 7),
                new Pair(4, 5),

                new Pair(4, 8),
                new Pair(4, 9),
                new Pair(9, 11),
                new Pair(14, 4),
                new Pair(13, 12),
                new Pair(12, 9));

        System.out.println(hasCommonAncestor(list, 1, 3));
    }


    static boolean hasCommonAncestor(List<Pair> pairs, Integer first, Integer second) {

        HashMap<Integer, Set<Integer>> mapPar = new HashMap<>();

        for (Pair pair : pairs) {
            Set<Integer> list = mapPar.getOrDefault(pair.parent, new HashSet<>());
            list.add(pair.child);
            mapPar.put(pair.parent, list);
        }


        HashMap<Integer, Set<Integer>> mapCh = new HashMap<>();

        for (Pair pair : pairs) {
            Set<Integer> list = mapCh.getOrDefault(pair.child, new HashSet<>());
            list.add(pair.parent);
            mapCh.put(pair.child, list);
        }


        Set<Integer> firstParents = mapCh.get(first);

        Set<Integer> secondParents = mapCh.get(second);

        if (firstParents == null || secondParents == null) {
            return false;
        }
        while (true) {
            if (firstParents.stream().anyMatch(secondParents::contains)) {
                return true;
            }

            firstParents = firstParents.stream().filter(mapCh::containsKey).map(mapCh::get).flatMap(Collection::stream).collect(toSet());
            secondParents = secondParents.stream().filter(mapCh::containsKey).map(mapCh::get).flatMap(Collection::stream).collect(toSet());

            if (firstParents.isEmpty() || secondParents.isEmpty()) {
                return false;
            }
        }
    }
}
