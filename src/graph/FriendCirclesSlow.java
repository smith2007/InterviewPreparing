package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FriendCirclesSlow {

  public static void main(String[] args) {

    FriendCirclesSlow friendCircles = new FriendCirclesSlow();

    int[][] matrix = {{1, 0, 0, 1},
                      {0, 1, 1, 0},
                      {0, 1, 1, 1},
                      {1, 0, 1, 1}};

    System.out.println(friendCircles.findCircleNum(matrix));
  }

  int circle = 0;
  Map<Integer, Student> map = new HashMap<>();

  public int findCircleNum(int[][] matrix) {

    for (int i = 0; i < matrix.length; i++) {
      //рассматриваем итую строчку
      Student student = map.getOrDefault(i, new Student(i));
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 1) {
          //круто, они друзья
          //надо создать друга и добавить его в мапу
          map.putIfAbsent(j, new Student(j));
          student.directFriends.add(j);
        }
      }
      map.put(i, student);
    }

    for (Integer studentNum : map.keySet()) {
      Student student = map.get(studentNum);
      dfs(student, new HashSet<>(), ++circle);
    }

    Set<Integer> total = new HashSet<>();
    for (Student value : map.values()) {
      total.add(value.circle);
    }

    return total.size();

  }

  void dfs(Student student, Set<Student> visited, int circle) {
    if (visited.contains(student)) {
      return;
    }

    visited.add(student);

    if (student.circle == -1) {
      student.circle = circle;
      map.put(student.num, student);
    }

    for (Integer directFriend : student.directFriends) {
      dfs(map.get(directFriend), visited, circle);
    }

  }

  static class Student {

    int num;
    int circle = -1;
    List<Integer> directFriends = new ArrayList<>();

    public Student(int num) {
      this.num = num;
    }
  }
}
