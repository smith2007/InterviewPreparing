package graph;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] arr = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(alienOrder(arr));
    }

    //решаем с помощью bfs
    static String alienOrder(String[] words) {

        //две мапы
        Map<Character, Set<Character>> setMap = new HashMap<>();
        Map<Character, Integer> counterMap = new HashMap<>();

        //результирующий стринг билдер
        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) {
            return result.toString();
        }

        /**
         * перво наперво строим вот такую мапу counterMap
         * каждое слово, каждая буква будет положена в мапу где ключ - буква а инт - счетчик
         * w:0
         * r:0
         * t:0
         * f:0
         * e:0
         */
        for (String s : words) {
            for (char c : s.toCharArray()) {
                counterMap.put(c, 0);
            }
        }

        /**
         * дальше бегаем по массиву слов
         *
         */
        for (int i = 0; i < words.length - 1; i++) {
            //берем текущее слово
            String cur = words[i];
            //берем следующее слово
            String next = words[i + 1];

            //берем минимальную длинну из этих двух слов
            int length = Math.min(cur.length(), next.length());

            //раскручиваем цикл что бы буквы посимвольно
            for (int j = 0; j < length; j++) {

                //берем две паралельные буквы
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);

                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (setMap.containsKey(c1)) {
                        set = setMap.get(c1);
                    }
                    if (!set.contains(c2)) {
                        set.add(c2);
                        setMap.put(c1, set);
                        counterMap.put(c2, counterMap.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : counterMap.keySet()) {
            if (counterMap.get(c) == 0) {
                queue.add(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.remove();
            result.append(c);
            if (setMap.containsKey(c)) {
                for (char c2 : setMap.get(c)) {
                    counterMap.put(c2, counterMap.get(c2) - 1);
                    if (counterMap.get(c2) == 0) {
                        queue.add(c2);
                    }
                }
            }
        }
        if (result.length() != counterMap.size()) {
            return "";
        }
        return result.toString();
    }
}
