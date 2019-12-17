package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutationRecursiveDFS {


    public static void main(String[] args) {
        String str = "a1b2";
        List<String> result = letterCasePermutation(str);

        for (String s : result) {
            System.out.println(s);
        }

    }

    //такой же но рекурсивный подход
    //он же dfs
    static List<String> letterCasePermutation(String str) {
        List<String> ans = new ArrayList<>(); //сразу создадим результирующий

        backtrack(ans, str.toCharArray(), 0);
        return ans;
    }

    static void backtrack(List<String> ans, char[] chars, int index) {
        if (index == chars.length) {
            ans.add(new String(chars));
        } else {
            //ну и все по очереди кладем в промежуточный массив
            if (Character.isLetter(chars[index])) {
                //если это буква, то по очереди сетим то маленькая то большая
                chars[index] = Character.toLowerCase(chars[index]);
                backtrack(ans, chars, index + 1);
                chars[index] = Character.toUpperCase(chars[index]);
            }
            backtrack(ans, chars, index + 1);
        }
    }
}
