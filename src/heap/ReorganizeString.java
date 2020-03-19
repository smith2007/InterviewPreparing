package heap;

import java.util.HashMap;
import java.util.Map;

public class ReorganizeString {

    public static void main(String[] args) {

        System.out.println(reorganizeString("aab"));

    }

    static String reorganizeString(String s) {

        Map<Character, Integer> map = new HashMap<>();


        for (char ch : s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }

        int max = 0;
        Character maxLetter = s.charAt(0);
        for (Character letter : map.keySet()) {
            if (map.get(letter) > max) {
                max = map.get(letter); // ищем максимум
                maxLetter = letter;
            }
        }
        //если максимум очень большо
        //сильно превышает размный предел - а именно больше чем пол строки
        //то все сто пудово уже не влезет - возвращаем пустую строку
        if (max > (s.length() + 1) / 2) {
            return "";
        }


        char[] res = new char[s.length()];

        int index = 0;

        //заполняем вот по такому паттерну a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
        while (map.get(maxLetter) > 0) {
            res[index] = maxLetter;
            index += 2; // перескакиваем на две позиции
            Integer count = map.get(maxLetter);
            map.put(maxLetter, count - 1);
        }

        //далее строим вот такое подобие
        //a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
        //a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
        //a b a c a _ b _ b // fill in "c" at position 3
        //a b a c a d b d b // fill in "d" at position 5, 7
        for (Character letter : map.keySet()) {
            while (map.get(letter) > 0) {
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = letter;
                index += 2;
                Integer count = map.get(letter);
                map.put(letter, count - 1);
            }
        }
        return String.valueOf(res);
    }
}
