package string;

import java.util.HashMap;

public class ValidAnagramCounting2 {

    public static void main(String[] args) {

        String first = "andrey";
        String second = "yandre";

        boolean anagramm = isAnagramm(first, second);

        System.out.println(anagramm);
    }

    /**
     * сложность О(n) времени
     * сложность по памяти O(1)
     */
    static boolean isAnagramm(String first, String second) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            Character c = first.charAt(i);
            map.merge(c, 1, (a, b) -> a + b);
        }

        for (int i = 0; i < second.length(); i++) {
            char c = second.charAt(i);
            Integer count = map.get(c);
            if (count == null) {
                return false;
            } else {
                map.put(c, count - 1);
            }
        }
        return map.values().stream().allMatch(i -> i == 0);
    }
}
