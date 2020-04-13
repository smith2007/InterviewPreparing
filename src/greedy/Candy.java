package greedy;

public class Candy {

  /**
   * To use two variables 'up' and 'down' to count the steps of continuous up and down respectively, and a 'peak' representing the peak before going down. In the below example:
   *
   * [0, 1, 20, 9, 8, 7]
   *
   * Scan from left to right, first child is given 1 candy;
   * the second child is given 2 candies, and up=1;
   * the third child is given 3 candies, and up=2; peak=2;
   * the fourth child is given 1 candy, and down=1; and third child still has 3 candies since peak=2;
   * the fifth child is given 1 candy, and down=2; and the previous child needs 1 more candy now but the third child no need more;
   * the sixth child is given 1 candy, and down=3; and both the fifth and fourth child needs 1 more candy now, and the peak, the third child need 1 more as well.
   */
  public int candy(int[] ratings) {
    if (ratings.length == 0) {
      return 0;
    }

    int ret = 1;
    int up = 0;
    int down = 0;
    int peak = 0;

    for (int i = 1; i < ratings.length; i++) {
      // if rising, then update up/peak and clear down
      if (ratings[i - 1] < ratings[i]) {
        peak = ++up;
        down = 0;
        ret += 1 + up;
      } else if (ratings[i - 1] == ratings[i]) { //if equal, then add 1 and clear up/down/peak
        peak = up = down = 0;
        ret += 1;
      } else { //if declining, then update down and clear up
        up = 0;
        down++;
        if (peak >= down) { //if peak is not large enough, then we need to make peak larger
          //add some explain about peak >= down ? -1:0

          //when peak >= down, the candy for the peak still don't need to change.
          //
          //For example, [0, 1, 20, 9, 8, 7], for the first 5 number, we need to assign [1,2,3,2,1] candies.
          //But when 7 comes up, we need to raise the value of the peak, which is 3 above, it need to be 4, [1,2,4,3,2,1]
          //This solution here, make it to be [1,2,3,1,2,4], the sum are same. Really brilliant.
          ret += 1 + down + -1;
        } else {
          ret += 1 + down;
        }
      }
    }

    return ret;
  }
}
