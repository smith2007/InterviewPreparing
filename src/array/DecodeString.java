package array;

public class DecodeString {

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
        StringBuilder result = new StringBuilder();
        int i = 0;

        StringBuilder strCount = new StringBuilder();

        while (true) {
            if (chars[i] != '[') {
                if (chars[i] != ']') {
                    strCount.append(chars[i]);
                }
                i = i + 1;
            } else {
                int count = Integer.parseInt(strCount.toString());
                strCount = new StringBuilder();

                result.append(String.valueOf(chars[i + 1]).repeat(Math.max(0, count)));
                i = i + 2;
            }

            if (i >= chars.length) {
                break;
            }
        }
        return result.toString();

    }

}
