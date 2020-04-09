package dynamic_programming;

public class BestTimetoBuyandSellStockIII {

  /**
   * The maximum of if we've just buy 1st stock, if we've just sold 1nd stock,
   * if we've just buy 2nd stock, if we've just sold 2nd stock.
   *
   * Very simple code too and work well. I have to say the logic is simple than those in Single Number II.
   *
   * мы считаем нашу гипотетическую прибыль
   * и наши деньги на руках
   */
  public int maxProfit(int[] prices) {
    int holdAmount1 = Integer.MIN_VALUE;
    int holdAmount2 = Integer.MIN_VALUE;
    //у нас 0 денег типа
    int profit1 = 0;
    int profit2 = 0;
    // Assume we only have 0 money at first
    for(int newStock:prices){

      //The maximum if we've just sold 2nd stock so far.
      //какая будет прибыль если мы продадим новую акцию как вторую
      profit2 = Math.max(profit2, holdAmount2+newStock);

      // The maximum if we've just buy  2nd stock so far.
      //кол-во денег на руках если мы купим акцию
      holdAmount2    = Math.max(holdAmount2,    profit1-newStock);

      // The maximum if we've just sold 1nd stock so far.
      //предыдущее занчение с новым значением
      profit1 = Math.max(profit1, holdAmount1+newStock);

      // The maximum if we've just buy  1st stock so far.
      holdAmount1    = Math.max(holdAmount1,    -newStock);
    }
    return profit2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
  }
}
