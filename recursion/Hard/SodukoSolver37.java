package recursion.Hard;

public class SodukoSolver37 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);

        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void solveSudoku(char[][] board) {
        solveSudoku(board,0,0);
    }

    private static boolean solveSudoku(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }

        if (col == board.length) {
            return solveSudoku(board, row + 1, 0);
        }

        if (board[row][col] != '.') {
            return solveSudoku(board, row, col + 1);
        }

        for(int value=1;value<=9;value++){
            char valueChar = (char) ('0'+value);
            if(isCurrentElementCorrect(board,row,col,valueChar)){
                board[row][col] = valueChar;
                if(solveSudoku(board,row,col+1)){
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;
    }

    private static boolean isCurrentElementCorrect(char[][] board,int row,int col,char no){
        // check row
        for(int i=0;i< board.length;i++){
            if(board[row][i] == no){
                return false;
            }
        }
            //check col
        for(int i=0;i< board.length;i++){
            if(board[i][col] == no){
                return false;
            }
        }

            // check the 3*3 grid
        int rowStart = ((row/3) * 3);
        int colStart = ((col/3) * 3);

            for(int i = 0;i<3;i++){
                for(int j =0;j<3;j++){
                    if(board[rowStart+1][colStart+j] == no){
                        return false;
                    }
                }
            }

        return true;
    }
}
