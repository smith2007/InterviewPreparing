package string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {

        System.out.println(romanToInt("III"));
    }

    static int romanToInt(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = map.get(str.charAt(str.length() - 1));
        for (int i = str.length() - 2; i >= 0; i--) {
            Integer num = map.get(str.charAt(i));
            if (num >= map.get(str.charAt(i + 1))) {
                res += num;
            } else {
                res -= num;
            }
        }
        return res;

    }
}
