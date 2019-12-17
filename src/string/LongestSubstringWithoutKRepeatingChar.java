package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutKRepeatingChar {

    /**
     * дана строка и дан n,
     * требуется найти саму длинную подстроку с n - уникальными символами
     * думай как решить, думай что надо вернуть как резульат, а вернуть надо
     * по сути подстроку то есть два указателя должно быть на начало подстроки и на конец подстроки
     * следовательно сразу на ум - паттер - два указателя
     * суть решения следующая - взять два указателя один i второй j
     * они будут ссылаться на начало и на конец подстроки
     *
     * для того что бы контролилровать уникальность символов будем использовать хэшмапу с каунтом
     * сколько и каких символов мы встретили
     * ну и что и крутимся в цикле, фиксируем каждый символ, прибавляем каунт двигаем максимально житый
     * то есть правый указатель, до тех пока не наткнемся на ситуацию в при которой у нас максимальное число символов
     * привысит поданный на воход n, фиксируем границы, двигаем левый указатель
     */
    public static void main(String[] args) {
        String str = "abbbbaaccccf";
        int n = 2;


        //abbbbaa
        System.out.println("Longest substring is " + find(str, n));
    }

    static String find(String str, int k) {
        char[] chars = str.toCharArray();
        int start = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;

        while (true) {
            if (map.size() == k) {
                if ((j - i) > (end - start)) {
                    start = i;
                    end = j;
                }
            } else if (map.size() > k) {
                while (map.size() > k) {
                    char chari = chars[i];
                    Integer newCounti = map.get(chari) - 1;
                    if (newCounti == 0) {
                        map.remove(chari);
                    } else {
                        map.put(chari, newCounti);
                    }
                    i++;
                }
            }

            if (j > chars.length - 1) {
                break;
            }

            Integer countj = map.get(chars[j]);
            if (countj == null) {
                map.put(chars[j], 1);
            } else {
                map.put(chars[j], countj + 1);
            }
            j++;
        }

        if ((j - i) > (end - start)) {
            start = i;
            end = j;
        }


        return str.substring(start, end);
    }
}
