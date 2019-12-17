package string;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringCompressionAA_A2 {

    public static void main(String[] args) {
        /*
            a. “” -> “”
            b. “a” -> “a1”
            c. “aaa” -> “a3”
            d. “aaabbc” -> “a3b2c1”
         */

/*        System.out.println(transform(""));
        System.out.println(transform("a"));
        System.out.println(transform("aaa"));
        System.out.println(transform("aaabbc"));*/

        char[] chars = "abc".toCharArray();
        compress(chars);

        System.out.println(chars);
    }

    static int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        if (chars.length==1){
            return 1;
        }

        int i = 0;

        int count = 0;

        for (int j = 0; j < chars.length; j++) {
            if (chars[i] == chars[j]) {
                count++;
            } else {
                if (count > 1) {
                    if (count > 9) {
                        char[] chars1 = String.valueOf(count).toCharArray();
                        for (char c : chars1) {
                            chars[i + 1] = c;
                            i++;
                        }
                        chars[i + 1] = chars[j];
                        i++;
                    } else {
                        chars[i + 1] = (char) (count + '0');
                        chars[i + 2] = chars[j];
                        i += 2;
                    }

                } else {
                    chars[i + 1] = chars[j];
                    i++;
                }

                count = 1;
            }
        }

        if (count > 1) {
            if (count > 9) {
                char[] chars1 = String.valueOf(count).toCharArray();
                for (char c : chars1) {
                    chars[i + 1] = c;
                    i++;
                }
                chars[i + 1] = chars[chars.length - 1];
                i++;
            } else {
                chars[i + 1] = (char) (count + '0');
                if (i + 2 <= chars.length - 1) {
                    chars[i + 2] = chars[chars.length - 1];
                    i += 2;
                } else {
                    i++;
                }

            }
        } else {
            if (i+1<=chars.length-1){
                chars[i + 1] = chars[chars.length - 1];
            }
            i++;
        }

        return i;
    }


    // O(n) - по времени - по памяти О(n)
    // есть более прямолинейный способ - бежать по строкев в цикле - проверять каждый символ
    // если такой ранее был модифицировать счетки и конкатенировать с помощью StringBuilder
    private static String transform(String orginal) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = orginal.toCharArray();
        for (char aChar : chars) {
            if (!map.containsKey(aChar)) {
                map.put(aChar, 1);
            } else {
                Integer integer = map.get(aChar);
                map.put(aChar, integer + 1);
            }
        }
        return map.entrySet()
                .stream()
                .map(e -> e.getKey().toString() + e.getValue())
                .collect(Collectors.joining());
    }
}
