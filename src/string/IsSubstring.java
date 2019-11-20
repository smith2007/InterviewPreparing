package string;

public class IsSubstring {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    static boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (j <= t.length() - 1) {
            if (i == s.length()) {
                return true;
            }
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }

        }

        return i == s.length();
    }
}
