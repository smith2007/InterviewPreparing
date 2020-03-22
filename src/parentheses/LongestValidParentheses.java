package parentheses;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        int i = longestValidParentheses("(()");

        System.out.println(i);
    }

    static int longestValidParentheses(String s) {
        int max = 0;

        Stack<Integer> stack = new Stack<>();
        //в стек будем пушить индексы наших открывающихся скобок
        //потом мы будем фиксировать длинну используя это значение
        //по этому изначально давай проинициализируем стек -1
        stack.push(-1);
        //итый указатель бежит вперед и добавляет в стек ИНДЕКСЫ
        //открывающихся скобок
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                //если мы встретили закрывающуюся то надо из стека попать
                stack.pop();
                //и самое главное - надо зафиксировать наш max в том случае если стек не пустой
                if (stack.empty()) {
                    //а вот если он пустой то извините подстрока не валидна
                    // кладем текущий индекс и потом уже будем от него считать
                    //может там впереди нас ждет что-то валидное
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
