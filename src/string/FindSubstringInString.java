package string;

public class FindSubstringInString {

    public static void main(String[] args) {
        String str1 = "abababababaaba";
        String str2 = "abaa";

        System.out.println(find(str1, str2));

    }

    /**
     *
     поиск подстроки в строке

     даны две строки:

     1 - “ababababababaa”
     2 - “abaa”

     нужно вернуть индекс начала этой второй подстроки в первой строке

     тут хэширование вступает в дело, ты должен посчитать свой какой-то умный хэш от второй строчки, и далее идти по первой строке и высчитывать хэш от подстроки нужного размера в ней (первой подстроки)

     остается проблема, как посчитать по умному хэш, для этого надо разработать свой алгоритм основанный на своей системе счисления, предположим что у нас только английские буквы в нижнем регистре всего букв в алфавите 26, делаем свою 26-ричную систему счисления

     потом идя по второй строке мы будем поочередно убирать и добавлять разряды

     возникает резонный вопрос, на который ты затупил как последняя сволочь, как убирать и добавлять разряды у твоего хэша???


     давай проведем аналогию с 10-ричной системой:

     вот есть число 123 как оно получилось? а получилось оно так первый разряд - 1 сотни , второй разряд - 2 десятки, третий разряд - 3 - единицы

     ((1*10+2)*10)+3 = 123

     как из 123 сделать например 1235, то есть добавить разряд слева???

     очень просто, та же формула (((1*10+2)*10)+3)*10+5 = 123*10 = 1230 +5 = 1235

     как из числа 1235 убрать разряд справа опять включаем голову как получить из 1235 235?

     надо поделить на 1000 и взять остаток от деления, то что будет после запятой то есть 1235/1000 = 1,235 = 235

     а что такое тысяча? тысяча это 10*10*10 то есть 10^3 откуда взялась трешка? это кол-во разрядов помимо первого, эврика вот он подход

     только английский алфавит состоит не из 10 символов, а из 26 следовательно надо делать 26 ричную систему счисления и похожие методы работы с ее разрядами, то есть не 10^3 а 26^3 - в случае удаления разряда, то есть не на 10 умножать как в первом варианте а на 26 и так далее

     но возникает ризонный вопрос, как получить номер определенной буквы? каждый символ в джаве это charecter - он кастится к инту, ну окей кастится как сделать так что бы номер получить мы знаем что ‘a’ - это первый символ а ‘z’ это 26ой, по этому даже какой-то там номер есть у a = 1231231 (спойлер, на самом деле у него 97 что ли) у z будет смещение на 26 = 1231231+26 по этому чо, отнимаем от нашего абстрактного символа ‘a’и получаем номер который потом естественно умножаем на 26

     */

    static int find(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int hash2 = 0;

        for (char ch : chars2) {
            int shash2 = (ch - 'a');
            hash2 = (hash2 * 26) + shash2;
        }

        int i = 0, j = 0;
        int hash1 = 0;

        while (true) {
            int shash1 = (chars1[j] - 'a');
            hash1 = (hash1 * 26) + shash1;

            if (((j - i) + 1 == chars2.length)) {
                if (hash1 == hash2) {
                    return i;
                } else {
                    int pow = (int) Math.pow(26, chars2.length - 1);
                    hash1 = hash1 % pow;
                    i++;
                    j++;
                }
            } else {
                j++;
            }

            if (j > chars1.length - 1) {
                break;
            }
        }

        throw new RuntimeException("ther is no substring");

    }

}