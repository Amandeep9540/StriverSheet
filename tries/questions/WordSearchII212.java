package tries.questions;
import java.util.*;


public class WordSearchII212 {
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] word = {"oath","pea","eat","rain"};
        WordSearchII212 ques = new WordSearchII212();
        ques.findWords(board,word).stream().forEach(System.out::println);
    }

    int row = 0 , col = 0;
    // {row , col}
    int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        row = board.length; col = board[0].length;

        //insert all the words to trie
        Trie root = insertWordToTrie(words);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                char c = board[i][j];
                if(root.contains(c)){
                    findWord(board,i,j,root,result);
                }
            }
        }

        return result;
    }

    private void findWord(char[][] board,int row, int col, Trie root, List<String> result){
        if(!checkValidIndex(row,col) || (!root.contains(board[row][col])) ) return;

        Trie temp = root.get(board[row][col]);
        char c = board[row][col];
        board[row][col] = '$'; // visited mark
        for(int i=0;i<this.directions.length;i++){
            int newRow = row + directions[i][0]; int newCol = col + directions[i][1];
            if(checkValidIndex(newRow, newCol) && temp.contains(board[newRow][newCol])){
                findWord(board,newRow,newCol,temp,result);
            }
        }
        board[row][col] = c; // marking unvisited
        if(temp.isEnd){
            result.add(temp.word);
            temp.isEnd = false;
        }

    }

    private Trie insertWordToTrie(String[] words){
        Trie root = new Trie();
        for(String word : words)
            insertWordToTrie(word,root);
        return root;
    }

    private void insertWordToTrie(String word, Trie root){
        Trie temp = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!temp.contains(c)){
                temp.add(c, new Trie());
            }
            temp = temp.get(c);
        }
        temp.isEnd = true;
        temp.word = word;
    }

    private boolean checkValidIndex(int row, int col){
        if ( (row >= 0 && this.row > row) && (col >=0 && col < this.col)) return true;
        return false;
    }
}


class Trie{
    boolean isEnd;
    Trie[] childrens;
    String word;

    public Trie(){
        word = null;
        childrens = new Trie[26];
    }

    public boolean contains(char c){
        return c >= 'a' && c <= 'z' && childrens[c - 'a'] != null;
    }

    public Trie get(char c){
        return childrens[c-'a'];
    }

    public void add(char c, Trie node){
        childrens[c-'a'] = node;
    }
}
