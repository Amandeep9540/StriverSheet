package recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class NQueen51 {
    public static void main(String[] args) {
        solveNQueensV2(4).stream().forEach(System.out::println);
    }

    /*This method is using O(n) time to check if cell is taken or not.*/
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = '.';
            }
        }
            generateNQueenSolutions(board,n, 0, result);
        return result;
    }

    private static void generateNQueenSolutions(char[][] board,int n, int r, List<List<String>> result) {
        if(r == n){ // means queen is filled in every row
            List<String> tempResult = new ArrayList<>();
                for(int i=0;i<board.length;i++){
                    tempResult.add(new String(board[i]));
                }
            result.add(tempResult);
            return;
        }
        for(int c =0;c<n;c++){
            if(isSafeCell(board,r,c)){
                board[r][c] = 'Q';
                generateNQueenSolutions(board,n,r+1,result);
                board[r][c] = '.';
            }
        }
    }

    private static boolean isSafeCell(char[][] board, int r, int c) {
        // check the upper diagonal
            int tempR = r;
            while(tempR >= 0){
                if(board[tempR][c] == 'Q'){
                    return false;
                }
                tempR--;
            }
        //check the upper cross diagonal
        int tempC = c;tempR = r;
            while(tempC >= 0 && tempR >= 0){
                if(board[tempR--][tempC--] == 'Q'){
                    return false;
                }
            }

            while(r>=0 && c < board.length){
                if(board[r--][c++] == 'Q'){
                    return false;
                }
            }
        return true;
    }

    public static List<List<String>> solveNQueensV2(int n){
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = '.';
            }
        }
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        generateNQueenSolutionsV2(board,n, 0,leftRow,upperDiagonal,lowerDiagonal, result);
        return result;
    }

    private static void generateNQueenSolutionsV2(char[][] board,int n, int c,int[] leftRow,int[] upperDiagonal,int[] lowerDiagonal, List<List<String>> result) {
        if(c == n){ // means queen is filled in every row
            List<String> tempResult = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                tempResult.add(new String(board[i]));
            }
            result.add(tempResult);
            return;
        }
        for(int r=0;r<n;r++){
            if(leftRow[r] == 0 && lowerDiagonal[r+c] == 0 && upperDiagonal[(n-1) + (c-r)] == 0){
                    board[r][c] = 'Q';
                    leftRow[r] = 1;
                    lowerDiagonal[r+c] = 1;
                    upperDiagonal[(n-1) + (c-r)] = 1;
                generateNQueenSolutionsV2(board,n,c+1,leftRow,upperDiagonal,lowerDiagonal,result);
                    board[r][c] = '.';
                    leftRow[r] = 0;
                    lowerDiagonal[r+c] = 0;
                    upperDiagonal[(n-1) + (c-r)] = 0;
            }
        }
    }
}