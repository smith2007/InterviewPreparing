package binary_search;

public class FindTheDuplicateNumberLoop {

    /**
     * казалось бы простая задача - дан массив не отсортированный
     * там все элементы уникальны кроме одного - найти задублированный элемент массив
     */
    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
        System.out.println(findDuplicate(arr));
    }

    static int findDuplicate(int[] arr) {
        if (arr.length > 1) {

            // initialize fast and slow
            int slow = arr[0];
            int fast = arr[arr[0]];

            // loop to enter in the cycle
            while (fast != slow) {// move one step for slow
                slow = arr[slow];
                // move two step for fast
                fast = arr[arr[fast]];
            }
            //как только быстрый равен медленному - все мы нашли цикл
            // закончен ли на этом наш алгоритм?
            //нет
            fast = 0;

            while (slow != fast) {
                fast = arr[fast];
                slow = arr[slow];
            }

            return slow;
        }
        return -1;
    }
}
