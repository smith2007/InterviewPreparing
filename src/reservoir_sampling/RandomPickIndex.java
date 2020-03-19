package reservoir_sampling;

import java.util.Random;

public class RandomPickIndex {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 3, 3};
    RandomPickIndex randomPickIndex = new RandomPickIndex(nums);
    System.out.println(randomPickIndex.pick(3));
  }

  int[] nums;
  Random random;

  public RandomPickIndex(int[] nums) {
    this.nums = nums;
    this.random = new Random();
  }

  //алгоритм на самом деле выглядит тупо
  //вспоминаем видос со шляпами и конвеером
  public int pick(int target) {
    int result = -1;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      int currElm = nums[i];
      if (currElm != target) {
        continue;
      }

      /**
       * мы траверсим наш массив и каждый раз когда мы натыкаемся на наш таргет
       * мы подбрасываем монетку а точнее будет сказать раскручиваем барабан удачи
       * - запоминать ли его или нет
       */
      count++;
      int nextRandom = random.nextInt(count);
      // а как понять что барабан выдаст сигнал о том что надо запоминать???
      if (nextRandom == 0) {
        //ну например можно сделать так что бы был некий каунтер который мы инкрементим
        // и каждый раз мы результат рандома сравниваем с нулем!  и если равен == 0 то заменяем
        result = i;
      }
    }

    return result;
  }

}
