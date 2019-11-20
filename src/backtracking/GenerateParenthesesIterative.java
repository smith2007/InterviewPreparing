package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParenthesesIterative {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    static List<String> generateParenthesis(int n) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));

        for (int i = 1; i <= n; ++i) {
            final List<String> list = new ArrayList<>();

            for (int j = 0; j < i; ++j) {

                for (String first : lists.get(j)) {

                    for (String second : lists.get(i - 1 - j)) {
                        list.add("(" + first + ")" + second);
                    }

                }

            }

            lists.add(list);
        }

        return lists.get(lists.size() - 1);
    }

    static void backtrack(List<String> list, String str, int openParCount, int closeParCount, int numberOfPairs) {

        if (str.length() == numberOfPairs * 2) {
            list.add(str);
            return;
        }

        if (openParCount < numberOfPairs) {
            backtrack(list, str + "(", openParCount + 1, closeParCount, numberOfPairs);
        }
        if (closeParCount < openParCount) {
            backtrack(list, str + ")", openParCount, closeParCount + 1, numberOfPairs);
        }
    }
}
