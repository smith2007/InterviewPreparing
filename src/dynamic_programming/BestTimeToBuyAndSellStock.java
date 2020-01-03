package dynamic_programming;

public class BestTimeToBuyAndSellStock {
    /**
     * дан массив [7,1,5,3,6,4] - который показывает дни когда можно
     * продавать и покупать акции, каждое значение это стоимость акции
     * необходимо вернуть пару, дата прокупки и дата продажи - когда выгоднее всего купить и продать акции
     * решение: очень классный и простой алгоритм - решаем через DP - делаем массив, делаем переменную min
     * итерируем массив и спрашиваем каждый элемент массива - А ЕСЛИ ТЫ БУДЕШЬ МАКСИМУМОМ,
     * КАКОЙ ПРОФИТ МЫ СМОЖЕМ ПОЛУЧИТЬ НА ВЫХОДЕ? ОН ЛУЧШЕ ЧЕМ ТО ЧТО МЫ ПОЛУЧИЛИ НА ПРОШЛОМ ШАГЕ?
     * - то есть тупо через минимум считаем
     * ну и все в конце возвращаем последний элемент нашего dp
     */

    static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        if (prices.length == 1) {
            return prices[0];
        }


        int[] dp = new int[prices.length];
        dp[0] = 0;

        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(prices[i] - min, dp[i - 1]);

            if (prices[i] < min) {
                min = prices[i];
            }
        }

        return dp[prices.length - 1];
    }



    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(arr));
    }

}
