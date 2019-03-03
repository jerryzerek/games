public class Game {
    public static boolean checkRows(char[][] board, char symbol) {
        int dimension = board.length;
        for (int row = 0; row < dimension; row++) {
            boolean isWin = true;
            for (int column = 0; column < dimension; column++) {
                if (board[row][column] != symbol) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkColumns(char[][] board, char symbol) {
        int dimension = board.length;
        for (int column = 0; column < dimension; column++) {
            boolean isWin = true;
            for (int row = 0; row < dimension; row++) {
                if (board[row][column] != symbol) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                return true;
            }
        }
        return false;
    }


}
