package array;

public class ThreeArraysCountAllIncreasingTreplete {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};

        int[] b = {4, 5, 6};

        int[] c = {7, 8, 9};

        //a[i] < b[j] < c[k]

        System.out.println(find(a, b, c));
    }

    static int find(int[] a, int[] b, int[] c) {

        int count = 0;

        for (int elmb : b) {
            int less = binarySearch(a, elmb, true);
            int greater = binarySearch(c, elmb, false);
            count = count + (less * greater);
        }

        return count;
    }

    //причем бинарный поиск должен возвращать тебе
    //кол-во элементов которое надо вернуть

    static int binarySearch(int[] arr, int elm, boolean isLess) {

        int startIndex = 0;
        int endIndex = arr.length - 1;
        int midIndex = 0;

        while (startIndex <= endIndex) {
            midIndex = (startIndex + endIndex) / 2;
            if (arr[midIndex] == elm) {
                if (isLess) {
                    return midIndex;
                } else {
                    return endIndex - midIndex;
                }
            } else if (arr[midIndex] < elm) {
                startIndex = midIndex + 1;
            } else if (arr[midIndex] > elm) {
                endIndex = midIndex - 1;
            }
        }

        if (isLess) {
            return midIndex + 1;
        } else {
            return arr.length - midIndex;
        }
    }
}
