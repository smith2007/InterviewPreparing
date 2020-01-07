package string;

public class ReverseWordsInAString {

    public static void main(String[] args) {

    }

    static String reverseWords(String str) {
        String[] arr = str.trim().split(" +");
        StringBuilder res = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            res.append(arr[i]);
            if (i != 0) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}
