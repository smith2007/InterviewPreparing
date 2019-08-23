package matrix;

import java.util.ArrayList;
import java.util.List;

public class IfElmZeroSetZeroAllRowAndColumn {

    public static void main(String[] args) {
        int[][] arr = new int[4][3];

        arr[0][0] = 20;
        arr[0][1] = 40;
        arr[0][2] = 60;

        arr[1][0] = 10;
        arr[1][1] = 0;
        arr[1][2] = 14;

        arr[2][0] = 18;
        arr[2][1] = 20;
        arr[2][2] = 22;

        arr[3][0] = 24;
        arr[3][1] = 26;
        arr[3][2] = 28;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();
        System.out.println();


        nullate(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }

    /**
     * тут тупо запомнить координаты
     * по памяти выходит O(nm)
     */

    static void nullate(int[][] arr) {

        List<Coordinate> coordinates = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    for (int k = 0; k < arr[i].length; k++) {
                        coordinates.add(new Coordinate(i, k));
                    }
                    for (int k = 0; k < arr.length; k++) {
                        coordinates.add(new Coordinate(k, j));
                    }
                }
            }
        }


        for (Coordinate coordinate : coordinates) {
            arr[coordinate.i][coordinate.j] = 0;
        }

    }


    private static class Coordinate {
        int i;
        int j;

        Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
