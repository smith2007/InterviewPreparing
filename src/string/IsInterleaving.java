package string;

public class IsInterleaving {

    /**
     * тупо брать
     * является ли третяя строка
     * составной из двух
     * <p>
     * первое что приходит в голову - сконкатенировать a и b
     * <p>
     * далее отсортировать с и конкатенированную строку
     * далее чо, далее делаем сравнение посимвольно
     */
    public static void main(String[] args) {
        String a = "XY";
        String b = "WZ";

        String c = "XZWY";

        //true
        boolean result = isInterleaved(a, b, c);

        System.out.println(result);

    }


    //типа динамическое программирование
    //создаем матрицу булеанов с запасом в одно поле, на одно длинне чем надо
    static boolean isInterleaved(String s1, String s2, String s3) {

        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        //матрица
        boolean[][] temp = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                //по дефолту заполняем нулевой символ как true
                if (i == 0 && j == 0) {
                    temp[i][j] = true;
                } else {

                    int k = i + j - 1;

                    if (i == 0) {
                        //если это нулевая строка
                        char s2char = s2.charAt(j - 1);
                        char s3char = s3.charAt(k);
                        temp[i][j] = temp[i][j - 1] && s2char == s3char;
                    } else if (j == 0) {
                        //если это нулевой столбец
                        char s1char = s1.charAt(i - 1);
                        char s3char = s3.charAt(k);
                        temp[i][j] = temp[i - 1][j] && s1char == s3char;
                    } else {
                        char s1char = s1.charAt(i - 1);
                        char s2char = s2.charAt(j - 1);
                        char s3char = s3.charAt(k);
                        temp[i][j] = (temp[i - 1][j] && s1char == s3char) || (temp[i][j - 1] && s2char == s3char);
                    }
                }
            }
        }
        return temp[s1.length()][s2.length()];
    }
/*
    // когда тупо состав из двух строк
    static boolean isInterleaved(String a, String b, String c) {

        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        char[] third = c.toCharArray();

        int i = 0, j = 0;

        while (true) {
            if (first[i] == third[j]) {
                i++;
                j++;
            } else {
                return false;
            }

            if (i > first.length - 1) {
                break;
            }

            if (j > third.length - 1) {
                return false;
            }
        }

        i = 0;

        while (true) {
            if (second[i] == third[j]) {
                i++;
                j++;
            } else {
                return false;
            }

            if (i > second.length - 1) {
                if (j > third.length - 1) {
                    break;
                } else {
                    return false;
                }
            }

        }

        return true;


    }*/
}
