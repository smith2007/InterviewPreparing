package slidind_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationofAllWords {

    public static void main(String[] args) {

        String str = "barfoothefoobarman";
        String[] arr = {"bar", "foo"};

        List<Integer> result = findSubstring(str, arr);

        result.forEach(System.out::println);


    }

    static List<Integer> findSubstring(String s, String[] arr) {

        List<Integer> resultList = new ArrayList<>();

        if (s == null || s.length() < 1 || arr.length < 1) {
            return resultList;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int len = arr[0].length();

        String[] strArr = new String[s.length()];

        for (int i = 0; i < len; i++) {
            // initialize slide window
            int begin = i;

            //создаем локальную мапу
            Map<String, Integer> localMap = new HashMap<>();

            int size = 0;

            for (int j = i; j <= s.length() - len; j += len) { // slide by the length of word

                strArr[j] = s.substring(j, j + len);

                if (map.containsKey(strArr[j])) { // update slide window

                    begin = begin == -1 ? j : begin;
                    localMap.put(strArr[j], localMap.getOrDefault(strArr[j], 0) + 1);
                    size++;

                    if (size == arr.length) {

                        if (localMap.equals(map)) {
                            resultList.add(begin);
                        }

                        localMap.put(strArr[begin], localMap.get(strArr[begin]) - 1);
                        size--;
                        begin += len;
                    }

                } else { // reset the slide window
                    begin = -1;
                    localMap.clear();
                    size = 0;
                }
            }
        }
        return resultList;
    }


}
