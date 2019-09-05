package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SocialNetworkRecomendationAlgorithm {

    static class Relation {
        int first;
        int second;

        Relation(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {

        //{{1,2}, {2,5}, {1,4}, {5,8}, {4,8}, {2,8}}

        List<Relation> relations = new ArrayList<>();
        relations.add(new Relation(1, 2));
        relations.add(new Relation(2, 5));
        relations.add(new Relation(1, 4));
        relations.add(new Relation(5, 8));
        relations.add(new Relation(4, 8));
        relations.add(new Relation(2, 8));

        System.out.println(find(relations, 1));
    }

    /**
     * строим граф, смотрим друзей потом друзей друзей, исключаем себя самого и считаем каунтером
     */
    static int find(List<Relation> relations, int userId) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (Relation relation : relations) {

            int first = relation.first;

            List<Integer> firstNeigh = map.get(first);

            if (firstNeigh == null) {
                ArrayList<Integer> neigh = new ArrayList<>();
                neigh.add(relation.second);
                map.put(first, neigh);
            } else {
                firstNeigh.add(relation.second);
                map.put(first, firstNeigh);
            }


            int second = relation.second;
            List<Integer> secondNeigh = map.get(second);
            if (secondNeigh == null) {
                ArrayList<Integer> neigh = new ArrayList<>();
                neigh.add(relation.first);
                map.put(second, neigh);
            } else {
                secondNeigh.add(relation.first);
                map.put(second, secondNeigh);
            }


        }

        List<Integer> userFriends = map.get(userId);

        HashMap<Integer, Integer> potentialFriendCounter = new HashMap<>();

        int max = 0;
        int potentialFriendId = 0;
        for (Integer userFriend : userFriends) {
            List<Integer> friendsOfFriend = map.get(userFriend);
            if (userFriend == userId) {
                continue;
            }
            for (Integer friendOfFriend : friendsOfFriend) {
                if (friendOfFriend == userId) {
                    continue;
                }
                Integer friendOfFriendCount = potentialFriendCounter.get(friendOfFriend);
                if (friendOfFriendCount == null) {
                    potentialFriendCounter.put(friendOfFriend, 1);
                    if (max == 0) {
                        max = 1;
                        potentialFriendId = friendOfFriend;
                    }
                } else {
                    potentialFriendCounter.put(friendOfFriend, friendOfFriendCount + 1);
                    if (max < friendOfFriendCount + 1) {
                        max = friendOfFriendCount + 1;
                        potentialFriendId = friendOfFriend;
                    }
                }
            }

        }

        return potentialFriendId;
    }
}
