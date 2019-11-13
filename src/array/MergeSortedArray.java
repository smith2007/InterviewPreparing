package array;

public class MergeSortedArray {


    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};

        merge(arr1, 3, arr2, 3);

        for (int i : arr1) {
            System.out.println(i);
        }

    }

    static void merge(int[] arr1, int m, int[] arr2, int n) {

        /*

        nums1 = [1,5,7,0,0,0], m = 3
        nums2 = [3,4,6],       n = 3

        */
        int k = arr1.length - 1;
        int j = arr2.length - 1;

        int i = m - 1;

        while (k != m - 1) {

            if (arr1[i] > arr2[j]) {
                arr1[k] = arr1[i];
                arr1[i] = 0;
                i--;
            } else {
                arr1[k] = arr2[j];
                arr2[j] = 0;
                j--;
            }
            k--;
        }

        for (int l1 = 0, l2 = 0; l1 < arr1.length; l1++) {
            if (arr1[l1] == 0) {
                arr1[l1] = arr2[l2];
                l2++;
            }
        }
    }
}
