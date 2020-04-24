package binary_tree;

public class ConstructQuadTree {

  public Node construct(int[][] grid) {
    return dfs(grid, 0, 0, grid.length);
  }

  /**
   * так ну как бы я делал, я бы первым шагом разделил квадрат на 4 части - это будут наши ноды,
   * затем рекурсивно запустил каждой ноде метод построения узлов нашего дерева передавая
   * родительскую ноду, и так далее
   */
  private Node dfs(int[][] grid, int x, int y, int len) {
    if (len == 1) {
      return new Node(grid[x][y] == 1, true, null, null, null, null);
    }

    Node nodeTL = dfs(grid, x, y, len / 2);
    Node nodeTR = dfs(grid, x, y + len / 2, len / 2);
    Node nodeBL = dfs(grid, x + len / 2, y, len / 2);
    Node nodeBR = dfs(grid, x + len / 2, y + len / 2, len / 2);

    // Merge all child nodes
    if (nodeTL.isLeaf && nodeTR.isLeaf && nodeBL.isLeaf && nodeBR.isLeaf) {
      if (nodeTL.val && nodeTR.val && nodeBL.val && nodeBR.val) {
        return new Node(true, true, null, null, null, null);
      }
      if (!nodeTL.val && !nodeTR.val && !nodeBL.val && !nodeBR.val) {
        return new Node(false, true, null, null, null, null);
      }
    }
    return new Node(true, false, nodeTL, nodeTR, nodeBL, nodeBR);
  }

  static class Node {

    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
      this.val = false;
      this.isLeaf = false;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft,
        Node bottomRight) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = topLeft;
      this.topRight = topRight;
      this.bottomLeft = bottomLeft;
      this.bottomRight = bottomRight;
    }
  }

  ;
}
