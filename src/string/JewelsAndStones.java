package string;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public static void main(String[] args) {
        String j = "aA", s = "aAAbbbb";

        System.out.println(numJewelsInStones(j, s));
    }

    static int numJewelsInStones(String j, String s) {

        Set<Character> set = new HashSet<>();
        for (char ch : j.toCharArray()) {
            set.add(ch);
        }

        int res = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                res++;
            }
        }
        return res;

    }
}
