package string;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> lists = permute(arr);
        for (List<Integer> integers : lists) {
            for (Integer integer : integers) {
                System.out.print(" " + integer);
            }
            System.out.println();
        }

    }

    static List<List<Integer>> permute(int[] arr) {
        if (arr.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();


        fillIn(res, new ArrayList<>(), arr, new boolean[arr.length]);

        return res;
    }


    static void fillIn(List<List<Integer>> res, List<Integer> temp, int[] arr, boolean[] used) {

        if (temp.size() == arr.length) {
            res.add(temp);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) {
                continue;
            }


            ArrayList<Integer> local = new ArrayList<>(temp);
            used[i] = true;
            local.add(arr[i]);

            fillIn(res, local, arr, used);

            used[i] = false;
        }
    }


}
