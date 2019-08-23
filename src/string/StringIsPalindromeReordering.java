package string;

import java.util.HashMap;

public class StringIsPalindromeReordering {

    /**
     * тут у нас картина следующая
     * на будущее если опять забудешь, палидром это такая хуйня
     * которая читается одинаково слева на право и справа на лево
     * типа там роза упала на лапу азара и прочая хрень
     * 
     * решать будем мапой с чарами и каунтов
     * нужно понимать что если кол-во символов четное то всех символов дожно быть четное кол-во
     * иначе может быть одно не четное потому что оно может стоять в середине
     * 
     */
    public static void main(String[] args) {
        String str = "tact coa";
        System.out.println(str);
        System.out.println(isPossibleToTransformIntoPalindrome(str));


        String str2 = "taacct coaa";
        System.out.println(str2);
        System.out.println(isPossibleToTransformIntoPalindrome(str2));
    }

    static boolean isPossibleToTransformIntoPalindrome(String str) {
        char[] chars = str.toCharArray();
        //набиваем мапу
        HashMap<Character, Integer> map = new HashMap<>();
        int symbolsCont = 0;
        for (int i = 0; i < chars.length; i++) {
            char symbol = chars[i];
            if (symbol == ' ') {
                continue;
            }
            symbolsCont++;
            Integer count = map.get(symbol);
            if (count == null) {
                map.put(symbol, 1);
            } else {
                map.put(symbol, count + 1);
            }
        }

        //проверяем четность игнорируя пробелы
        boolean isEven = false;
        if (symbolsCont % 2 == 0) {
            isEven = true;
        }

        boolean signal = false;

        //ну и смотрим тут что у нас получается
        for (Integer value : map.values()) {
            if (value % 2 != 0) {
                if (signal && isEven) {
                    return false;
                } else {
                    signal = true;
                }
            }
        }
        return true;
    }

}
