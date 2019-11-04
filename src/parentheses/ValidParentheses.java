package parentheses;

import java.util.HashMap;
import java.util.LinkedList;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }


    static boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        //для простоты сделаем мапу
        //мапа закрывающихся скобок
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();

        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        LinkedList<Character> stack = new LinkedList<>();

        //короче - основное правило тут такое
        //если мы встретили закрывающийся символ
        //то это значит что
        //он сука должен закрывать конкретно i-1
        //символ
        //иначе строка не валидная
        for (int i = 0; i < s.length(); i++) {

            //эта мапа поможет нам понять что наш итый символ - закрывающийся
            if (mappings.containsKey(s.charAt(i))) {

                char topElement = stack.isEmpty() ? '#' : stack.pop();

                if (topElement != mappings.get(s.charAt(i))) {
                    return false;
                }
            } else {
                //однако - если мы встретили открывающийся
                //символ - то окей, добавим его
                stack.push(s.charAt(i));
            }

        }

        return stack.isEmpty();
    }
}
