package array;

import java.util.HashMap;

public class TwoSumArrayNotSorted {

    public static void main(String[] args) {

        int[] arr1 = {5, 3, 8, 2, 0, 1};
        int summ = 4;

        //print(arr1, summ);
        //3 1


        int[] arr2 = {6, 0, 2, 9, 6, 6, 1, 7};
        int summ2 = 12;

        print(arr2, summ2);
        //2 6


/*
        int[] arr2 = {6, 0, 2, 9, 1, 7};
        int summ2 = 8;

        print(arr2, summ2);
        //2 6


        int[] arr3 = {6, 0, 2, 9, 1, 7};
        int summ3 = 20;

        print(arr3, summ3);*/

    }

    /**
     * конечно сначала приходит на ум - отсортировать и потом применить тот предыдущий линейный алгоритм
     * <p>
     * создадим фантомный набор как бы того что нам не доставало до суммы
     * где ключ будет тот самый фантомный элемент, а вот значение - это элемент в нашем массиве
     */
    static void print(int[] arr, int sum) {

        // мапа называется - что нам не хватает для суммы
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                Integer secondIndex = map.get(arr[i]);
                System.out.println("Indexes are : first " + i + " second = " + secondIndex);
                return;
            } else {
                Integer phantomSum = sum - arr[i];
                map.put(phantomSum, i);
            }
        }


        throw new RuntimeException("There is no pair for summ = " + sum);


    }

}
