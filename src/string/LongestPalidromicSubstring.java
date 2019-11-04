package string;

public class LongestPalidromicSubstring {


    public static void main(String[] args) {
        String str = "babad";

        System.out.println(longest(str));

    }

    static String longest(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        char[] chars = str.toCharArray();
        int start = 0;
        int end = 0;
        int max = 0;

        for (int i = 0; i < chars.length; i++) {

            if (isPallidrome(chars, i - max - 1, i)) {
                start = i - max - 1;
                end = i;
                max += 2;
            } else if (isPallidrome(chars, i - max, i)) {
                start = i - max;
                end = i;
                max += 1;
            }
        }

        return str.substring(start, end + 1);
    }

    static boolean isPallidrome(char[] chars, int i, int j) {
        if (i < 0) {
            return false;
        }

        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }

            i++;
            j--;
        }
        return true;

    }
}
