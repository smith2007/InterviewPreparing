package parentheses;

import java.util.LinkedList;

public class ValidParenthesisString {

    public static void main(String[] args) {

        String str = "(*()";

        System.out.println(checkValidString(str));
    }

    /**
     *
     дана строка вида "(())((())()()(*)(*()(())())())()()((()())((()))(*" где символ * может
     выступать как правая скобка, как левая скобка и как просто не учитываемый символ,
     необходимо провалидировать строку

     я решил эту задачу с использованием двух стеков за линейное время, первый стек у нас фиксирует
     левый скобки, второй фиксируем звездочки

     очень важно что в стек мы будем добавлять ИНДЕКСЫ наших знаков

     и так пробегаем по нашей строчке и попаем стеки, имея ввиду что звездочка универсальный
     символ который можно использовать только если нет скобок

     и далее после пробега смотрим на то что осталось на руках, если оба стека не пустых
     пробуем еще разок их закрыть для попаем из обоих стеков и ОЧЕНЬ ВАЖНО смотрим что индекс
     скобки был меньше чем звездочки, иначе хана не правильно, наша звездочка не поможет она
     теоретически не сможет закрыть скобку
     *
     *
     */

    static boolean checkValidString(String s) {


        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        LinkedList<Integer> stackLeft = new LinkedList<>();

        LinkedList<Integer> stackStar = new LinkedList<>();


        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if ('(' == ch) {
                stackLeft.push(i);
            } else if ('*' == ch) {
                stackStar.push(i);
            } else if (')' == ch) {
                if (stackLeft.isEmpty() && stackStar.isEmpty()) {
                    return false;
                } else if (stackLeft.isEmpty() && !stackStar.isEmpty()) {
                    stackStar.pop();
                } else if (!stackLeft.isEmpty() && stackStar.isEmpty()) {
                    stackLeft.pop();
                } else if (!stackLeft.isEmpty() && !stackStar.isEmpty()) {
                    stackLeft.pop();
                }
            }
        }

        if (stackStar.isEmpty() && stackLeft.isEmpty()) {
            return true;
        } else if (stackLeft.isEmpty() && !stackStar.isEmpty()) {
            return true;
        } else if (!stackLeft.isEmpty() && stackStar.isEmpty()) {
            return false;
        } else { // !stackPar.isEmpty() && !stackStar.isEmpty()
            while (!stackLeft.isEmpty() && !stackStar.isEmpty()) {
                Integer left = stackLeft.pop();
                Integer start = stackStar.pop();
                if (left > start) {
                    return false;
                }
            }
        }
        return stackLeft.isEmpty();

    }
}
