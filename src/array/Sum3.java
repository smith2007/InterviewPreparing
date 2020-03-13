package array;

import java.util.*;

public class Sum3 {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, 4};

        List<List<Integer>> x = threeSum(arr);

        for (List<Integer> list : x) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

    static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums == null) {

            return res;
        }


        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                int first = nums[i];
                int second = nums[j];
                int third = 0 - first - second;

                if (map.containsKey(third) && map.get(third) > j) {
                    res.add(Arrays.asList(first, second, third));
                    j = map.get(nums[j]);
                }

                i = map.get(nums[i]);
            }
        }

        return res;
    }
}
