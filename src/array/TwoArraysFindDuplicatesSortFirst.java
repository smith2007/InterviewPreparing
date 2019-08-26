package array;

import java.util.Arrays;

public class TwoArraysFindDuplicatesSortFirst {

    public static void main(String[] args) {
        int[] first = {3, 2, 1, 6, 3};
        int[] second = {4, 8, 9, 6};

        find(first, second);
        //duplicates : 6
    }

    // sorting - O(n log n) + search O(log n) + traversing first array O(n)
    // => O(4n log n) -> O(n log n)
    private static void find(int[] first, int[] second) {
        Arrays.sort(first);

        String s = "";
        for (int i = 0; i < second.length; i++) {
            int searchResult = Arrays.binarySearch(first, second[i]);
            if (searchResult >= 0) {
                s = s + " " + second[i];
            }
        }

        if (s.isEmpty()) {
            System.out.println("There are no duplicates");
        } else {
            System.out.println("Duplicates are " + s);
        }
    }
}
