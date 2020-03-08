package dynamic_programming;

public class MaximumProductSubarray {

    public static void main(String[] args) {

        int[] arr = {2, 3, -2, 4};
        System.out.println(maxProduct(arr));
    }

    /**
     * решенеи гениальное и простое мы делаем его за два прохода первый идем с начала в конец
     * и считаем умножаем вычисляем локальный максимум, второй проход идем с конца в начало
     * и считаем умножаем локальный максимум
     * <p>
     * так же у нас есть глобальный максимум который мы трекаем и обновляем тогда когда надо
     */
    static int maxProduct(int[] arr) {

        int globalMax = Integer.MIN_VALUE;

        int localProduct = 1;

        for (int num : arr) {

            localProduct *= num;

            globalMax = Math.max(localProduct, globalMax);

            //но тут надо держать в голове что если мы встретили ноль, то это не варик и нам как бы надо обнулить
            //наше произведение
            if (localProduct == 0) {
                localProduct = 1;
            }
        }

        //делаем точно такой же проход но с конца в начало
        localProduct = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            localProduct *= arr[i];

            globalMax = Math.max(localProduct, globalMax);

            if (localProduct == 0) {
                localProduct = 1;
            }
        }

        return globalMax;
    }
}
