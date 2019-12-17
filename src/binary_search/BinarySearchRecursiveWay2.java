package binary_search;

public class BinarySearchRecursiveWay2 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 8, 9};
        int elm = 8;
        //нужно вернуть индекс
        int search = search(arr, elm, 0, arr.length - 1);
        System.out.println("Index of elm is " + search);
    }

    // сложность по времени О(log n)
    // сложность по памяти О(log n)
    static int search(int[] arr, int elm, int startIndex, int endIndex) {

        int middleIndex = (startIndex + endIndex) / 2;

        if (arr[middleIndex] == elm) {
            return middleIndex;
        } else if (arr[middleIndex] > elm) {
            return search(arr, elm, startIndex, middleIndex - 1);
        } else if (arr[middleIndex] < elm) {
            return search(arr, elm, middleIndex + 1, endIndex);
        }

        return Integer.MAX_VALUE;

    }
}
