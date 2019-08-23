package string;

public class URLifyString2 {

    public static void main(String[] args) {

        // так как в джаве строки иммутабл то без доп памяти никак
        // по этому имеем ввиду что вместо строки подаем на вход массив чаров
        // с заранее известной длинной, которой хватит на все наши проценты двадцать

        String string = "Mr Jonh Smith    "; // длинна 17
        char[] str = string.toCharArray();
        System.out.println("Before: " + string);

        urlify(str);

        System.out.println("After: " + String.copyValueOf(str));

        /*
        Before: Mr Jonh Smith
        After: Mr%20Jonh%20Smith

         */

    }

    /**
     * мутируем текущий массив чаров
     * подход до боли очевидный бежим с конца имея ввиду что в конце
     * находится некая буферная зона в которой пробелы, как только встретили не пробел
     * все буфераная зона кончилась, это значит пора раздвигать наши слова
     * для этого делаем своп первого символа с последним элементом который у нас пробел
     * сдвигаем сдвигаем сдвигаем, как только встретили опять пробел (после прохождения буферной зоны конечно же)
     * это значит что дальше индекс не пустого элемента конца нужно сместить на 3 элемента
     * что бы потом туда запихнуть наш злополучный %20
     * и все, на выходе после первого цикла получили строку где вместо одного пробела у слов 3 пробела
     *
     * вторая итерация просто вместо этих 3 пробелов вставляет посимвольно %20
     */
    static void urlify(char[] str) {

        int length = str.length;
        int lastIndex = length - 1;
        int lastTempIndex = lastIndex;

        boolean isBufferZoneOff = false;
        // будем бежать с конца, им
        for (int i = lastIndex; i >= 0; i--) {
            if (str[i] != ' ') {
                isBufferZoneOff = true;
                char temp = str[i];
                str[i] = str[lastTempIndex];
                str[lastTempIndex] = temp;
                lastTempIndex--;
            } else if (isBufferZoneOff) {
                lastTempIndex = lastTempIndex - 3;
            }
        }
        for (int i = 0; i < str.length; ) {
            if (str[i] == ' ') {
                str[i] = '%';
                str[i + 1] = '2';
                str[i + 2] = '0';
                i = i + 3;
            } else {
                i++;
            }
        }
    }
}
