package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsRecursive {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = subsets(arr);
        System.out.println(subsets);
    }

    static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(result, new ArrayList<>(), arr, 0);
        return result;
    }

    static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] arr, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < arr.length; i++) {
            tempList.add(arr[i]); // добавляй новый элемент в темповый массив
            backtrack(result, tempList, arr, i + 1); // рекурсивно сделай тоже самое для всех
            //впереди стоящих
            tempList.remove(tempList.size() - 1); // удали последний элемент из массива
                                                        // что бы учесть дырочные чейны
        }
    }
}
