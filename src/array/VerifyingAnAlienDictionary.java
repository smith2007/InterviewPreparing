package array;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {

    public static void main(String[] args) {

    }

    static boolean isAlienSorted(String[] words, String order) {

        if (order == null || order.isEmpty() || words.length == 0) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();


        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        int j = 0;
        int f = 0;

        for (int i = 0; i + 1 < words.length; i++) {
            String curr = words[i];
            String next = words[i + 1];
            f = 0;
            for (j = 0; j < Math.min(curr.length(), next.length()); j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);

                if (c1 != c2) {
                    f = 1;
                    if (map.get(c2) < map.get(c1)) {
                        return false;
                    }
                    break;
                }
            }
            if (f == 0 && curr.length() > next.length()) {
                return false;
            }

        }
        return true;

    }
}
