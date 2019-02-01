import java.util.Arrays;

public class AnagramTest {

    public static void main(String[] args) {

        String first = "andrey nevedin";

        String second = "nnn ddreeeviay";

        boolean anagram = isAnagram(first, second);
        System.out.println("Strings " + (anagram ? "are" : "are not") + " anagram");
    }

    // O(n log n)

    private static boolean isAnagram(String first, String second) {

        if (first.length() != second.length()) {
            return false;
        }

        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);

        for (int i = 0; i < firstArr.length; i++) {
            if (firstArr[i] != secondArr[i]) {
                return false;
            }
        }
        return true;

    }
}
