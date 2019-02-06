package search;

public class BinarySearchRecursiveWay {

    private static int search(int[] array, int element, int lowIndex, int highIndex) {

        int mid = (lowIndex + highIndex) / 2;
        if (array[mid] < element) {
            return search(array, element, lowIndex + 1, highIndex);
        } else if (array[mid] > element) {
            return search(array, element, lowIndex, highIndex + 1);
        }
        if (array[mid] == element) {
            return mid;
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 8, 12, 23, 45, 55};
        int element = 23;
        System.out.println("Searching element has an index = "
                + search(array, element, 0, array.length - 1));
    }
}
