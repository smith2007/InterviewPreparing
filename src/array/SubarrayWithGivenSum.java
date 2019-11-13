package array;

import java.util.HashMap;

public class SubarrayWithGivenSum {

    public static void main(String[] args) {

        int positionA = 2;
        int positionB = 5;

        //26
/*
        System.out.println(summByPosition(arr, positionA, positionB));


        printPositionsBySumm(arr, 17);


        */

        int[] arr = {-19,-82,-70,-46,-29,7,15,-72,-7,100,303};

        printPositionsOfSubArraySumm(arr, 100);
    }

    static int summByPosition(int[] arr, int positionA, int positionB) {
        int summHolder = 0;
        for (int i = positionA; i <= positionB; i++) {
            summHolder += arr[i];
        }
        return summHolder;
    }

    static void printPositionsBySumm(int[] arr, int summ) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (integerIntegerHashMap.containsKey(arr[i])) {
                System.out.println("position A is " + integerIntegerHashMap.get(arr[i]) + " position B is " + i);
                return;
            } else {
                integerIntegerHashMap.put(summ - arr[i], i);
            }
        }
    }


    /*
        Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
        Ouptut: Sum found between indexes 2 and 4

        Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
        Ouptut: Sum found between indexes 1 and 4

        Input: arr[] = {1, 4}, sum = 0
        Output: No subarray found
     */
    //ну самый банальный конечно взять каждый элемент и идти по массиву
    //и считать сумму, как только нашел
    //но сложность квадратичная

    /**
     * можно идти по массиву и считать сумму, как только текущая
     * сумма превысит искомую - мы нашли конечный индекс
     * далее еще раз идем и ищем начальный индекс
     */

    static void printPositionsOfSubArraySumm(int[] arr, int summ) {
        int currSum = 0;
        int endIndex = 0;
        int startIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum == summ) {
                System.out.println("Summ = " + summ + " found between 0 and " + i + " indexes");
                return;
            } else if (currSum > summ) {
                endIndex = i;
                break;
            } else if (arr.length == i + 1) {
                System.out.println("There is no subarray for summ = " + summ);
                return;
            }
        }

        //тут уже нашли похожий интервал,
        // теперь надо потихоньку двигать слева и справа что бы понять
        // где наш искомый
        while (startIndex < arr.length) {
            currSum -= arr[startIndex];
            startIndex++;
            if (currSum == summ) {
                System.out.println("Summ = " + summ + " found between " + startIndex + " and " + endIndex + " indexes");
                return;
            } else {
                endIndex++;
                currSum += arr[endIndex];
                if (currSum == summ) {
                    System.out.println("Summ = " + summ + " found between " + startIndex + " and " + endIndex + " indexes");
                    return;
                }
            }
        }

        System.out.println("There is no sub array for given summ = " + summ);
    }
}
