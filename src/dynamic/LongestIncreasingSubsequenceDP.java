package dynamic;


public class LongestIncreasingSubsequenceDP {

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};

        System.out.println(lis(arr));

    }

    /**
     * сложность по времени O(n^2) - двойной цикл
     * сложность по памяти O(n) - доп массив
     *
     */
    static int lis(int[] arr) {
        int n = arr.length;

        int[] temp = new int[n];

        int max = 0;

        /*
          заполняем временный массив единицами
          туда будем записывать длины цепочек
         */
        for (int i = 0; i < n; i++) {
            temp[i] = 1;
        }

        /*
          запускаем двойной цикл по двум переменным i и j
          i чуть впереди, j ее будет догонять

          и суть такая - ты как бы задаешь вопрос каждом сзадистоящиему за i
          элементу : ты (сзадистоящий j-ый элемент) меньше меня? если да ты можешь быть в составе моего чейна
          сколько максимально в составе твоего (сзади стоящего j-го элемента может) чейна может быть элементов
          дай мне эту сумму я сохраню ее в для потомков (следующих итераций) в темп массив

          и так далее следующий за следующим
         */
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int elmi = arr[i];
                int elmj = arr[j];
                int tempi = temp[i];
                int tempj = temp[j];

                if (elmi > elmj && tempi < tempj + 1) {
                    temp[i] = tempj + 1;
                }
            }
        }

        /* потом просто берешь максимум */
        for (int i = 0; i < n; i++) {
            if (max < temp[i]) {
                max = temp[i];
            }
        }

        return max;
    }

}
