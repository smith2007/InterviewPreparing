package greedy;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(tasks, 2));
    }

    static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.merge(c, 1, Integer::sum);
        }

        //нам надо трекать максимальное кол-во задач
        int max = 0;
        int count = 1;
        //берем каждый тип таски, а именно ее кол-во
        for (int taskCount : map.values()) {
            if (taskCount == 0) {
                continue;
            }
            if (max < taskCount) {
                max = taskCount;
                count = 1;
            } else if (max == taskCount) {
                count++;
            }
        }
        //в конце расчитываем кол-во пробелов
        int res = (n + 1) * (max - 1);
        int space = res + count;
        //а кол-во элементов в мапе оно вообще больше чем то кол-во спейсов которое нам надо для того что бы разместить?
        //если да то приоритет отдаем общем кол-ву элементов
        return (space < map.values().size()) ? map.size() : space;

    }
}
