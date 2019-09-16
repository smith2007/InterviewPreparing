package array;

public class MaxSubarray {

    public static void main(String[] args) {
        int[] arr = {-1};
        System.out.println(find(arr));
    }

    /**
     * по факту тебе надо умно считать сумму элементов массива,
     * что может негативно сказаться на твоей сумме??
     * правильно только отрицательные элементы,
     * как только ты встретил что твой локальный максимум обратился в отрицательный,
     * сбрасывай его, нахер он нужен лучше, начинаем как бы отсчет сначала,
     * потом есть глобальный максимум если он меньше локального присвой значение локального глобальному
     */
    static int find(int[] arr) {
        int globalMaximum = Integer.MIN_VALUE;
        int localMaximum = 0;

        for (int elm : arr) {

            //считаем локальный максимум, каждый раз плюсуя элементы
            localMaximum += elm;

            //сравниваем, а эта сумма больше глобального максимума
            if (globalMaximum < localMaximum) {
                globalMaximum = localMaximum;
            }

            //если же локальный максимум отрицательный,
            //пробуем его обнулить, потому что он негативно влияет на сумму
            if (localMaximum < 0) {
                localMaximum = 0;
            }
        }
        return globalMaximum;
    }
}
