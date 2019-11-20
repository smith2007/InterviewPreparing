package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};

        System.out.println(permuteUnique(arr));
    }

    static List<List<Integer>> permuteUnique(int[] arr) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);

        if (arr.length == 0) {
            return res;
        }

        boolean[] used = new boolean[arr.length];
        backtrack(res, arr, new ArrayList<>(), used);
        return res;

    }

    static void backtrack(List<List<Integer>> res, int[] arr, List<Integer> curr, boolean[] used) {
        if (curr.size() == arr.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i] || (i > 0 && arr[i] == arr[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            curr.add(arr[i]);
            backtrack(res, arr, curr, used);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}
