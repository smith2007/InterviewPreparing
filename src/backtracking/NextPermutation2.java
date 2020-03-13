package backtracking;

import java.util.Arrays;

public class NextPermutation2 {

    public static void main(String[] args) {
        int[] arr = {1,3,2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * это более простая версия тут мы просто идем и ищем элемент который нарушает убывающий порядок
     */
    static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        //ищем элемент который нарушает убывающий порядок
        //если нашли - то есть мы не дошли до конца
        //то ищем индексы
        if (i >= 0) {
            //опять идем с конца и ищем элемент который больше либо равен нашему итому
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            //как только нашли свопаем элементы
            swap(nums, i, j);
        }
        //и в конце реверсим последнюю часть массива
        reverse(nums, i + 1);
    }

    static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
