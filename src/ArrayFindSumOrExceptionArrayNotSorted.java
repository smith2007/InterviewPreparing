import java.util.HashMap;

public class ArrayFindSumOrExceptionArrayNotSorted {

    public static void main(String[] args) {

        int[] arr1 = {5, 3, 8, 2, 0, 1};
        int summ = 4;

        print(arr1, summ);
        //3 1

        int[] arr2 = {6, 0, 2, 9, 1, 7};
        int summ2 = 8;

        print(arr2, summ2);
        //2 6


        int[] arr3 = {6, 0, 2, 9, 1, 7};
        int summ3 = 20;

        print(arr3, summ3);

    }

    /**
     * конечно сначала приходит на ум - отсортировать и потом применить тот предыдущий линейный алгоритм
     * <p>
     * создадим фантомный набор как бы того что нам не доставало до суммы
     * где ключ будет тот самый фантомный элемент, а вот значение - это элемент в нашем массиве
     */
    static void print(int[] arr, int summ) {

        // мапа называется - что нам не хватает для суммы
        HashMap<Integer, Integer> phantomMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            if (phantomMap.containsKey(arr[i])) {
                System.out.println("Pair is " + phantomMap.get(arr[i]) + " " + arr[i]);
                return;
            }
            phantomMap.put(summ - i1, i1);
        }


        throw new RuntimeException("There is no pair for summ = " + summ);


    }

}
