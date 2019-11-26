package array;

import java.util.HashMap;

public class FirstUniqueCharacterInaString {

    public static void main(String[] args) {
        String str = "leetcode";

        System.out.println(find(str));
    }

    static int find(String str) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        for (int i = 0; i <str.length() ; i++) {
            if (map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
