package string;

public class ValidPalindromeII {

    public static void main(String[] args) {
        System.out.println(validPalindrome("ebcbbececabbacecbbcbe"));
    }


    /**
     * 197.ValidPalindromeII
     * https://leetcode.com/problems/valid-palindrome-ii/
     *
     * дана не пустая строка s, ты можешь удалить из нее только один символ, верни тру или фолс - палиндром ли это 
     * Input: "aba"
     * Output: True 
     * Input: "abca"
     * Output: True
     *
     * не плохая задача - идем с двух концов массив проверяем символы указателями i и j попутно таская собой кол-во попыток для скипа, если оба символа равны - сжимаем указатели, но вот если не равны нам надо понять что делать , перво наперво уменьшаем кол во попыток для скипа а затем саааамое главное надо проверить оба впереди стоящих символа - для i и для j, то есть j-1 и i+1 что там стоит???
     *
     * if (chars[j - 1] == chars[i] && chars[i + 1] == chars[j]){ // если оба варианта вероятны - тогда мы точно не знаем куда идти надо попытаться понять это запустив и там и там рекурсивно
     *     return check(s, i, j-1, 0) || check(s, i+1, j, 0);
     * }else if (chars[j - 1] == chars[i]) {
     *     j--; // ну и тут если правый символ надо скипнуть
     * } else if (chars[i + 1] == chars[j]) {
     *     i++; //если левый символ надо скипнуть
     * } else {
     *     return false;
     * }
     */

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
