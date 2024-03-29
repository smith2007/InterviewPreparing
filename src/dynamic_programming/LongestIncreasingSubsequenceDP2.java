package dynamic_programming;

public class LongestIncreasingSubsequenceDP2 {

    public static void main(String[] args) {

        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLIS(arr));
    }

    /**
     * в чем суть - есть массив чисел и надо найти наиболее длинную возрастающую последовательность чисел с учетом разрывов в массиве
     *
     * {10, 22, 9, 33, 21, 50, 41, 60, 80} - максимальная длинна 6: 10-22-33-50-60-80
     *
     * с наскока решить не удалось, решил со второго раза за квадратичную сложность
     *
     * квадратичное решение :
     *
     * через динамическое программирование и два указателя, цикл в цикле, мы будем спрашивать каждый
     * сзади стоящий элемент а можешь ли ты стать моим элементом последовательности?
     *
     * два цикла и и жы
     *
     * тут принцип итый указатель бежит вперед а жытий за ним итый как бы говорит - если я arr[i] конец
     * чейна сколько элементов будет мой чейн
     * соответственно j=0; j<i жытый бежит до итого каждую итерацию и набирает как бы локальный максимум
     * выбирая его через
     *
     * localMax = Math.max(localMax, dp[i]) - то есть что больше? я локальный максимум или то что было на предыдущем шаге
     *
     * в конце надо зафиксировать новый dp[i] = localMax+1
     * ну и проапдейтить глобальный максимум если нужно max = Math.max(localMax, dp[i])
     */
    static int lengthOfLIS(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = 1;

        for (int i = 1; i < arr.length; i++) {

            int localMaxForCurrI = 0;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    //берем только те которые меньше чем итый
                    //что длиннее текущий локальный максимум
                    //или состав нового чейна?
                    localMaxForCurrI = Math.max(localMaxForCurrI, dp[j]);
                }
            }

            dp[i] = localMaxForCurrI + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
