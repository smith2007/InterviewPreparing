package parentheses;

import java.util.LinkedList;
import java.util.Stack;

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

        Stack<Integer> stackLeft = new Stack<>();

        Stack<Integer> stackStar = new Stack<>();

        //двух стеков за линейное время, первый стек у нас фиксирует
        //     левый скобки, второй фиксируем звездочки
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            //если открытиая скобка кладем на стек с откр скобками
            if ('(' == ch) {
                stackLeft.push(i);
            } else if ('*' == ch) {
                //если звездочка то кладем на второй стек
                stackStar.push(i);
            } else if (')' == ch) {
                //а вот если закр скобка надо понимать что делать
                //если оба стека пустые - то все ситуация не валидна
                //мы не можем никак компенсировать эту закрытую скобку
                if (stackLeft.isEmpty() && stackStar.isEmpty()) {
                    return false;
                } else if (stackLeft.isEmpty()) {
                    //в первую очередь компенсируем закрытые скобки - звездочками если он есть
                    stackStar.pop();
                } else if (stackStar.isEmpty()) {
                    //если есть левые скобки - компенсируем левыми скобками
                    stackLeft.pop();
                } else if (!stackLeft.isEmpty() && !stackStar.isEmpty()) {
                    //если оба не пустые то компенсируем левыми скобками
                    stackLeft.pop();
                }
            }
        }

        /**
         * и далее после пробега смотрим на то что осталось на руках, если оба стека не пустых
         *      пробуем еще разок их закрыть для попаем из обоих стеков и ОЧЕНЬ ВАЖНО смотрим что индекс
         *      скобки был меньше чем звездочки, иначе хана не правильно, наша звездочка не поможет она
         *      теоретически не сможет закрыть скобку
         */
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
