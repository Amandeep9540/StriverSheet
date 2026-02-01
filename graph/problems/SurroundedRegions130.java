package graph.problems;

public class SurroundedRegions130 {
    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

            solve(board);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solve(char[][] board) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        //i will traverse the corner of the board and if i found zero the i do dfs and mark them visited
        //upper row and lower Row
        int lowerRowNo = board.length - 1;
        for(int i=0;i<board[0].length;i++){
            if(board[0][i] == 'O' && !isVisited[0][i]){
                dfs(0,i,board,isVisited);
            }
            if(board[lowerRowNo][i] == 'O' && !isVisited[lowerRowNo][i]){
                dfs(lowerRowNo,i,board,isVisited);
            }
        }
        //first col and //last col
        int lastColNo = board[0].length - 1;
        for(int i=0;i<board.length;i++){
            if(board[i][0] == 'O' && !isVisited[i][0]){
                dfs(i,0,board,isVisited);
            }
            if(board[i][lastColNo] == 'O' && !isVisited[i][lastColNo]){
                dfs(i,lastColNo,board,isVisited);
            }
        }

        //again i traverse the board and if its zero and its not visited then i convert 0 to X.
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == 'O' && !isVisited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(int row,int col,char[][] board,boolean[][] isVisited){
        isVisited[row][col]= true;
        //check the left
        if(col+1<board[row].length && board[row][col+1] == 'O' && !isVisited[row][col+1])
            dfs(row,col+1,board,isVisited);
        //check the right
        if(col-1>=0 && board[row][col-1] == 'O' && !isVisited[row][col-1])
            dfs(row,col-1,board,isVisited);
        //check the top
        if(row-1>=0 && board[row-1][col] == 'O' && !isVisited[row-1][col])
            dfs(row-1,col,board,isVisited);
        //check the bottom
        if(row+1<board.length && board[row+1][col] == 'O' && !isVisited[row+1][col])
            dfs(row+1,col,board,isVisited);
    }
}
