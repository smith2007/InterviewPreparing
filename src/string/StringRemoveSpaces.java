package string;

public class StringRemoveSpaces {

    public static void main(String[] args) {
        char[] str = "Andrey Alexandrovich Nevedin".toCharArray();
        int i = remove(str);
        System.out.println(String.valueOf(str).subSequence(0, i));
    }

    static int remove(char[] str) {
        int count = 0;

        for (int i = 0; i < str.length; i++) {
            char currentChar = str[i];
            if (currentChar != ' ') {
                str[count] = currentChar;
                count = count + 1;
            }
        }


        return count;
    }


}
