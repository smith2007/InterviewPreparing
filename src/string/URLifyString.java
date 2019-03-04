package string;

public class URLifyString {

    public static void main(String[] args) {
        String str = "abc def egg";

        char[] process = process(str.toCharArray());

        System.out.println(process);
        //"abc%20def%20egg"
    }

    /**
     * самый тупой способ это конечно набрать новый массив
     * после того как встречаешь пробел - вставляешь три символа
     * <p>
     * более умный подход - использовать сдвиг в существующем массиве
     * для этого надо посчитать пробелы
     * потом сделать умный сдвиг
     * а потом на свободные места поставить %20
     */
    static char[] process(char[] str) {
        int length = str.length;
        int spaceCounter = 0;

        //First lets calculate number of spaces

        for (int i = 0; i < length; i++) {
            if (str[i] == ' ')
                spaceCounter++;
        }

        //calculate new size
        int additionalArraySize = length + 2 * spaceCounter;

        char[] newArray = new char[additionalArraySize + 1];

        newArray[additionalArraySize] = '\0';

        for (int i = 0, newArrayIndex = 0; i < length; i++) {
            if (str[i] == ' ') {
                newArray[newArrayIndex] = '%';
                newArray[newArrayIndex + 1] = '2';
                newArray[newArrayIndex + 2] = '0';
                newArrayIndex = newArrayIndex + 3;
            } else {
                newArray[newArrayIndex] = str[i];
                newArrayIndex++;
            }
        }
        return newArray;
    }
}
