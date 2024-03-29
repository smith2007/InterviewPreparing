package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    // указываем максимальное кол-во вершин
    // соответсвенно будет создан граф со столькими вершинами
    // каждая вершина - имеет свой номер
    int numberOfVertices;

    //массив соседей
    //каждый индекс - условно - номер вершины
    //каждый элемент - массив из списка соседей
    List<List<Integer>> nodesAndNeighbors;

    //конструктор инициализирует вершины
    //ставит пустой список соседей
    Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        nodesAndNeighbors = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            nodesAndNeighbors.add(new ArrayList<>());
        }
    }

    //добавляем соседей то есть ребра
    void addEdge(int vertex, int newAdjacency) {
        nodesAndNeighbors.get(vertex).add(newAdjacency);
    }

}
