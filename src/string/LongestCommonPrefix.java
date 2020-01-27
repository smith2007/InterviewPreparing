package string;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String currPrefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String currWord = strs[i];

            int j = 0;
            StringBuilder newPrefix = new StringBuilder();
            while (j < currPrefix.length() && j < currWord.length()) {
                if (currPrefix.charAt(j) == currWord.charAt(j)) {
                    newPrefix.append(currWord.charAt(j));
                    j++;
                } else {
                    break;
                }
            }
            if (newPrefix.capacity() == 0) {
                return "";
            }
            currPrefix = newPrefix.toString();

        }
        return currPrefix;
    }

}
