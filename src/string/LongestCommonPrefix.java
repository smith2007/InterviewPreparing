package string;

public class LongestCommonPrefix {

    /**
     * 164.LongestCommonPrefix
     * https://leetcode.com/problems/longest-common-prefix/
     *
     * напиши метод который находит самый длинный общий преффикс
     * у строк в массиве строк, если общего префикса нет верни пустую строку
     *
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     *
     * проходим обычным сканом - берем за начальную точку в виде начального префикса нашу нулевую строку
     * из массив, далее берем следующую и смотрим их общий префикс - набиваем его через стринг билдер,
     * если общего префикса нет - стринг билдер оказался пустым - возвращаем пустую строку
     *
     */
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
