package binary_search;

public class MedianOfTwoSortedArrays {


    /**
     * тут задача вот в чем, дано два массива
     * <p>
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * необходимо найти медиану между ними - такое число которое ровно больше левой половины и ровно больше второй половины двух этих СМЕРЖЕННЫХ массивов, смерженный массив выглядит так 1 2 3 4 - медиана это между 2 и 3 - а именно 2.5
     * <p>
     * решение
     * <p>
     * конечно - самый простой вариант это смержить два этих сортированных массива и взять ровно середину, это займет О(m+n) - это брут форс
     * <p>
     * хорошее решение приходит за время О(log(m+n))
     */
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 6, 7, 8};

        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int arr1Size = arr1.length;
        int arr2Size = arr2.length;
        // the following call is to make sure len(A) <= len(B).
        // yes, it calls itself, but at most once, shouldn't be
        // consider a recursive solution
        if (arr1Size > arr2Size) {
            return findMedianSortedArrays(arr2, arr1);
        }

        // now, do binary search
        int k = (arr1Size + arr2Size - 1) / 2;

        int left = 0;
        int right = Math.min(k, arr1Size); // r is n, NOT n-1, this is important!!
        while (left < right) {
            int midA = (left + right) / 2;
            int midB = k - midA;
            if (arr1[midA] < arr2[midB]) {
                left = midA + 1;
            } else {
                right = midA;
            }
        }

        // after binary search, we almost get the median because it must be between
        // these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1]

        // if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
        // and there are some corner cases we need to take care of.
        int a1 = left > 0 ? arr1[left - 1] : Integer.MIN_VALUE;
        int a2 = k - left >= 0 ? arr2[k - left] : Integer.MIN_VALUE;
        int a = Math.max(a1, a2);
        if (((arr1Size + arr2Size) & 1) == 1){
            return (double) a;
        }

        // if (n+m) is even, the median can be calculated by
        // median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
        // also, there are some corner cases to take care of.
        int b1 = left < arr1Size ? arr1[left] : Integer.MAX_VALUE;
        int b2 = k - left + 1 < arr2Size ? arr2[k - left + 1] : Integer.MAX_VALUE;
        int b = Math.min(b1, b2);
        return (a + b) / 2.0;
    }

}
