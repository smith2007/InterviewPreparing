package matrix;

public class IfElmZeroSetZeroAllRowAndColumn2 {

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
     есть более умный алгоритм он конечно же заключается в раскрашивании,
     суть в чем, мы будем метить нужные для обнуления строки и столбцы на основе
     нулевой строки и нулевого столбца

     для этого сперва надо понять есть ли в первой строке и в первом столбце элемент 0,
     если есть маркируем флагом что есть и далее используем нулевую строку и нулевой столбец
     для своих нужд - будем красить с помощью него

     так же в самом начале мы проверяем, а нужно ли нулить сам первый столбец и первую строку,
     заводим два флага и финальным этапом мы нулим или не нулим

     сложность по времени: О(m*n)
     сложность по памяти: О(1) - из-за того раскрашиваешь на месте за счет нулевого столбца
     */

    static void nullate(int[][] arr) {

        boolean isNeedToNullifyZeroRow = false;
        boolean isNeedToNullifyZeroColumn = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 0) {
                isNeedToNullifyZeroColumn = true;
                break;
            }
        }


        for (int j = 0; j < arr[0].length; j++) {
            if (arr[0][j] == 0) {
                isNeedToNullifyZeroRow = true;
                break;
            }
        }


        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 0) {
                for (int k = 1; k < arr[i].length; k++) {
                    arr[i][k] = 0;
                }
            }
        }


        for (int j = 0; j < arr[0].length; j++) {
            if (arr[0][j] == 0) {
                for (int k = 1; k < arr.length; k++) {
                    arr[k][j] = 0;
                }
            }
        }

        if (isNeedToNullifyZeroColumn) {
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = 0;
            }
        }

        if (isNeedToNullifyZeroRow) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[0][j] = 0;
            }
        }
    }
}
