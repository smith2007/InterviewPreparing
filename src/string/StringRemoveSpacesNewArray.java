package string;

public class StringRemoveSpacesNewArray {

    public static void main(String[] args) {
        String str = "Andrey Alexandrovich Nevedin ";

        //"AndreyAlexandrovichNevedin"

        System.out.println(removeSpaces(str));
    }


    /**
     * самый тупой и банальный способ - набрать в новый массив
     *
     */
    static String removeSpaces(String str) {
        char[] charArray = str.toCharArray();
        char space = ' ';

        int spaceCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == space) {
                spaceCount++;
            }
        }

        if (spaceCount == 0) {
            return str;
        }

        char[] newCharArray = new char[charArray.length - spaceCount];
        for (int i = 0, j = 0; i < charArray.length; i++) {
            if (charArray[i] != space) {
                newCharArray[j] = charArray[i];
                j++;
            }
        }

        return new String(newCharArray);
    }
}
