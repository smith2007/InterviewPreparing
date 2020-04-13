package greedy;

import java.util.Arrays;

public class Candy {

  /**
   * We take ratings array as [5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1]
   *
   * In the given problem each student will have at least 1 candy. So distribute 1 candy to each.
   *
   *
   * ratings:     [5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1]
   * candies:     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
   *
   * Now traverse the array from left to right. If the rating of (n+1) child is greater than (n) child then set the candy of (n+1) child as one candy more than the (n) child candies.
   *
   * ratings:     [5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1]
   * candies:     [1, 2, 1, 1, 2, 3, 4, 1, 1, 1, 2, 1]
   *
   *
   * Now traverse the array from right to left. If the (n) child rating is more than (n+1) child and (n) child candies is less than one more than (n+1) child candies then update the candies of (n) child as 1+ (n+1) candies.
   *
   * ratings:     [5, 6, 2, 2, 4, 8, 9, 5, 4, 0, 5, 1]
   * candies:     [1, 2, 1, 1, 2, 3, 4, 3, 2, 1, 2, 1]
   */
  public int candy(int[] ratings) {
    int sum = 0;
    int[] candies = new int[ratings.length];
    Arrays.fill(candies, 1);

    for (int i = 0; i < ratings.length - 1; i++) {
      if (ratings[i + 1] > ratings[i]) {
        candies[i + 1] = candies[i] + 1;
      }
    }

    for (int i = ratings.length - 1; i > 0; i--) {
      if (ratings[i - 1] > ratings[i]) {
        if (candies[i - 1] < (candies[i] + 1)) {
          candies[i - 1] = candies[i] + 1;
        }
      }
    }

    for (int value : candies) {
      sum += value;
    }
    return sum;
  }
}
