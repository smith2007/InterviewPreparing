package greedy;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {

    /**
     * дан массив чаров который представляет собой задачи для CPU которые надо выполнить, массив содержит заглавные буквы от A до Z
     * где каждая буква представляет собой как бы отдельную задачу
     *
     * задачи могут быть выполнены не в том порядке в котором представленны в массиве, каждый таск может быть выполнен в одном интервале
     * для каждого интервала цпу может завершить одну задачу или просто простаивать.
     *
     * Однако существует неотрицательный интервал охлаждения n, который означает, что между двумя одинаковыми задачами должно быть не менее n интервалов, в течение которых ЦПУ выполняет разные задачи или просто простаивает.
     *
     * Вам необходимо вернуть наименьшее количество интервалов, которое ЦПУ будет выполнять для выполнения всех заданных задач.
     *  
     * Example:
     * Input: tasks = ["A","A","A","B","B","B"], n = 2 - кол-во интервалов после которого надо выполнить охлаждение
     * Output: 8
     * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
     */

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        // ответ будет 104 потому что надо положить сначала A затем B потом сделать еще 49 пробелов и только потом опять А
        System.out.println(leastInterval(tasks, 50));
    }

    static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.merge(c, 1, Integer::sum);
        }

        //нам надо трекать максимальное кол-во задач не важно какого типа
        //это значит что это максимальное кол-во задач надо обслужить и делать между ними
        //перерывы из пробелов или других задач не важно, главное посчиать максимум
        int maximumTasksCountByAnyType = 0;

        // так же считаем сколько таких максимумом всего
        //например максимальное кол во тасков А = 3, но и тасков B тоже 3 соотв maxCount = 2
        int maximumOfMaximums = 1;
        //берем каждый тип таски, а именно ее кол-во
        for (int currTaskCount : map.values()) {
            if (currTaskCount == 0) {
                continue;
            }

            if (maximumTasksCountByAnyType < currTaskCount) {
                maximumTasksCountByAnyType = currTaskCount;
                maximumOfMaximums = 1;
            } else if (maximumTasksCountByAnyType == currTaskCount) {
                maximumOfMaximums++;
            }
        }

        //в конце расчитываем кол-во слотов в нашем как бы массиве
        // maximumTasksCountByAnyType - 1 - потому что последняя итерация на хвосте,
        //например A B + 49 idle + A B + 49 idle + A B - последняя A B не требует отдыха
        int res = (n + 1) * (maximumTasksCountByAnyType - 1);
        int slotsCount = res + maximumOfMaximums;

        //предположим у нас массив из тасок A A A B B B
        // - соотв максимум по кол-ву = 3 а максимум максимов у нас = 2
        //кол во пробелов между каждым из тасков должно быть 50
        //соотв сколько слотов должно ?? 104 которое выходит из A B + 49 idle + A B + 49 idle + A B = 104

        //а кол-во элементов в изначальном массиве оно вообще больше чем
        // то кол-во спейсов которое нам надо для того что бы разместить?
        //если да то приоритет отдаем общем кол-ву элементов
        return (slotsCount < tasks.length) ? tasks.length : slotsCount;
    }
}
