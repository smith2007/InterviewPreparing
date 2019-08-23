package string;

public class StringReverse2 {

    /**
     * дана строчка нужно ее перевернуть
     * желательно за один проход
     */
    public static void main(String[] args) {
        String originalString = "andrey";
        char[] str = originalString.toCharArray();
        System.out.println("Original string : " + originalString);
        System.out.println("Reversed string : " + String.copyValueOf(reverse(str)));
    }


    // какие еще есть варианты, ну если вариант например создать вторую строчку,
    // но тогда получится что надо создават новую строку, а это по памяти не норм
    // ну тут надо откровенно заметить что строка в джаве не изменяемая по этому
    // все что мы говорим это только про массив чаров

    /**
     * если я не путаю то самый нормальный путь это взять середину
     * и вокруг середины свопать элемент
     * получится линейное время
     * путаешь это путь не наш
     */
    static char[] reverse(char[] str) {
        for (int i = 0, j = str.length - 1; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
        return str;
    }
}
