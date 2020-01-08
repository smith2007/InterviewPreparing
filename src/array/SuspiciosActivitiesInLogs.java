package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SuspiciosActivitiesInLogs {

    public static void main(String[] args) {
        System.out.println(processLogs(List.of("88 99 123", "88 99 111", "99 12 99", "3 3 999"), 2));
    }

    public static List<String> processLogs(List<String> logs, int threshold) {
        // Write your code here
        if (logs == null) {
            return new ArrayList<>();
        }

        Map<String, Integer> map = new HashMap<>();
        for (String log : logs) {
            String key1 = log.split(" ")[0];
            String key2 = log.split(" ")[1];
            if (key1.equals(key2)) {
                map.merge(key1, 1, Integer::sum);
            } else {
                map.merge(key1, 1, Integer::sum);
                map.merge(key2, 1, Integer::sum);
            }
        }


        return map
                .entrySet().stream()
                .filter(e -> e.getValue() >= threshold).map(Map.Entry::getKey).sorted().collect(Collectors.toList());
    }

}

