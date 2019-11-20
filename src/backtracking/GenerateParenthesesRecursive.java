package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesRecursive {


    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
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
