package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class BestTimetoBuyandSellStockIV {

    /**
     * Say you have an array for which the i-th element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit. You may complete at most k transactions.
     *
     * Note:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     *
     * Example 1:
     *
     * Input: [2,4,1], k = 2
     * Output: 2
     * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
     * Example 2:
     *
     * Input: [3,2,6,5,0,3], k = 2
     * Output: 7
     * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
     *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
     */

    Map<String, Integer> map = new HashMap<>();

    public int maxProfit(int k, int[] p) {
        int res=0;

        //Below is to avoid TLE.
        if(k > p.length/2) {
            for(int i = 1; i < p.length; i++) if(p[i] > p[i-1]) res += p[i]-p[i-1];
            return res;
        }

        //real code start here.
        return maxProfit(p, 0,   k, k);
    }

    public int maxProfit(int[] prices, int i, int buy, int sell) {
        String key = i+""+buy+""+sell;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int profit = 0;
        if(buy > sell || buy < 0 || i == prices.length) {
            map.put(key, 0);
            return 0;
        }

        if(buy==sell) {
            profit =  Math.max(maxProfit(prices, i+1, buy-1, sell)-prices[i],
                    maxProfit(prices, i+1,  buy, sell));

        }
        else {
            profit = Math.max(prices[i]+maxProfit(prices, i+1, buy, sell-1),
                    maxProfit(prices, i+1, buy, sell));
        }
        map.put(key, profit);
        return profit;

    }


    /**
     *
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/449097/Java-O(kn)-with-explanation
     *
     *
     * public int maxProfit(int k, int[] prices) {
     *         if(prices.length <= 1 || k == 0) return 0;
     *         if(2*k >= prices.length) return unlimitedTrans(prices);
     *         int[] buy = new int[prices.length];
     *         int[] sell = new int[prices.length];
     *         int maxProfit = Integer.MIN_VALUE;
     *
     *         for(int t = 1; t < k + 1; t++) {
     *             // Update buy
     *             int maxPreSell = sell[0];
     *             for(int i = 0; i < prices.length; i++) {
     *                 buy[i] = i == 0 ? prices[i] * (-1) : maxPreSell - prices[i];
     *                 maxPreSell = Math.max(maxPreSell, sell[i]);
     *             }
     *             // Update sell
     *             int maxCurrBuy = buy[0];
     *             for(int i = 0; i < prices.length; i++) {
     *                 sell[i] = i == 0 ? 0 : maxCurrBuy + prices[i];
     *                 maxCurrBuy = Math.max(maxCurrBuy, buy[i]);
     *                 maxProfit = Math.max(maxProfit, sell[i]);
     *             }
     *         }
     *
     *         return maxProfit;
     *     }
     *     public int unlimitedTrans(int[] prices) {
     *         int maxProfit = 0;
     *         for(int i = 1; i < prices.length; i++) {
     *             maxProfit += Math.max(0, prices[i] - prices[i - 1]);
     *         }
     *         return maxProfit;
     *     }
     */
}
