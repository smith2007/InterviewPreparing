package binary_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeandDeserializeNaryTree {


  /**
   * идея в том что мы будем фиксировать размер наших детей
   * то есть сколько нам надо прочитать символово из строчки
   *
   * для сериализации работаем рекурсивно
   */
  // Encodes a tree to a single string.
  public String serialize(Node root) {
    List<String> list = new LinkedList<>();
    serializeHelper(root, list);
    return String.join(",", list);
  }

  private void serializeHelper(Node root, List<String> list) {
    if (root != null) {
      list.add(String.valueOf(root.val));// кладем занчение и кол-во детей
      list.add(String.valueOf(root.children.size()));
      for (Node child : root.children) {
        serializeHelper(child, list);//вызываем рекурсивно на каждом из детей
      }
    }
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    if (data.isEmpty()) {
      return null;
    }

    String[] splitted = data.split(",");
    Queue<String> q = new LinkedList<>(Arrays.asList(splitted));
    return deserializeHelper(q);
  }

  private Node deserializeHelper(Queue<String> q) {
    Node root = new Node();

    root.val = Integer.parseInt(q.poll()); //cсамо значение
    int size = Integer.parseInt(q.poll()); //берем размер

    root.children = new ArrayList<>(size);
    for (int i = 0; i < size; i++) { //вычитываем нужное кол-во элементов
      root.children.add(deserializeHelper(q));
    }
    return root;
  }


  class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
      this.val = val;
    }

    public Node(int val, List<Node> children) {
      this.val = val;
      this.children = children;
    }
  }
}
