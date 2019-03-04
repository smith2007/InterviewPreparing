package string;

public class StringReverse {


    public static void main(String[] args) {
        StringReverse.reverse("andrey");
    }

/*
    как перевернуть строчку?

    словесное описание такое, поступает на вход строка -
     представляем ее в виде массива символов и запускаем цикл по двум переменным i и j

    где i = 0

    а j = длинне строки

    далее делаем обычный своп через 3 переменную темп

    и меняем итый элемент с жытым

    до тех пор пока итый и жытый не встретятся по середине*/
    private static String reverse(String input) {
        char[] chars = input.toCharArray();

        System.out.println("before " + String.valueOf(chars));

        //бежим по массиву до тех пор пока i и j не встретятся
        //делаем своп
        //для этого вводим два индекса i и j
        //индекс начала и индекс конца
        //соотв. i++ а j--
        //условие работы цикла - i<j
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char tempChar = chars[i];
            chars[i] = chars[j];
            chars[j] = tempChar;
        }

        System.out.println("after " + String.valueOf(chars));
        return String.valueOf(chars);

    }
}
