package parentheses;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    static String minRemoveToMakeValid(String s) {
        if (s == null) {
            return null;
        }

        Stack<Pair> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            char curr = chars[i];
            if (curr == '(') {
                Pair pair = new Pair();
                pair.symb = curr;
                pair.index = i;
                stack.push(pair);
            } else if (curr == ')') {

                if (stack.isEmpty() || stack.peek().symb == ')') {
                    Pair pair = new Pair();
                    pair.symb = curr;
                    pair.index = i;
                    stack.push(pair);
                } else if(stack.peek().symb == '('){
                    stack.pop();
                }
            }
        }


        Set<Integer> set = new HashSet<>();
        while (!stack.isEmpty()) {
            set.add(stack.pop().index);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {

            if (!set.contains(i)){
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
    static class Pair {
        char symb;
        int index;
    }
}
