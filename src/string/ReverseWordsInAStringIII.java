package string;

public class ReverseWordsInAStringIII {


    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";

        System.out.println(reverseWords(str));
    }

    static String reverseWords(String s) {

        if (s.isEmpty()) {
            return "";
        }

        int i = 0;
        int j = 0;

        char[] chars = s.toCharArray();

        while (true) {
            if (j == chars.length || chars[j] == ' ') {
                int i1 = i;
                int i2 = j - 1;
                while (i1 < i2) {
                    char temp = chars[i1];
                    chars[i1] = chars[i2];
                    chars[i2] = temp;
                    i1++;
                    i2--;
                }
                i = j + 1;
            }

            if (j == chars.length) {
                break;
            }
            j++;
        }

        return new String(chars);
    }
}
