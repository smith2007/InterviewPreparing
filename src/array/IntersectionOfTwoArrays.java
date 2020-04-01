package array;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {

    }

    static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }

        Set<Integer> res = new HashSet<>();

        for (int i : nums2) {
            if (set1.contains(i)) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
