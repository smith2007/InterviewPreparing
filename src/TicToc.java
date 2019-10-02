import java.util.Random;

public class TicToc {


    static void ai(TicToc board) {
        int row = new Random().nextInt(2);
        int column = new Random().nextInt(2);
        board.add(row, column, '0');
    }

    public static void main(String[] args) {
        TicToc ticToc = new TicToc();

        for (int i = 0; i < 10; i++) {
            ai(ticToc);
            ticToc.print();
        }


        System.out.println(ticToc.isFull());

    }

    private char[][] board;

    public TicToc() {
        this.board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    void add(int row, int column, char symbol) {
        if (board[row][column] != '-') {
            throw new RuntimeException("That move is not possible");
        }
        board[row][column] = symbol;
    }

    boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }

            }
        }
        return true;
    }

    void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i][j];
                System.out.print(c);
                if (j != 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

}
