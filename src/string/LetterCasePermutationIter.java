package string;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutationIter {

    public static void main(String[] args) {
        String str = "a1b2";
        List<String> result = permutate(str);

        for (String s : result) {
            System.out.println(s);
        }

    }

    static List<String> permutate(String str) {
        ArrayList<String> result = new ArrayList<>();
        result.add(str);

        for (int i = 0; i < str.length(); i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                char[] chars = result.get(j).toCharArray();
                if (Character.isLetter(chars[i])) {
                    if (Character.isUpperCase(chars[i])) {
                        chars[i] = Character.toLowerCase(chars[i]);
                    } else {
                        chars[i] = Character.toUpperCase(chars[i]);
                    }
                    result.add(new String(chars));
                }
            }
        }

        return result;

    }
}
