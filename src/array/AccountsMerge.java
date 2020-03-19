package array;

import java.util.*;

public class AccountsMerge {

    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();

        input.add(List.of("John", "johnsmith@mail.com", "john00@mail.com"));
        input.add(List.of("John", "johnnybravo@mail.com"));
        input.add(List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        input.add(List.of("Mary", "mary@mail.com"));


        for (List<String> strings : accountsMerge(input)) {
            for (String string : strings) {
                System.out.print(string + " ");
            }


            System.out.println();
        }

    }

    /**
     * input
     * [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],
     * ["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],
     * ["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],
     * ["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],
     * ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
     * <p>
     * <p>
     * my
     * [["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],
     * ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"],
     * ["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],
     * ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"],
     * ["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],
     * ["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],
     * ["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],
     * ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"],
     * ["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],
     * ["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],
     * ["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"]]
     * <p>
     * <p>
     * needed
     * <p>
     * [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],
     * ["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],
     * ["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],
     * ["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],
     * ["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
     */

    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        ArrayList<List<String>> res = new ArrayList<>();
        if (accounts.isEmpty()) {
            return res;
        }


        Map<String, List<Integer>> map = new HashMap<>();
// набиваем мапу гле ключ - имейл а значение массив индексов из основновного массива откуда пришел этот имейл
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                List<Integer> indexes = map.getOrDefault(email, new ArrayList<>());
                indexes.add(i);
                map.put(email, indexes);
            }


        }

        //флаги говорящие о том что этот имейл смержен и его не трогать
        Set<String> mergedSet = new HashSet<>();
        for (String email : map.keySet()) {

            if (mergedSet.contains(email)) {
                continue;
            }

            //первый проход рассматриваем только те у кого больше чем 1
            //тех кого реально надо мержить
            List<Integer> listOfIndexesForMerge = map.get(email);
            if (listOfIndexesForMerge.size() > 1) {

                List<String> forMerge = new ArrayList<>();
                forMerge.add(accounts.get(listOfIndexesForMerge.get(0)).get(0));
                Set<String> treeSet = new TreeSet<>();
                for (Integer index : listOfIndexesForMerge) {
                    List<String> account = accounts.get(index);

                    for (int i = 1; i < account.size(); i++) {
                        String mergingEmail = account.get(i);
                        treeSet.add(mergingEmail);
                        mergedSet.add(mergingEmail);
                    }
                }
                forMerge.addAll(treeSet);
                res.add(forMerge);
            }
        }


        //второй проход добавляем те кто остался недомерженным
        for (String email : map.keySet()) {
            if (mergedSet.contains(email)) {
                continue;
            }
            //а не домерженными остались только элементы с одним имейлом - уникальные
            List<Integer> listOfIndexesForMerge = map.get(email);
            res.add(accounts.get(listOfIndexesForMerge.get(0)));
            mergedSet.add(email);

        }
        return res;
    }
}
