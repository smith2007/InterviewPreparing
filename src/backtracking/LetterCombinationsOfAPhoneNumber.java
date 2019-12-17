package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber ins = new LetterCombinationsOfAPhoneNumber();
        System.out.println(ins.letterCombinations("23"));
    }

    Map<Character, char[]> map;

    {
        map = new HashMap<>();

        map.put('2', "abc".toCharArray());
        map.put('3', "def".toCharArray());
        map.put('4', "ghi".toCharArray());
        map.put('5', "jkl".toCharArray());
        map.put('6', "mno".toCharArray());
        map.put('7', "pqrs".toCharArray());
        map.put('8', "tuv".toCharArray());
        map.put('9', "wxyz".toCharArray());
    }


    List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        backtrack(res, "", digits, 0, digits.length());
        return res;
    }

    void backtrack(List<String> res, String curr, String digits, int currIndex, int digitsLen) {

        if (curr.length() == digitsLen) {
            res.add(curr);
            return;
        }
        //два цикла первый по числам
        //второй по буква которые соотв этому числу

        for (int i = currIndex; i < digits.length(); i++) {
            char[] lettersByDigit = map.get(digits.charAt(i));
            for (char c : lettersByDigit) {
                backtrack(res, curr + c, digits, i + 1, digitsLen);
            }
        }

    }
}
