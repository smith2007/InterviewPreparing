package string;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    /**
     * дана строка, необходимо посчитать сколько палиндромов сабстрок в нее входит, например
     * “abc” - ответ 3 - “a” “b” “c”
     *
     * строка “aaa” - ответ 6 “a” “aa” “aaa” “a” “aa” “a”
     *
     * тут похожий алгоритм с тем что было в LongestPalindromicSubstring -
     * мы идем по каждому символу и поочередно разбегаемся в разные стороны каунтим палиндромы,
     * делаем это все в цикле при этом цикл внимание должен вызывать два раза метод extractPalindrom с
     * границей end как i и как i+1, это очень очень важно потому что палиндромы могут быть как четной так
     * и не ченой длинны
     */

    static int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += extendPal(s, i, i);
            count += extendPal(s, i, i + 1);
        }

        return count;
    }

    static int extendPal(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            count++;
        }
        return count;
    }
}
