package graph;

import java.util.*;

public class CriticalConnectionsinaNetwork {

    public static void main(String[] args) {

        ArrayList<List<Integer>> connections = new ArrayList<>();
        connections.add(List.of(0, 1));
        connections.add(List.of(1, 2));
        connections.add(List.of(2, 0));
        connections.add(List.of(1, 3));

        CriticalConnectionsinaNetwork network = new CriticalConnectionsinaNetwork();
        List<List<Integer>> lists = network.criticalConnections(4, connections);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

    //дальше объявляем массив резов
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        //строим граф в виде ноды -> соседи
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (List<Integer> edge : connections) {
            //запомни putIfAbsent - означает добавь ноду в мапу если ее там нет
            graph.putIfAbsent(edge.get(0), new ArrayList<>());
            graph.putIfAbsent(edge.get(1), new ArrayList<>());
            //добавляем наши ноды - сначала как основные, а потом и соседей к ним
            graph.get(edge.get(0)).add(edge.get(1)); //к нулевой ноде будет первый сосед
            graph.get(edge.get(1)).add(edge.get(0)); // и к нашему соседу саму нулевую ноду
        }

        //на этом этапе мы уже построили граф со связями

        //будем маркировать наш путь - массив путей будет длинной n - потому что у нас в общем n нод

        int[] path = new int[n];
        //заполняем наш массив -1, -1 говорит нам о том что мы не посещали эту ноду
        //начинаем обход с нулевой ноды, в качестве родительской передаем -1
        dfs(graph, 0, 0, path, 1);
        return res;
    }

    /**
     * итак какая идея
     * итак перед нами как бы опять граф - на входе массив на этот раз граф уже представлен через релейшены
     * просто откуда куда есть связи
     * [0,1],[1,2],[2,0],[1,3]
     * <p>
     * а так же число n на входе которое характеризуется числом нод
     * <p>
     * и вот надо найти такой коннекшн который является как бы связующим звеном - то есть тот который является как бы
     * <p>
     * и так очень задросткая задача, наверное топ 3 самых задротских что я тут встречал итак в чем смысл
     * - а смысл простыми словами в том что мы будем счиать минимальный путь для каждой ноды начиная с какой-то одной, например с 0
     * <p>
     * за сколько шагов минимально можно дойти до условной итой ноды??? принимая в расчет что могут быть циклы и граф не направленный
     * <p>
     * и если мы понимаем что в условную next ноду нет других путей кроме как чрез нашу current ноду
     * - то есть результат ее dive (а результат возвращает минимальный путь) дает нам значение БОЛЬШЕЕ чем наш
     * текущий путь - ну то есть что тупо в next ноду надо идти на  1 шаг длиннее
     */
    public int dfs(Map<Integer, List<Integer>> graph, int curr, int parent, int[] paths,
                   int currPathLength) {

        //мы пришли в эту точку сразу фиксируем текущий путь, какой он длинны
        //потом мы его проапдейтим если мы поймем что кто-то из наших детей имеет
        //к нам более короткий путь - в том случае если есть цикл конечно же
        paths[curr] = currPathLength;

        // траверсим детей
        for (int child : graph.get(curr)) {

            //для того что бы избежать бесконечных циклов
            //мы проверям что нода не равна нашей родительской ноде так как граф двунаправленный/он же не направленный
            if (child == parent) {
                continue;
            }

            //проверка на то посещали ли мы уже нашу дочернюю ноду
            if (paths[child] > 0) {
                //если мы эту ноду ранее посещали, значит тут цикл и надо взять минимальный путь либо наш либо
                // тот что уже заранее кем то проставлен
                //условно говоря как быстрее достичь нашу текущую ноду?? через текущий путь или через этот чайлд
                paths[curr] = Math.min(paths[curr], paths[child]);
            } else {
                //вот тут мы оказываемя тогда когда наш путь до ребенка еще не апдейтился
                //это значит мы либо кто то другой в случае цикла эту ноду еще не посещали
                //следовательно ее надо посетить
                int pathFromChild = dfs(graph, child, curr, paths, currPathLength + 1);
                paths[curr] = Math.min(paths[curr], pathFromChild);
            }

            //вот это очень важный кусок кода
            //тут мы понимаем что путь в нашего ребенка БОЛЬШЕ чем путь к нам
            //соотв надо сделать вывод что в него нет больше других путей нежели чем через нас
            //выходит это критический коннекшн
            if (currPathLength < paths[child]) {
                res.add(Arrays.asList(curr, child));
            }
        }
        //ну и возвращаем наш текущий путь
        return paths[curr];
    }
}
