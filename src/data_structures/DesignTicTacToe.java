package data_structures;

public class DesignTicTacToe {

    public static void main(String[] args) {
        DesignTicTacToe toe = new DesignTicTacToe(3);
        toe.move(1, 1, 1);
    }


    int n;
    int[][] horizontal;
    int[][] vertical;
    int[] diahonalLeft;
    int[] diahonalRight;

    /**
     * Initialize your data structure here.
     */
    public DesignTicTacToe(int n) {
        this.n = n;
        //у нас 2 матрицы из n строк и 2 столбцов - потому что два игрока
        //горизонтальная
        horizontal = new int[n][2];
        //вертикальная
        vertical = new int[n][2];

        //и два массива по диагонали слева и справа
        //именно массива потому что диагоналей у нас всего 2
        diahonalLeft = new int[2];
        diahonalRight = new int[2];
    }

    /**
     * идея собственно заключается в том что мы будет собирать каунты
     * из тех ходов которые человек ставит
     *
     * если в определенной строке или в определенном столбце или в определенной диагонале
     * у него соберется ровно n крестиков значит он выиграл
     *
     * ну собственно и все делаем такие вот две матрицы - по строкам, по столбцам
     * а так же два массива по обоим дигоналям
     */
    public int move(int row, int col, int player) {

        //смотрим айдишник игрока
        int playerId = player - 1;

        //ставим там как бы крестик
        horizontal[row][playerId]++;
        vertical[col][playerId]++;

        if (col == row) {
            diahonalLeft[playerId]++;
        }
        if (col == n - row - 1) {
            diahonalRight[playerId]++;
        }
        //если в этой строке этот игрок поставил ровно n крестиков
        //иди в этом как бы столбце
        //или по дигонале
        if (horizontal[row][playerId] == n ||
                vertical[col][playerId] == n ||
                diahonalLeft[playerId] == n ||
                diahonalRight[playerId] == n) {
            return player;
        }
        return 0;
    }
}
