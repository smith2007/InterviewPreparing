package string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class ReorderDatainLogFiles {

    public static void main(String[] args) {
        String[] logs =
                {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car"};

        String[] strings = reorderLogFiles(logs);

        for (String string : strings) {
            System.out.println(string);
        }


        /**
         * ["a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
         */
    }


    /**
     * 239.ReorderDatainLogFiles
     * <p>
     * https://leetcode.com/problems/reorder-data-in-log-files/
     * <p>
     * у нас есть массив логов - каждая строчка лога это строка разделенная пробелаи
     * для каждого лога первое слово это айдишник который alphanumeric то есть состоит из чисел и слова
     * <p>
     * - каждое слово после айдишника состоит только слов в нижнем регистре или состоит только из чисел
     * <p>
     * мы будем вызвать эти две варианта логов letter-logs и digit-logs - это гарантированно что каждый лог содержит как минимум одно слово после айдишника
     * <p>
     * сделай Reorder то есть перегруппируй логи таким образом все логи с буквами стояли ДО логов с числами
     * letter-logs - отсортированны по алфавиту игнорируя айдишники
     * digit-logs - должны расположтся по результату в их оригинальном порядке
     * <p>
     * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
     * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
     * <p>
     * я решал через тримапу в которой ключ это контент (буквенных логов) а значение это сам лог строчки причем мапа сортирует ключи в обратном порядке
     * new TreeMap<>(Comparator.reverseOrder());
     * <p>

     */
    static String[] reorderLogFiles(String[] logs) {

        if (logs.length == 0) {
            return logs;
        }

        List<String> res = new ArrayList<>();

        // я решал через тримапу в которой ключ это контент (буквенных логов)
        // а значение это сам лог строчки причем мапа сортирует ключи в обратном порядке
        TreeMap<String, List<String>> treeMap = new TreeMap<>(Comparator.reverseOrder());

        //мы итерейтим наши логи сплитим по первому пробелу log.substring(log.indexOf(' ') + 1);
        // - получаем контент нашего лога, далее нужно решить что это? это буквенный или числовой
        //проверяем первый символ если число - сразу добавляем в массив резов нашу целую строчку
        for (String log : logs) {
            String content = log.substring(log.indexOf(' ') + 1);

            if (Character.isDigit(content.charAt(0))) {
                res.add(log);
            } else {
                List<String> collector = treeMap.getOrDefault(content, new ArrayList<>());
                collector.add(log);
                treeMap.put(content, collector);
            }

        }

        for (String key : treeMap.keySet()) {
            List<String> strings = treeMap.get(key);
            for (String string : strings) {
                res.add(0, string);
            }
        }

        String[] arr = new String[res.size()];
//в конце итерейтим нашу мапу и дообгощаем наш массив резов сначала
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }


}
