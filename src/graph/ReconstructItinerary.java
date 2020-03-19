package graph;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {

        ArrayList<List<String>> tickets = new ArrayList<>();

        tickets.add(List.of("JFK", "SFO"));
        tickets.add(List.of("JFK", "ATL"));
        tickets.add(List.of("SFO", "ATL"));
        tickets.add(List.of("ATL", "JFK"));
        tickets.add(List.of("ATL", "SFO"));

        List<String> itinerary = findItinerary(tickets);


        for (String s : itinerary) {
            System.out.println(s);
        }

    }

    /**
     * задача решшается через граф и бэктрекинг
     */
    static List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.size() == 0) {
            return result;
        }

        //строим граф епта
        //наш граф будет мапа, ключ это имя аэропорта
        //и массив вариантов куда можно улететь
        //строим граф
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {

            if (!graph.containsKey(ticket.get(0))) {
                ArrayList<String> neighbors = new ArrayList<>();
                neighbors.add(ticket.get(1));
                graph.put(ticket.get(0), neighbors);
            } else {
                List<String> newNeighbors = graph.get(ticket.get(0));
                newNeighbors.add(ticket.get(1));
                graph.put(ticket.get(0), newNeighbors);
            }

        }

        //так как в условиях задачи сказано что летать надо по алфавитному порядку если что
        //то сортируем массивы соседей - городов куда можно улететь
        for (List<String> a : graph.values()) {
            Collections.sort(a);
        }

        backtrack(result, "JFK", graph);
        return result;
    }

    //ну и дальше бектрекинговый обход с массивом резов
    static void backtrack(List<String> res, String current, Map<String, List<String>> graph) {

        //у нас на руках каррент и его дети нам надо строить цепочки  то есть класть в массив резов
        //крутимся до тех пор пока массив соседей есть - то есть мы будем вырезать из массива соседей
        while (graph.containsKey(current) && !graph.get(current).isEmpty()) {

            //очень внимательно как мы тут удаляем элемент из массива соседей
            //мы берем первый и уаляем из массива
            String s = graph.get(current).remove(0);
            backtrack(res, s, graph);
        }
        //сразу берем и накладываем наш текущий каррент - отправная точка а дальше кладется
        //его ребенок но уже в методе backtrack
        res.add(0, current);
    }
}
