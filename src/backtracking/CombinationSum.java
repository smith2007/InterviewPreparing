package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};

        System.out.println(coombination(arr, 7));
    }

    static List<List<Integer>> coombination(int[] arr, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (arr.length < 1) {
            return res;
        }

        backtrack(res, new ArrayList<>(), target, 0, arr);

        return res;

    }

    static void backtrack(List<List<Integer>> res, List<Integer> curr, int remain, int index, int[] arr) {

        if (remain == 0) {
            res.add(new ArrayList<>(curr));
        }

        if (remain < 0) {
            return;
        }

        for (int i = index; i < arr.length; i++) {
            curr.add(arr[i]);
            backtrack(res, curr, remain - arr[i], i, arr);
            curr.remove(curr.size() - 1);
        }
    }


}
