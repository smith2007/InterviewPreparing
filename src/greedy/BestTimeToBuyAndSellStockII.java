package greedy;

public class BestTimeToBuyAndSellStockII {

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
     * <p>
     * тут тупо greedy алгоритм как только цена покупки больше цены продажи продаем то есть суммируем total+=arr[i+1]-arr[i];
     */
    public static void main(String[] args) {

    }

    public int maxProfit(int[] arr) {

        int total = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                total += arr[i + 1] - arr[i];
            }
        }

        return total;
    }
}
