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
     * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
     */

    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        ArrayList<List<String>> res = new ArrayList<>();
        if (accounts.isEmpty()) {
            return res;
        }


        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {

            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                List<Integer> indexes = map.getOrDefault(email, new ArrayList<>());
                indexes.add(i);
                map.put(email, indexes);
            }


        }

        Set<String> mergedSet = new HashSet<>();
        for (String email : map.keySet()) {

            if (mergedSet.contains(email)) {
                continue;
            }
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


        for (String email : map.keySet()) {

            if (mergedSet.contains(email)) {
                continue;
            }
            List<Integer> listOfIndexesForMerge = map.get(email);
            if (listOfIndexesForMerge.size() == 1) {
                res.add(accounts.get(listOfIndexesForMerge.get(0)));
                mergedSet.add(email);
            }
        }
        return res;
    }
}
