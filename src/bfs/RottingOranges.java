package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RottingOranges {

    public static void main(String[] args) {
        //int[][] grid = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int[][] grid = {{0}};

        System.out.println(orangesRotting(grid));
    }

    static int orangesRotting(int[][] grid) {

        LinkedList<List<Integer>> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    ArrayList<Integer> e = new ArrayList<>();
                    e.add(i);
                    e.add(j);
                    queue.add(e);
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh > 0 && queue.isEmpty()) {
            return -1;
        } else if (fresh == 0 && queue.isEmpty()){
            return 0;
        }

        int count = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size != 0) {
                List<Integer> pair = queue.poll();
                Integer i = pair.get(0);
                Integer j = pair.get(1);
                if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    ArrayList<Integer> e = new ArrayList<>();
                    e.add(i + 1);
                    e.add(j);
                    queue.add(e);
                    fresh--;
                }
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    ArrayList<Integer> e = new ArrayList<>();
                    e.add(i - 1);
                    e.add(j);
                    queue.add(e);
                    fresh--;
                }
                if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    ArrayList<Integer> e = new ArrayList<>();
                    e.add(i);
                    e.add(j + 1);
                    queue.add(e);
                    fresh--;
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    ArrayList<Integer> e = new ArrayList<>();
                    e.add(i);
                    e.add(j - 1);
                    queue.add(e);
                    fresh--;
                }
                size--;
            }
            count++;

        }

        return fresh > 0 ? -1 : count - 1;
    }


}
