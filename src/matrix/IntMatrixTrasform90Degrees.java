package matrix;

public class IntMatrixTrasform90Degrees {


    public static void main(String[] args) {
        int[][] arr = new int[2][2];
        arr[0][0] = 2;
        arr[0][1] = 4;
        arr[1][0] = 6;
        arr[1][1] = 8;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        transform(arr);
    }

    static void transform(int[][] arr) {

        int[][] newArr = new int[2][2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                newArr[j][i] = arr[i][j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(newArr[i][j]);
            }
            System.out.println();
        }

    }
}
