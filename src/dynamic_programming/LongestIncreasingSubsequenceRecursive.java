package dynamic_programming;

public class LongestIncreasingSubsequenceRecursive {

    /**
     * паттерн - рекурсия
     * рекурсивно исследуем каждый элемент
     * исследуем какая самая длинная последовательность
     * он может представить если его взять в
     * состав предыдущей последовательности - taken
     * <p>
     * или если стартовать с него - not taken
     *
     * тупой алгоритм, брутфорсом
     */
    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21};

        System.out.println(lengthOfLIS(arr));
    }

    private static int lengthOfLIS(int[] arr) {
        return lengthofLIS(arr, Integer.MIN_VALUE, 0);
    }

    private static int lengthofLIS(int[] arr, int prevElm, int curpos) {
        if (curpos == arr.length) {
            return 0;
        }
        int taken = 0;

        //берем элемент
        int currentElm = arr[curpos];

        //смотрим больше ли он предыдущего
        if (currentElm > prevElm) {
            //если больше то он теоретически может быть
            //в хвост текущей последовательности
            // иными словами
            // спрашиваем можешь ли ты быть частью ранее описаной последовательности
            // если да, входи как бы в наш состав и давай с тобой посчитаем общую длинну
            taken = 1 + lengthofLIS(arr, currentElm, curpos + 1);
        }

        //так же проверяем какая максимальная длинна последовательности
        //может быть если бы мы плясали от него так же
        // иными словами мы говорим
        // давай в ЛЮБОМ СЛУЧАЕ посчитаем последовательность от тебя
        //малоли, теоретически ты являешься началом еще более крупной последовательности
        int nottaken = lengthofLIS(arr, prevElm, curpos + 1);
        return Math.max(taken, nottaken);
    }
}
