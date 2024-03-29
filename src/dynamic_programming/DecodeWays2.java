package dynamic_programming;

public class DecodeWays2 {

    /**
     * 181.DecodeWays
     *
     * https://leetcode.com/problems/decode-ways/
     *
     * Дана строка которая содержит симовлы от A-Z, каждая буква закодирована числом используя маппинг
     * 'A' -> 1; 'B' -> 2; ... 'Z' -> 26
     *
     * Дана не пустая строчка из чисел - необходимо посчитать сколькими кол-вами коомибанций можно представить эту строку
     * Input: "12" -> Output: 2 - > Explanation: It could be decoded as "AB" (1 2) or "L" (12).
     * Input: "226" -> Output: 3 -> Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     *
     * надо работать итеративно через динамическое программирование - создаем массив длинной на 1 больше чем наша исходная строка
     * решается через динамическое программирование, каждый элемент дп массива будет говорить нам -
     * сколькими возможными коомбинациями можно представить укороченную подстроку
     *
     * массив для надеги будет использоваться длинной на один больше чем исходная строка, по этому базовый нулевой
     * элемент инициализируем единицей, а вот первый элемент, надо очень внимательно посмотреть что там стоит
     * в качестве первого символа
     * "01" если вот так например то надо понимать что мы не сможем предстваить нашу строку длинной 1 как 1
     * по этому ставим ноль в качестве dp[1] если первый элемент нашей входной строки == 0, в общем проверяем
     * далее раскручиваем массив начиная со второго элемента
     * внутри цикла рассматриваем два кейса, первый - одноразрядное число
     * второй - двух разрядное, двухразрядно считается валидным только есть оно находится в диапазоне от 10 до 26 -
     * то есть можно представить этим символом какую-то новую строку
     * а вот одно разрядно должно быть валидно только тогда когда оно от 1 до 9, внимание НЕ НОЛЬ
     * иными словами проверяем такой колаб из текущего итого символа и i-1, а дает ли оно нам от 10 до 26 если да то
     * int iMinus2 = dp[i - 2];
     * dp[i] = dp[i] + iMinus2;
     */
    public static void main(String[] args) {

        int i = numDecodings("12");
        System.out.println(i);
    }

    static int numDecodings(String s) {

        if (s.isEmpty() || (s.length()==1 && s.charAt(0) == '0')) {
            return 0;
        }

        //решается через динамическое программирование
        //каждый элемент дп массива будет говорить нам
        //сколькими возможными коомбинациями можно представить
        //укороченную подстроку
        int[] dp = new int[s.length() + 1];

        //массив для надеги будет использоваться длинной на один больше
        //по этому базовый элемент инициализируем 1
        dp[0] = 1;

        //а вот первый элемент, надо очень внимательно посмотреть что там стоит в качестве первого символа
        //"01" если вот так например то надо понимать что мы не сможем предстваить нашу строку длинной 1 как 1
        //по этому ставим тут ноль, в общем проверяем
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        //далее раскручиваем массив
        for (int i = 2; i < s.length()+1; i++) {

            //и тут рассматриваем два кейса, первый - само новое одноразрядное число
            int first = Integer.parseInt(s.substring(i - 1, i));
            //и второй кейс само итое число с соседом слева - что оно нам может дать??
            //может ли оно нам дать что-то такой колаб который даст нам новый вариант строки
            int second = Integer.parseInt(s.substring(i - 2, i));
            // проверяем  базовый случай что число одно и оно не ноль

            if (first >= 1 && first <= 9) {
                int iMinus1 = dp[i - 1];
                dp[i] = dp[i] + iMinus1;
            }
            // далее второй случай что дает колабб
            if (second >= 10 && second <= 26) {
                int iMinus2 = dp[i - 2];
                dp[i] = dp[i] + iMinus2;
            }
        }

        return dp[s.length()];
    }
}
