package stack;

import java.util.Stack;

public class Pattern132 {

  public static void main(String[] args) {
    Pattern132 ins = new Pattern132();

    int[] arr = {1,2,3,4};
    System.out.println(ins.find132pattern(arr));
  }

  /**
   * очень кстати задача похожа на FindPeakELement - главное отличие в том что
   * тут надо найти такие элементы которые могут быть разбросаны по массиву
   *
   * принцип - собрать start и mid + stack
   *
   * основная идея в том что мы будем трекать пару start и mid и искать
   * такой как бы end который удовлетворяет паттерну 1 3 2
   *
   * траверсим массив и собирем как бы пару из start и mid условно стараемся найти 1 и 3
   *
   * а затем кладем на стек и каждый новый элемент пытаемся найти такой который будет меньше чем mid
   * и больше чем start
   *
   * изначально если стек пустой - кладем новую пару в стек из нашего элемента
   *
   * если стек не пустой смотрим на то что лежит сверху
   *
   * если num < stack.peek().start, пушим новый как бы начальный интервал в стек
   */
  public boolean find132pattern(int[] nums) {
    Stack<Pair> stack = new Stack<>();
    for (int curr : nums) {
      //тут главная развилка - стек пустой или не пустой
      //если не пустой то смотрим что сверху
      if (stack.isEmpty() || curr < stack.peek().start) {
        stack.push(new Pair(curr, curr));
      } else if (curr > stack.peek().start) {
        //если наш текущий БОЛЬШЕ того что сверху лежит
        //это повод что наш текущий является новым элементом как бы интервала
        //для того что бы это проверить надо взять последний элемент со стека
        Pair last = stack.pop();
        //и смотрим на конец интервала
        //если наш текущий элемент МЕНЬШЕ чем тот максимум
        //то вот он и есть наш третий элемент последний элемент
        //который больше чем start но меньше чем end - 1 3 2 - пик такой
        if (curr < last.mid) {
          return true;
        } else {
          //если же нет, наш как бы текущий БОЛЬШЕ или равен
          //значит ставим его на место end - он будет теперь частью этого интервала
          last.mid = curr;
          //ну и надо допопать все те элементы которые как бы меньше чем новый текущий
          //потому что он как бы шире получается
          while (!stack.isEmpty() && curr >= stack.peek().mid) {
            stack.pop();
          }
          //если допопали до того что нашли элемент у которого стартовая граница меньше чем
          // наш текущий - а наш текущий это новый как бы миддл
          //тогда вот она наша троица
          // At this time, n < stack.peek().max (if stack not empty)
          if (!stack.isEmpty() && stack.peek().start < curr) {
            return true;
          }
          stack.push(last);
        }

      }
    }
    return false;
  }


  static class Pair {
    int start;
    int mid;
    public Pair(int start, int mid) {
      this.start = start;
      this.mid = mid;
    }
  }

}
