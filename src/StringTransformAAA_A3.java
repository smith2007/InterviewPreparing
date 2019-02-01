import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringTransformAAA_A3 {

    public static void main(String[] args) {
        /*
            a. “” -> “”
            b. “a” -> “a1”
            c. “aaa” -> “a3”
            d. “aaabbc” -> “a3b2c1”
         */

        System.out.println(transform(""));
        System.out.println(transform("a"));
        System.out.println(transform("aaa"));
        System.out.println(transform("aaabbc"));
    }

    // O(n)
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
