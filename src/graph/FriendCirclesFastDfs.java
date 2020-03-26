package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FriendCirclesFastDfs {

  public static void main(String[] args) {

    FriendCirclesFastDfs friendCircles = new FriendCirclesFastDfs();

    int[][] matrix = {{1, 0, 0, 1},
        {0, 1, 1, 0},
        {0, 1, 1, 1},
        {1, 0, 1, 1}};

    System.out.println(friendCircles.findCircleNum(matrix));
  }

  /**
   * очень очень простой подход, не надо строить никаких графоф, спец классов - Student
   * просто тупо гуляем по матрице и посещам ноды - фиксируя в массив визититов
   */
  public int findCircleNum(int[][] matrix) {
    //создаем массив посещенных
    boolean[] visited = new boolean[matrix.length];
    int count = 0;

    //траверсим каждую ноду
    for (int i = 0; i < matrix.length; i++) {
      //если данного чувака не посещали ранее
      //а посещать мы его, или его потенциальных друзей будем в dfs-e
      //тогда это новый круг друзей
      if (!visited[i]) {
        dfs(matrix, visited, i);
        count++;
      }
    }
    return count;
  }

  private void dfs(int[][] matrix, boolean[] visited, int student) {
    for (int friend = 0; friend < matrix.length; friend++) {
      if (matrix[student][friend] == 1 && !visited[friend]) {
        //мы нашли не посещенного другана
        //раскрашиваем в глобальном массиве посещенных его
        visited[friend] = true;
        //и ныряем уже с ним
        dfs(matrix, visited, friend); //Start DFS on this new found student
      }
    }
  }
}
