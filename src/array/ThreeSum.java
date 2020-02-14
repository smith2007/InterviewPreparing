package array;

import java.util.HashSet;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int sum = 22;

        find3Numbers(arr, sum);
    }

    // returns true if there is triplet
    // with sum equal to 'sum'
    // in arr[]. Also, prints the tripletpresent
    static boolean find3Numbers(int[] arr, int sum) {

        // Fix the first element as arr[i]

        //начинаем с элемента a[i]
        //будем искать есть ли два элемента
        //в остальном массиве которые дадут сумму = sum - a[i]
        //то есть надо найти пару
        for (int i = 0; i < arr.length - 2; i++) {

            // Find pair in subarray arr[i+1..n-1]
            // with sum equal to sum - arr[i]
            HashSet<Integer> set = new HashSet<>();

            //фиксируем ту самую искому сумму двух элементов
            int currSum = sum - arr[i];

            for (int j = i + 1; j < arr.length; j++) {

                if (set.contains(currSum - arr[j]) && currSum - arr[j] != (int) set.toArray()[set.size() - 1] ) {

                    System.out.printf("Triplet is %d, %d, %d", arr[i],
                            arr[j], currSum - arr[j]);
                    return true;
                }
                set.add(arr[j]);
            }
        }

        // если достигли этой точки, значит нет такого триплета
        return false;
    }


}
