package string;

public class StringToIntegerAtoi {

    public static void main(String[] args) {
        String str = "2.1234234";
        System.out.println(myAtoi(str));
    }

    static int myAtoi(String str) {
        if (str == null) {
            return -1;
        }

        int sign = 1;
        int i = 0;
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '-') {
                sign = -1;
                i++;
                break;
            } else if (c == '+') {
                i++;
                break;
            } else if (Character.isDigit(c)) {
                break;
            } else if (c == ' '){

            } else {
                break;
            }
        }

        int res = 0;
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                break;
            } else if (Character.isDigit(c)) {
                //надо как то проверит то что число не выходит за диапазон
                //как это проверить

                int digit = c - '0';
                //первое условие что уменьшенный на один разряд MAX_INT УЖЕ меньше нашего текущего результруещего
                // или же уменьшенный на один разряд MAX_VALUE это и есть наш результат, теперь нам надо проверить что
                // добавление новой цифры не даст аут оф рейндж, как это сделать -
                //взять последнюю цифру MAX_VALUE и  проверит что она меньше чем наше число
                if (Integer.MAX_VALUE / 10 < res || Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < digit) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                //увеличиваем на один разряд
                res = 10 * res + digit;
            } else {
                break;
            }
        }

        return res * sign;
    }
}
