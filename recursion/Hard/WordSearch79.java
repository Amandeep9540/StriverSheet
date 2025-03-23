package recursion.Hard;

public class WordSearch79 {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        boolean exist = exist(board, "ABCCED");
        System.out.println("exist -- "+exist);
    }

    public static boolean exist(char[][] board, String word) {
       for(int i=0;i< board.length;i++){
           for(int j=0;j< board[i].length;j++){
               if(checkWordExists(board,i,j,word,0))
                   return true;
           }
       }
       return false;
    }

    public static boolean checkWordExists(char[][] board,int i,int j,String word,int wordInd){
        // check if the all words are matched
            if(wordInd >=word.length()) return true;
        //validate the i and j is in range
        //check if board[i][j] == word.charAt(wordInd) call recursion otherwise return false
            if((i<0 || i >= board.length) || (j<0 || j>= board[i].length) || board[i][j] != word.charAt(wordInd) )
                return false;

                // assign special character to visited cell
        char temp = board[i][j];
        board[i][j] = '#';
        //call the four recursion if any recursion return true then return the ans.
              boolean isWordExist =
           checkWordExists(board,i,j+1,word,wordInd+1)
                ||
            checkWordExists(board,i,j-1,word,wordInd+1)
                ||
            checkWordExists(board,i+1,j,word,wordInd+1)
                ||
            checkWordExists(board,i-1,j,word,wordInd+1);
        board[i][j] = temp;
            return isWordExist;
    }
}
