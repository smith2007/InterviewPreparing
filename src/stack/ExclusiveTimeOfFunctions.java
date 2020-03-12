package stack;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

  public static void main(String[] args) {

    int[] ints = exclusiveTime(1,
        List.of("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"));
    for (int anInt : ints) {
      System.out.println(anInt);
    }

  }

  /**
   * Input: n = 2 logs = ["0:start:0","1:start:2","1:end:5","0:end:6"] Output: [3, 4]
   * <p>
   * итак у нас есть две операции start и end операции могут прерываться
   * <p>
   * тут задача решается через стек через два указателя curr и prev, что мы кладем на стек?? -
   * кладем на стек мы АЙДИШНИКИ операций старта и только их.
   * <p>
   * общая идея какая мы будем постепенно в массив резов накладывать то время которое прошел
   * процесс, если мы встретили что процесс прерывается и снова запускается - то это значит что мы
   * вернем в ту ячейку из реза, найдем ее согласно айдишнику и возьмем что мы там уже ранее
   * положили и сложим с тем что есть
   * <p>
   * итак начинается все с раскрутки цикла int[] res = new int[n]; - перед раскруткой цикла сразу
   * заготовим массив резов потому что в его ячейки согласно айдишнику операции мы будем класть
   * значения
   * <p>
   * <p>
   * раскручивать цикл будем со второй строчки лога, зафиксировав первую как prev и положив на стек
   * айдишник (а первая строчка - это сто процентов строчка старта) ну и в цикле берем каррент,
   * сплитим его - если это операция start то берем у нее время далее смотрим на стек, а стек не
   * пустой??
   * <p>
   * если в стеке до этого была какая-то операция не закрытая, предыдущая, то нам надо взять
   * айдишник этой не закрытой операции через peek и проапдейтить как бы ячейку с прерыдущим
   * значением if (!stack.isEmpty()) { res[stack.peek()] += currTime - prevTime; }
   * <p>
   * так же принимая во внимая что наш каррент это старт операция - мы пушим в стек этот каррент,
   * предыдущий мы не закрываем, не попаем, потому что еще раз имеем дело со старт операцией ну и
   * обновляем предыдущий - prevTime = Integer.parseInt(curr[2]);
   * <p>
   * <p>
   * так а вот теперь что делать если мы наткнулись на операцию end а тут все просто - если операция
   * end то на стеке сверху обязательно лежит операция этого энда - вывод попаем со стека наш старт
   * и обновляем согласно этому попнутому айдишнику в ячейке занчение затраченного времени
   * <p>
   * res[lastStartProcessId] += Integer.parseInt(curr[2]) - prevTime + 1;
   * <p>
   * ну и фиксируем предыдущее время как и в случае со start операцией
   * <p>
   * prevTime = Integer.parseInt(curr[2]) + 1;
   */
  static int[] exclusiveTime(int n, List<String> logs) {

    Stack<Integer> stack = new Stack<>();
    int[] res = new int[n];

    String[] curr = logs.get(0).split(":");

    //в стек пушим айдишники
    //и пушить будем только start операции
    stack.push(Integer.parseInt(curr[0]));

    // раскручивать цикл будем со второго элемента по этому
    //текущее время фиксируем как предыдущее
    int prevTime = Integer.parseInt(curr[2]);

    int i = 1;

    //раскручиваем цикл по нашим строчкам логов
    while (i < logs.size()) {

      //берем каррент
      curr = logs.get(i).split(":");

      //если это операция старта
      String currTask = curr[1];
      if (currTask.equals("start")) {

        int currTime = Integer.parseInt(curr[2]);

        //если в стеке до этого была какая-то операция не закрытая,
        // предыдущая, то нам надо взять айдишник этой не закрытой операции через peek
        if (!stack.isEmpty()) {
          res[stack.peek()] += currTime - prevTime;
        }

        //так же пушим в стек новый старт
        stack.push(Integer.parseInt(curr[0]));

        //и запоминаем текущее время как предыдущее
        prevTime = Integer.parseInt(curr[2]);
      } else {
        //если же это операция end то на стеке по любому чтото есть
        // надо взять этот последний элемени и посчитать разницу и положить в рез массив
        Integer lastStartProcessId = stack.pop();
        res[lastStartProcessId] += Integer.parseInt(curr[2]) - prevTime + 1;
        //все закрыли эту операцию надо попнуть из стека

        //и запомнить предыдущее время для потомков
        prevTime = Integer.parseInt(curr[2]) + 1;
      }

      i++;
    }
    return res;

  }
}
