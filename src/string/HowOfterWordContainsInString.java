package string;

import java.util.HashMap;
import java.util.Map;

public class HowOfterWordContainsInString {

    /**
     * задача с интервью с волмарт лабс
     */
    public static void main(String[] args) {

        System.out.println(count("llllaafdsneesbbb", "label"));
    }

    static int count(String str, String word) {
        if (str.length() == 0 || word.length() == 0) {
            return 0;
        }


        Map<Character, Integer> wordMap = new HashMap<>();
        for (char ch : word.toCharArray()) {
            wordMap.merge(ch, 1, (a, b) -> a + b);
        }

        Map<Character, Integer> strMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (wordMap.containsKey(ch)) {
                strMap.merge(ch, 1, (a, b) -> a + b);
            }

        }

        int count = 0;
        if (wordMap.size() != strMap.size()) {
            return count;
        }


        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            int howMany = strMap.get(key) / value;
            min = Math.min(howMany, min);

        }

        return min;
    }

}
