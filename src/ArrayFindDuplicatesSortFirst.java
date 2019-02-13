import java.util.Arrays;

public class ArrayFindDuplicatesSortFirst {


    public static void main(String[] args) {
        int[] array = {4, 3, 2, 1, 5, 7, 2, 2, 3, 4, 3};

        printDuplicates(array);
    }

    // все очень просто
    // я сам придумал
    // сначала сортируем массив затем сравниваем каждый элемент с предыдущим
    static void printDuplicates(int[] arr) {
        Arrays.sort(arr);

        int previous = arr[0];

        int duplicate = -1;

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];

            if (previous == curr) {
                duplicate = curr;
            } else if (duplicate != -1) {
                System.out.println("duplicate is " + duplicate);
                duplicate = -1;
            }

            previous = curr;
        }
    }
}
