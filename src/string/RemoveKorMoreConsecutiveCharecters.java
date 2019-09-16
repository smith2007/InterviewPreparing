package string;

import java.util.Collections;

public class RemoveKorMoreConsecutiveCharecters {

    /**
     *
     дана строка  "aaabbbc" и дано число к = 3, например

     необходимо вернуть строку которая удаляет k или больше подряд идущих символа

     так неожиданно много времени занял алгоритм

     тут суть в чем, мы делаем два указателя и локальный счетчик, крутимся в цикле вайл, первый указатель бежит вперед до тех пор пока не встретится буква отличная от первого указателя попутно инкрементируя счетчик, как только мы понимаем что буква различная или первый указатель добежал до конца

     выход из цикла

     смотрим а не превышает ли наша подстрока длинну к, если не превышает берем итый символ который сзади и че делаем и добавляем в результирующую строку

     в конце итерации мы устанавливаем оба указателя в одно место - i = j


     сложность по времени: О(n)
     сложность по памяти: О(n)
     */
    public static void main(String[] args) {
        String str = "aaabbbccacc";

        System.out.println(replace(str, 3));

    }

    static String replace(String str, int k) {
        String result = "";
        int i = 0;
        int j = 0;

        while (j < str.length()) {
            int count = 0;
            while (j < str.length() && str.charAt(j) == str.charAt(i)) {
                count++;
                j++;
            }

            if (count < k) {
                char c = str.charAt(i);
                String join = String.join("", Collections.nCopies(count, Character.toString(c)));
                result += join;
            }
            i = j;

        }
        return result;
    }
}
