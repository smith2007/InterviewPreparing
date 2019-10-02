package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagramsSorting {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};


        groupAnagrams(strs);
    }

    static List<List<String>> groupAnagrams(String[] strs) {

        Map<Integer, List<String>> map = new HashMap<>();

        for(String str : strs){

            int hash = computeHash(str);
            List<String> dict = map.getOrDefault(hash, new ArrayList<>());
            dict.add(str);

            map.put(hash,dict);
        }

        return map.values().stream().collect(Collectors.toList());
    }

    static int computeHash(String str){
        int hash = 0;

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            int position =  ch - 'a';
            hash = (hash * 26) + position;
        }

        return hash;
    }

}
