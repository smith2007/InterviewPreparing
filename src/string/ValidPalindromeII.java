package string;

public class ValidPalindromeII {

    public static void main(String[] args) {
        System.out.println(validPalindrome("ebcbbececabbacecbbcbe"));
    }

    static boolean validPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        int i = 0;
        int j = s.length() - 1;

        int tries = 1;

        return check(s, i, j, tries);
    }

    private static Boolean check(String s, int i, int j, int tries) {
        char[] chars = s.toCharArray();
        while (i < j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else if (tries != 0) {
                tries--;

                if (i != 0 && j != 0 && i + 1 == j - 1) {
                    return true;
                }

                if (chars[j - 1] == chars[i] && chars[i + 1] == chars[j]){
                    return check(s, i, j-1, 0) || check(s, i+1, j, 0);
                }else if (chars[j - 1] == chars[i]) {
                    j--;
                } else if (chars[i + 1] == chars[j]) {
                    i++;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
