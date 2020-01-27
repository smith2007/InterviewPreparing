package string;

import java.util.*;

public class ValidAnagramSorting {

    public static void main(String[] args) {

        String first = "andrey nevedin";

        String second = "ProductMinusSum ddreeeviay";

        boolean anagram = isAnagram(first, second);
        System.out.println("Strings " + (anagram ? "are" : "are not") + " anagram");


        Collection<List<String>> anagrams = getAnagrams("нос", "сон", "снедь", "днесь");

    }

    // O(n log n)

    private static boolean isAnagram(String first, String second) {

        if (first.length() != second.length()) {
            return false;
        }

        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);

        for (int i = 0; i < firstArr.length; i++) {
            if (firstArr[i] != secondArr[i]) {
                return false;
            }
        }
        return true;

    }


    private static Collection<List<String>> getAnagrams(String... values) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String value : values) {
            char[] key = value.toCharArray();
            Arrays.sort(key);
            String key1 = String.valueOf(key);
            List<String> strings = map.get(key1);
            if (strings == null) {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(value);
                map.put(key1, newList);
            } else {
                strings.add(value);
            }
        }
        return map.values();
    }
}
