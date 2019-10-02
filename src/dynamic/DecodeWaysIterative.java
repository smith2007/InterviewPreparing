package dynamic;

public class DecodeWaysIterative {

    public static void main(String[] args) {
        String str = "226";

        System.out.println(decode(str));
    }

    static int decode(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int n = str.length();

        int[] arr = new int[n + 1];

        arr[0] = 1;
        arr[1] = str.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {

            int first = Integer.valueOf(str.substring(i - 1, i));
            int second = Integer.valueOf(str.substring(i - 2, i));

            if (first >= 1 && first <= 9) {
                int iMinus1 = arr[i - 1];
                arr[i] = arr[i] + iMinus1;
            }

            if (second >= 10 && second <= 26) {
                int iMinus2 = arr[i - 2];
                arr[i] = arr[i] + iMinus2;
            }
        }
        return arr[n];
    }


}
