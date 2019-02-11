package string;

public class AnagrammUsingLetterCounting {

    public static void main(String[] args) {

        String first = "andrey";

        String second = "dreyna";


        boolean anagram = isAnagram(first, second);
        System.out.println("Strings " + (anagram ? "are" : "are not") + " anagram");


    }

    // О(n)
    private static boolean isAnagram(String first, String second) {

        if (first.length() != second.length()) {
            return false;
        }

        int[] letters = new int[128];
        char[] firstArray = first.toCharArray();
        for (int i = 0; i < firstArray.length; i++) {
            char c1 = firstArray[i];
            letters[c1] = letters[c1] + 1;
        }

        char[] secondArray = second.toCharArray();
        for (int i = 0; i < secondArray.length; i++) {
            char c2 = secondArray[i];
            if (letters[c2] > 0) {
                letters[c2] = letters[c2] - 1;
            }
        }

        for (int letter : letters) {
            if (letter > 0) {
                return false;
            }
        }
        return true;
    }
}
