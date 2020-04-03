package backtracking;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

  public static void main(String[] args) {
    TargetSum targetSum = new TargetSum();
    int[] arr = {1, 1, 1, 1, 1};
    int targetSumWays = targetSum.findTargetSumWays(arr, 3);
    System.out.println(targetSumWays);
  }

  Map<String, Integer> map = new HashMap<>();

  public int findTargetSumWays(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    return dive(nums, 0, 0, target);
  }

  //будем мемоизировать текущий индекс и то к какому кол-ву вариантов он приведет
  private int dive(int[] nums, int currIndex, int currSubSum, int target) {

    //ключ будем хранить в виде ТЕКУЩИЙ_ИНДЕКС:ТЕКУЩАЯ_ПОДСУММА
    //значение - это то кол-во вариантов что бы представить нашу подстроку
    String key = currIndex + ":" + currSubSum;
    if (map.containsKey(key)) {
      return map.get(key);
    }

    //дошли до конца?
    if (currIndex == nums.length) {
      //возвращаем +1 вариант
      if (currSubSum == target) {
        return 1;
      } else {
        //таргет не равен текущей под сумме - не вариант
        return 0;
      }
    }

    int curElm = nums[currIndex];

    int addRes = dive(nums, currIndex + 1, currSubSum - curElm, target);
    int minusRes = dive(nums, currIndex + 1, currSubSum + curElm, target);

    //в мапу будем складывать именно пару -> путь и то к скольки результатам он приведет
    map.put(key, addRes + minusRes);
    return addRes + minusRes;
  }

}
