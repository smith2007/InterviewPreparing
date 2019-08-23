public class TwoSumArraySorted2 {


    public static void main(String[] args) {

        int[] arr1 = {1, 4, 7, 9, 10};

        int summ = 16;

        print(arr1, summ);
        // 2 3


    }

    /**
     * например есть массив int[] arr1 = {1, 4, 7, 9, 10};
     * надо найти сумму например = 16
     * первый подход такой, берем самый левый и самый правый элементы
     * и шаг за шагом проверяем как меняется
     * если все еще не хватает то двигаем левый индекс
     * если больше чем надо двигаем правый индекс
     *
     * сложность по времени О(n)
     * сложность по памяти О(1)
     */
    static void print(int[] arr, int sum) {

        int start = 0;
        int end = arr.length - 1;

        if (end < 0) {
            return;
        }

        while (start < end) {
            int tempSum = arr[start] + arr[end];

            if (tempSum == sum) {
                System.out.println("Indexes are: start = " + start + " end = " + end);
                return;
            } else if (tempSum < sum) {
                start++;
            } else if (tempSum > sum) {
                end--;
            }
        }

        System.out.println("There are no elements for sum = " + sum);


    }
}
