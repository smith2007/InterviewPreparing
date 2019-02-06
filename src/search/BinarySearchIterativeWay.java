package search;

public class BinarySearchIterativeWay {

    private static int search(int[] array, int element) {
        int index = Integer.MAX_VALUE;
        int lowIndex = 0;
        int highIndex = array.length - 1;
        while (lowIndex <= highIndex) {
            int mid = (lowIndex + highIndex) / 2;
            if (array[mid] < element) {
                lowIndex = mid + 1;
            } else if (array[mid] > element) {
                highIndex = mid - 1;
            } else if (array[mid] == element) {
                index = mid;
                break;
            }
        }
        return index;
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int el = 5;

        int index = BinarySearchIterativeWay.search(arr, el);

        System.out.println("Searching element has an " + index + " index");

    }
}
