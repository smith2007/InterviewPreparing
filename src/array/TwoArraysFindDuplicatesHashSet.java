package array;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoArraysFindDuplicatesHashSet {

    public static void main(String[] args) {
        int[] firstArray = {3, 2, 5, 1, 4};
        int[] secondArray = {7, 8, 5, 0, 4};
        int[] duplicates = findDuplicates(firstArray, secondArray);
        System.out.println("Duplicates are : ");
        IntStream.of(duplicates).forEach(System.out::println);

    }

    static int[] findDuplicates(int[] first, int[] second) {

        HashSet<Integer> result = new HashSet<>();

        HashSet<Integer> firstHashset = IntStream.of(first)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));

        HashSet<Integer> secondHashset = IntStream.of(second)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));

        for (Integer integer : secondHashset) {
            if (firstHashset.contains(integer)) {
                result.add(integer);
            }
        }

        int[] a = new int[result.size()];
        int i = 0;
        for (Integer val : result) a[i++] = val;
        return a;
    }

}
