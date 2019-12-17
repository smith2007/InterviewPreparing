package binary_search;

public class BinarySearchIterativeWay2 {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 9};
        int elm = 8;

        System.out.println("Searching elm index = " + search(arr, elm));
    }

    // основная идея - делим массив пополам,
    // далее берем элемент если больше чем искомый идем вправо если меньше - идем влево

    // сложность по времени О(log n)
    // сложность по памяти О(1)
    static int search(int[] arr, int elm) {

        int startIndex = 0;
        int endIndex = arr.length;
        for (int i = startIndex; i < endIndex; i++) {
            int middleIndex = (startIndex + endIndex) / 2;

            if (arr[middleIndex] == elm) {
                return middleIndex;
            } else if (arr[middleIndex] < elm) {
                startIndex = middleIndex + 1;
            } else if (arr[middleIndex] > elm) {
                endIndex = middleIndex - 1;
            }
        }
        return Integer.MAX_VALUE;
    }
}
