package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    /**
     * Given a sorted integer array without duplicates, return the summary of its ranges.
     * <p>
     * Example 1:
     * <p>
     * Input:  [0,1,2,4,5,7]
     * Output: ["0->2","4->5","7"]
     * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
     * Example 2:
     * <p>
     * Input:  [0,2,3,4,6,8,9]
     * Output: ["0","2->4","6","8->9"]
     * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
     * <p>
     * <p>
     * тупо двумя указателями
     */
    public List<String> summaryRanges(int[] arr) {
        List<String> result = new ArrayList<>();
        if (arr.length == 0) {
            return result;
        }

        int start = arr[0];
        int end = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1] + 1) {
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }
                start = arr[i];
                end = arr[i];
            } else {
                end = arr[i];
            }
        }
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }
        return result;
    }

}
