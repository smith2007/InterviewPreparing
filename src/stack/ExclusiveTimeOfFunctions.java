package stack;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

    public static void main(String[] args) {

        int[] ints = exclusiveTime(1, List.of("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"));
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

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

            //бере каррент
            curr = logs.get(i).split(":");

            //если это операция старта
            String currTask = curr[1];
            if (currTask.equals("start")) {

                int currTime = Integer.parseInt(curr[2]);

                //смотрим в стек
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
                res[stack.peek()] += Integer.parseInt(curr[2]) - prevTime + 1;
                //все закрыли эту операцию надо попнуть из стека
                stack.pop();
                //и запомнить предыдущее время для потомков
                prevTime = Integer.parseInt(curr[2]) + 1;
            }

            i++;
        }
        return res;

    }
}
