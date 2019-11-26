package stack;

import java.util.LinkedList;

public class BackspaceStringCompare {

    /**
     *
     дано две строки "ab#c", "ad#c" - предположим что мы вставили каждую из этих
     строчек в редактор а теперь символ решетки # означает удаление одного предыдущего
     символа то есть строка ab#c -> преобразуется в ac потому что b мы удалили

     надо сравнить две эти строки на равенство после удаления - какое тут решение?
     самое простое это набить стек и класть в стек все символы но как только встретится
     решетка вытащить из стека элемент затем привести стек в строку и сравнить с преобразованием
     над второй строкой

     еще проще - набить стринг билдер - без всякого стека
     */

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }

    static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    static String build(String str) {

        LinkedList<Character> ans = new LinkedList<>();

        for (char c : str.toCharArray()) {
            if (c != '#'){
                ans.push(c);
            } else if (!ans.isEmpty()){
                ans.pop();
            }
        }
        return String.valueOf(ans);
    }
}
