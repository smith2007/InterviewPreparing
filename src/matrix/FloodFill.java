package matrix;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        floodFill(image, 1, 1, 1);
    }

    static int[][] floodFill(int[][] image, int row, int col, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] == newColor) {
            return image;
        }
        floodFill(image, row, col, newColor, image[row][col]);
        return image;
    }

    static void floodFill(int[][] image, int row, int col, int newColor, int color) {

        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != color
                || image[row][col] == newColor) {
            return;
        }

        image[row][col] = newColor;
        floodFill(image, row + 1, col, newColor, color);
        floodFill(image, row, col + 1, newColor, color);
        floodFill(image, row - 1, col, newColor, color);
        floodFill(image, row, col - 1, newColor, color);
    }

}
