package slidind_window;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PermutationInString {

    public static void main(String[] args) {

    }

    /**
     * дана строка s1 и s2, понять сордержится ли пермутэйшен перво строки во второй
     *
     * Input: s1 = "ab" s2 = "eidbaooo"
     * Output: True
     * Explanation: s2 contains one permutation of s1 ("ba").
     *
     * решается так же как и FindAllAnagramsInAString
     *
     * берем два указателя, набиваем мапу, как только длина символов равна длине
     * второй строки сравниваем мапы через метод equals - равны? возвращаем true
     */

    boolean checkInclusion(String s1, String s2) {

        if (s2.length() == 0 || s1.length() == 0) {
            return false;
        }

        Map<Character, Integer> map = s1.chars()
                .boxed()
                .collect(Collectors.toMap(k -> (char) k.intValue(), v -> 1, Integer::sum));

        int i = 0;
        int j = 0;
        Map<Character, Integer> tmap = new HashMap<>();
        while (j < s2.length()) {
            tmap.merge(s2.charAt(j), 1, (a, b) -> a + b);
            if (j - i + 1 == s1.length()) {
                if (tmap.equals(map)) {
                    return true;
                }
                if (tmap.get(s2.charAt(i)) - 1 == 0) {
                    tmap.remove(s2.charAt(i));
                } else {
                    tmap.put(s2.charAt(i), tmap.get(s2.charAt(i)) - 1);
                }
                i++;
            }
            j++;
        }
        return false;
    }
}
