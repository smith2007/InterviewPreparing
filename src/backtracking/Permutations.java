package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    /**
     * используем рекурсию, подумай блять башкой как это сделать,
     * надо крутится в цикле и набивать массив, так же надо трекать каждый
     * из уже просмотренных вариантов что бы они не печатались,
     * для этого можно использовать сэт а еще лучше массив булеанов
     */

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


        backtrack(res, new ArrayList<>(), arr, new boolean[arr.length]);

        return res;
    }


    static void backtrack(List<List<Integer>> res, List<Integer> curr, int[] arr, boolean[] used) {

        if (curr.size() == arr.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            curr.add(arr[i]);

            backtrack(res, curr, arr, used);

            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }


}
