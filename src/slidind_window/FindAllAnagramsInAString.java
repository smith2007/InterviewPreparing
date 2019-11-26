package slidind_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        String str = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(str, p));
    }

    /**
     * классическая задача на слайдиг виндов - берем два указателя,
     * набиваем мапу, как только длина символов равна длине второй
     * строки сравниваем мапы через метод equals
     */
    static List<Integer> findAnagrams(String str, String p) {
        ArrayList<Integer> res = new ArrayList<>();

        if (str.length() == 0 || p.length() == 0) {
            return res;
        }

        Map<Character, Integer> map = p.chars()
                .boxed()
                .collect(Collectors.toMap(k -> (char) k.intValue(), v -> 1, Integer::sum));

        int i = 0;
        int j = 0;
        Map<Character, Integer> tmap = new HashMap<>();
        while (j < str.length()) {
            tmap.merge(str.charAt(j), 1, (a, b) -> a + b);
            if (j - i + 1 == p.length()) {
                if (tmap.equals(map)) {
                    res.add(i);
                }
                if (tmap.get(str.charAt(i)) - 1 == 0) {
                    tmap.remove(str.charAt(i));
                } else {
                    tmap.put(str.charAt(i), tmap.get(str.charAt(i)) - 1);
                }
                i++;
            }
            j++;
        }
        return res;
    }
}
