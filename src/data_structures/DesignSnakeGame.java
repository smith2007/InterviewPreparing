package data_structures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DesignSnakeGame {


  private Deque<String> snake;
  private int width, height;
  private Queue<int[]> foods;
  private Map<String, int[]> dirMap;

  /**
   * Initialize your data structure here.
   *
   * @param width  - screen width
   * @param height - screen height
   * @param food   - A list of food positions E.g food = [[1,1], [1,0]] means the first food is
   *               positioned at [1,1], the second is at [1,0].
   */
  public DesignSnakeGame(int width, int height, int[][] food) {
    this.width = width;
    this.height = height;

    snake = new ArrayDeque<>();
    snake.addLast("0,0");

    foods = new LinkedList<>();
    for (int[] f : food) {
      foods.offer(f);
    }
    dirMap = new HashMap<>();
    dirMap.put("U", new int[]{-1, 0});
    dirMap.put("L", new int[]{0, -1});
    dirMap.put("R", new int[]{0, 1});
    dirMap.put("D", new int[]{1, 0});
  }

  /**
   * Moves the snake.
   *
   * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
   * @return The game's score after the move. Return -1 if game over. Game over when snake crosses
   * the screen boundary or bites its body.
   */
  public int move(String direction) {
    // retrieve the head of the snake
    String curPos = snake.peekFirst();
    // retrieve next potential move
    int[] nextMove = dirMap.get(direction);
    // get the position of next move
    int nextRow = Integer.parseInt(curPos.split(",")[0]) + nextMove[0];
    int nextCol = Integer.parseInt(curPos.split(",")[1]) + nextMove[1];
    // get next possible food
    int[] food = foods.peek();
    // check if next move goes outside the bound
    if (nextRow < 0 || nextRow >= height || nextCol < 0 || nextCol >= width) {
      return -1;
    }
    // check if next move eats the food
    if (food != null && nextRow == food[0] && nextCol == food[1]) {
      snake.addFirst(nextRow + "," + nextCol);
      foods.poll();
      return snake.size() - 1;
    }
    // else, remove the tail
    snake.pollLast();
    // and check if next move bites itself
    if (snake.contains(nextRow + "," + nextCol)) {
      return -1;
    } else {
      // if not, add a new head to the queue
      snake.addFirst(nextRow + "," + nextCol);
      return snake.size() - 1;
    }
  }
}
