package parentheses;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthesesSmart {

    public static void main(String[] args) {
        List<String> res = removeInvalidParentheses("()())()");
        for (String re : res) {
            System.out.println(re);
        }

    }

    static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        removeHelper(s, res, 0, 0, '(', ')');
        return res;
    }

    /**
     * решаем через backtracking и перевернутую строку
     *
     * основная проблема заключается в том что мы не понимаем какую именно скобку нам надо удалять
     * открытую закрытую, что бы попытаться причесать строчку
     *
     * по этому будем действовать хитрее
     * основная идея в том что мы пытаемся найти кейсы когда кол-во закрытых скобок
     * превышаем кол-во открытых а затем переворачиваем строку и так же ищем уже кол-закрытых но на перевернутой
     * то есть в оригинале это как бы открытые и ищем возможности причесать строчку там
     */
    static void removeHelper(String s, List<String> res, int iStart, int jStart, char openParen, char closedParen) {
        int numOpenParen = 0;
        int numClosedParen = 0;

        for (int i = iStart; i < s.length(); i++) {

            if (s.charAt(i) == openParen) {
                numOpenParen++;
            }

            if (s.charAt(i) == closedParen) {
                numClosedParen++;
            }

            /**
             * основная идея в том что мы пытаемся найти кейсы когда кол-во закрытых скобок
             * превышаем кол-во открытых ск
             */
            if (numClosedParen > numOpenParen) { //мы имеем превышение закрытых скобок над открытыми - нам необходимо удалить лишние
                for (int j = jStart; j <= i; j++) // пытаемся удалить одну в каждой позиции пропуская дубликаты

                    if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen)) {
                        // Recursion: iStart = i since we now have valid # closed parenthesis thru i. jStart = j prevents duplicates
                        String newStr = s.substring(0, j) + s.substring(j + 1);
                        removeHelper(newStr, res, i, j, openParen, closedParen);
                    }

                return; // Stop here. The recursive calls handle the rest of the string.
            }
        }

        // а теперь разворачиваемся и пытаемся проделать тот же финт но только с развернутой строкой
        String reversed = new StringBuilder(s).reverse().toString();
        if (openParen == '(') {
            removeHelper(reversed, res, 0, 0, ')', '(');
        } else {
            res.add(reversed);
        }
    }
}
