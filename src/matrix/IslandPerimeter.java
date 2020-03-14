package matrix;

public class IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = {{1, 1},
                {1, 1}};

        int i = new IslandPerimeter().islandPerimeter(grid);
        System.out.println(i);
    }

    int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                //если какая либо ячейка равна 1 то все сразу раскручиваем
                if (grid[i][j] == 1) {
                    return getPerimeter(grid, i, j);
                }
            }
        }
        return 0;
    }

    int getPerimeter(int[][] grid, int i, int j) {
        //если мы вышли за пределы массива то зашибись нам дает дополнительную единицу
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 1;
        }
        //если наткнулись на ноль то тоже 1
        if (grid[i][j] == 0) {
            return 1;
        }

        //если встретили ранее помеченный элемент то отлично мы тут уже были - 0
        if (grid[i][j] == -1) {
            return 0;
        }

        int count = 0;
        grid[i][j] = -1;

        count += getPerimeter(grid, i - 1, j);
        count += getPerimeter(grid, i, j - 1);
        count += getPerimeter(grid, i, j + 1);
        count += getPerimeter(grid, i + 1, j);

        return count;

    }
}
