package array;

public class StringTransform1A2B3CWithBrackets {

    // 2[a]3[b]10[c] - aabbbc
    public static void main(String[] args) {
        String str = "2[a]3[b]20[c]";
        System.out.println(transform(str));
    }


    /**
     * алгоритм до безобразия прост, делаем указатель
     * бежим по массиву, накручиваем счетчик того сколько надо раз напечатать ту или иную букву
     * как только встретили закрывающуюся скобку все, стоп берем i+1 элемент - он и будет нашим символом
     * печатаем его столько раз сколько набежал счетчик, все потом двигаем i
     * на определнное кол-во символов (на два условно)
     */

    static String transform(String str) {
        char[] chars = str.toCharArray();
        String result = "";
        int i = 0;

        String strCount = "";

        while (true) {
            if (chars[i] != '[') {
                if (chars[i] != ']') {
                    strCount += chars[i];
                }
                i = i + 1;
            } else {
                Integer count = Integer.parseInt(strCount);
                strCount = "";

                for (int j = 0; j < count; j++) {
                    result += chars[i + 1];
                }
                i = i + 2;
            }

            if (i >= chars.length) {
                break;
            }
        }
        return result;

    }

}
