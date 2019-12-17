package binary_search;

public class BinarySearchStringInArrayOfStringsWhenStringsCouldBeEmpty {

    public static void main(String[] args) {
        String[] arr = {"ant", "", "ball", "", "coach", "", "dad"};
        String key = "ant";
        int i = find(arr, key);
        System.out.println(i);
    }

    private static int find(String[] arr, String key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int middle = chooseMiddle(arr, start, end);
            if (middle == -1) {
                System.out.println("Array contains only empty strings. Nothing to binary_search.");
            }
            String middleElement = arr[middle];
            int comparingResult = key.compareToIgnoreCase(middleElement);
            if (comparingResult == 0) {
                return middle;
            } else if (comparingResult > 0) {
                start = middle + 1;
            } else if (comparingResult < 0) {
                end = middle - 1;
            }
        }
        System.out.println("Element not found");
        return -1;
    }

    private static int chooseMiddle(String[] arr, int start, int end) {
        int middle = (start + end) / 2;

        // если middle пусткая строка то найти ближашую не пустую
        // идея такая проверяем на один слева от мидла
        // и справа от мидла
        // как только нашли не пустой элемент возвращаем его
        if (arr[middle].isEmpty()) {
            int left = middle - 1;
            int right = middle + 1;

            while (true) {
                if (right <= end && !arr[right].isEmpty()) {
                    return right;
                } else if (left >= start && !arr[left].isEmpty()) {
                    return left;
                } else if (left <= start && right >= end) {
                    return -1;
                }
                right++;
                left--;
            }
        }
        return middle;
    }
}
