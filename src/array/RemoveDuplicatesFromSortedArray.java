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

    static int removeDuplicates(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 1;

        while (j < arr.length) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
            j++;
        }

        return i + 1;

    }
}
