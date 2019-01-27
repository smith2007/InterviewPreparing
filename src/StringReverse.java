
public class StringReverse {


    public static void main(String[] args) {
        StringReverse.reverse("andrey");
    }

    public static String reverse(String input) {
        char[] chars = input.toCharArray();

        System.out.println("before " + String.valueOf(chars));

        //бежим по массиву до тех пор пока i и j не встретятся
        //делаем своп
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char tempChar = chars[i];
            chars[i] = chars[j];
            chars[j] = tempChar;
        }

        System.out.println("after " + String.valueOf(chars));
        return String.valueOf(chars);

    }
}
