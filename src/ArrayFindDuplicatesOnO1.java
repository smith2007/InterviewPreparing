public class ArrayFindDuplicatesOnO1 {

    public static void main(String[] args) {
        //эта штука работает только если значения в массиве ограничены значением n-1
        //вот пример где n-7, и максимальное значение в массиве равно 6

        int[] arr = {1, 2, 3, 1, 3, 6, 6};

        printDuplicates(arr);
    }

    private static void printDuplicates(int[] arr) {
        int n = arr.length;

        for (int i = 0; i <= n - 1; i++) {
            int index = arr[i] % n; // используем mod - остаток от деления
            arr[index] = arr[index] + n;
        }

        for (int i = 0; i <= n - 1; i++) {
            if ((arr[i] / n) > 1) // используем div - целочисленное деление
                System.out.println(i + " ");
        }
    }
}
