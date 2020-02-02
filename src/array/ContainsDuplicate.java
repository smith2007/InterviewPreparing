package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] arr) {

        if (arr.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }

}
