package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

    /**
     * https://leetcode.com/problems/group-anagrams/
     */

    public static void main(String[] args) {
        String[] strs = {"tea", "and", "ace", "ad", "eat", "dans"};

        List<List<String>> lists = groupAnagrams(strs);

        lists.forEach(strings -> strings.forEach(System.out::println));
    }


    static List<List<String>> groupAnagrams(String[] arr) {

        Map<HashMap<Character, Integer>, List<String>> map = new HashMap<>();

        for (String str : arr) {
            HashMap<Character, Integer> hash = new HashMap<>();
            for (char ch : str.toCharArray()) {
                hash.merge(ch, 1, Integer::sum);
            }

            List<String> strings = map.getOrDefault(hash, new ArrayList<>());
            strings.add(str);
            map.put(hash, strings);
        }

        return map.values().stream().collect(Collectors.toList());
    }


}
