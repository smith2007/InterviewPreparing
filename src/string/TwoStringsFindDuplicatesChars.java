package string;

public class TwoStringsFindDuplicatesChars {

    public static void main(String[] args) {
        // andrey alexandrovich
        printDuplicates("andrey".toCharArray(), "alexandrovich".toCharArray());
        // a e
    }

    static void printDuplicates(char[] str1, char[] str2) {

        int[] letters = new int[128];

        for (int i = 0; i < str1.length; i++) {
            letters[str1[i]]++;
        }

        for (int i = 0; i < str2.length; i++) {
            char c = str2[i];
            if (letters[c] != 0) {
                System.out.println("Duplicate is " + str2[i]);
                letters[c] = 0;
            }
        }
    }
}
