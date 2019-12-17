package array;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 1, 1, 1, 2, 2};

        int x = removeDuplicates(arr);
        System.out.println(x);

        for (int i = 0; i < x; i++) {
            System.out.println(arr[i]);

        }

    }

    /**
     * тут работает принцип выталкивания
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     */
    static int removeDuplicates(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        //житый бежит вперед

        int i = 0;
        int j = 1;

        while (j < arr.length) {
        //как только мы поняли что жытый отличается от итого, то есть дубли закончились

            if (arr[j] != arr[i]) {
                //надо вместо как бы первого дубля
                //поствить наш житый
                //получится такой эффект пуша
                //эффект выталкивания
                i++;
                arr[i] = arr[j];
            }
            j++;
        }

        return i + 1;

    }
}
