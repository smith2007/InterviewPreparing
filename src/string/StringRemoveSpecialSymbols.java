package string;

public class StringRemoveSpecialSymbols {


    public static void main(String[] args) {
        char[] str = "And@rey".toCharArray();
        char symbol = '@';

        int newLength = hack(str, symbol);
        System.out.println(String.valueOf(str).substring(0, newLength));
        // Andrey
    }


    static int hack(char[] str, char symbol) {
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != symbol) {
                str[count] = str[i];
                count++;
            }
        }

        return count;
    }
}
