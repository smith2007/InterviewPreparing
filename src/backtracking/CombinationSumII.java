package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    /**
     * тут тоже самое только не надо перепосылать тот же самый индекс
     * в рекурсивной бэктрекинговом методе, надо пересылать всегда i+1 то есть следующий элемент
     */
    static List<List<Integer>> combinationSum2(int[] arr, int target) {
        if (arr.length == 0) {
            return null;
        }
        Arrays.sort(arr);

        ArrayList<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), arr, target, 0);
        return res;
    }

    static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] arr, int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < arr.length; i++) {
                if (i > start && arr[i] == arr[i - 1]) {
                    continue;
                }
                temp.add(arr[i]);
                backtrack(res, temp, arr, remain - arr[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        // int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(combinationSum2(arr, 8));

    }

}
