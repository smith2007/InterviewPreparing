package string;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagramsHashing {

    public static void main(String[] args) {
        String[] strs = {"tea", "and", "ace", "ad", "eat", "dans"};

        List<List<String>> lists = groupAnagrams(strs);

        lists.forEach(strings -> strings.forEach(System.out::println));
    }


    static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] letters = new int[26];
            Arrays.fill(letters, 0);
            for (char ch : str.toCharArray()) {
                int num = ch - 'a';
                letters[num] = letters[num] + 1;
            }

            StringBuilder hash = new StringBuilder();
            for (int i = 0, letterNum = 0; i < 53; i++) {
                if (i % 2 == 0) {
                    hash.append("#");
                } else {
                    hash.append(letters[letterNum]);
                    letterNum++;
                }
            }
            String hashStr = hash.toString();
            List<String> elms = map.getOrDefault(hashStr, new ArrayList<>());
            elms.add(str);
            map.put(hashStr, elms);

        }

        return map.values().stream().collect(Collectors.toList());
    }


}
