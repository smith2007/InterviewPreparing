package backtracking;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators2 {

    public static void main(String[] args) {

        List<String> strings = addOperators("232", 8);
        for (String string : strings) {
            System.out.println(string);
        }


    }

    static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        dive(res, "", num, target, 0, 0, 0);
        return res;
    }

    static void dive(List<String> res, String currStr, String num, int target, int index, long eval, long multed) {

        if (index == num.length()) {
            if (target == eval) {
                res.add(currStr);

            }
        } else {
            for (int i = index; i < num.length(); i++) {
                if (i != index && num.charAt(index) == '0') {
                    break;
                }
                // все манипуляции делаем строго с лонгом так как возомжно переполнение инта
                long cur = Long.parseLong(num.substring(index, i + 1));
                //если это самое начало эпопеии то просто
                if (index == 0) {
                    dive(res, currStr + cur, num, target, i + 1, cur, cur);
                } else {
                    dive(res, currStr + "+" + cur, num, target, i + 1, eval + cur, 1 * cur);
                    dive(res, currStr + "-" + cur, num, target, i + 1, eval - cur, -1 * cur);
                    //самое хитрое тут что при проверки умножение надо трекать какая сумма получится у нас в случае если умножение
                    //разберем кейс например строка 232 и таргет 8
                    //на выходе надо получить 2*3+2 и 2+3*2
                    //для этого будем передавать то что у нас получилось при умножении как бы, не зависимо от того какой сейчас знак текущий плюс или минус
                    //и нашу обычное как бы выражение в виде переменной eval
                    //а в случае повторного вызова - рекурсивного умножения мы будем делать финт ушами в виде
                    //ВЫЧИТАНИЯ ИЗ ТЕКУЩЕГО выражения нашего произведения и прибавления текущего произведения
                    //вот такую штутку eval - multed + multed * cur
                    dive(res, currStr + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
                }
            }
        }

    }


}
