package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    /**
     * 169.FindAllNumbersDisappearedInAnArray
     * <p>
     * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
     * <p>
     * дан массив целых чисел где каждый элемент находится в промежутке от 1 до n, некоторые элементы встречаются дважды, остальные единожды, найди все элементы в промежутке от 1 до n которые не встретились в этом массиве
     * <p>
     * Input: 				Output:
     * [4,3,2,7,8,2,3,1]     		[5,6]
     * <p>
     * n = 8
     */
    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};

        findDisappearedNumbers(arr).forEach(System.out::print);
    }

    static List<Integer> findDisappearedNumbers(int[] arr) {


        for (int i = 0; i < arr.length; i++) {
            int newIndex = Math.abs(arr[i]) - 1;

            if (arr[newIndex] > 0) {
                arr[newIndex] *= -1;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > 0) {
                res.add(i);
            }

        }
        return res;

    }
}
