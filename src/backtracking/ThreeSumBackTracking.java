package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumBackTracking {

    public static void main(String[] args) {

        int[] arr = {-1, 0, 1, 2, -1, -4};

        Arrays.sort(arr);

        List<List<Integer>> lists = threeSum(arr);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(" " + integer);
            }
            System.out.println();
        }


    }

    static List<List<Integer>> threeSum(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();

        if (arr.length == 0) {
            return res;
        }

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            backtrack(arr, i, 0, temp, res);
        }

        return res;
    }


    static void backtrack(int[] arr, int start, int sum, List<Integer> temp, List<List<Integer>> res) {
        if (sum == 0 && temp.size() == 3) {
            res.add(new ArrayList<>(temp));
        } else if (temp.size() >= 3) {
            return;
        } else {
            for (int k = start; k < arr.length; k++) {
                if (k > start && arr[k] == arr[k - 1]) {
                    continue;
                }
                temp.add(arr[k]);
                backtrack(arr, k + 1, sum + arr[k], temp, res);
                temp.remove(temp.size() - 1);
            }
        }

    }
}
