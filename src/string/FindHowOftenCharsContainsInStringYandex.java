package string;

import java.util.HashMap;

public class FindHowOftenCharsContainsInStringYandex {

    /**
     * есть две строчки
     * нужно понять сколько раз символы из первой
     * строки встречаются во второй строке
     */
    private static int findQuadratic(String first, String second) {
        char[] firstCharArray = first.toCharArray();
        char[] secondCharArray = second.toCharArray();

        int count = 0;

        for (int i = 0; i <= firstCharArray.length - 1; i++) {
            for (int j = 0; j <= secondCharArray.length - 1; j++) {
                if (firstCharArray[i] == secondCharArray[j])
                    count++;
            }
        }
        return count;
    }


    //второй путь - переложить массив в хэшмап - где ключ - символ - значение кол-во повторений
    //сложность линейная

    private static int findLinear(String first, String second) {
        int count = 0;

        char[] firstCharArray = first.toCharArray();
        char[] secondCharArray = second.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (Character character : firstCharArray) {
            if (!map.containsKey(character)) {
                map.put(character, 1);
            } else {
                Integer integer = map.get(character);
                map.put(character, integer + 1);
            }
        }

        for (Character character : secondCharArray) {
            Integer integer = map.get(character);
            if (integer != null) {
                count = count + integer;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        System.out.println("quadratic result isContainsDoubleChars :" + findQuadratic("ab", "aabbccd"));
        System.out.println("linear result isContainsDoubleChars: " + findLinear("ab", "aabbccd"));
    }
}
