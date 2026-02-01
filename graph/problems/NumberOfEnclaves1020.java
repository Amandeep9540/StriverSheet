package graph.problems;

import java.util.*;

public class NumberOfEnclaves1020 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println("num -- "+numEnclaves(grid));
    }

    public static int numEnclaves(int[][] grid) {
        //run the DFS for one's from the corner
        Queue<int[]> queue = new ArrayDeque<>();
        int lastRow = grid.length-1;int lastCol = grid[0].length-1;
        //checking the row's
        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i] == 1)
                dfs(0,i,grid);
            if(grid[lastRow][i] == 1)
                dfs(lastRow,i,grid);
        }
        //checking the col
        for(int i=0;i<grid.length;i++){
            if(grid[i][0] == 1)
                dfs(i,0,grid);
            if(grid[i][lastCol] == 1)
                dfs(i,lastCol,grid);
        }

        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                count += grid[i][j];
            }
        }

        return count;
    }

    public static void dfs(int row,int col,int[][] grid){
        grid[row][col] = 0;
        //check the upper row
        if(row-1>=0 && grid[row-1][col] == 1)
            dfs(row-1,col,grid);
        if(row+1<grid.length && grid[row+1][col] == 1)
            dfs(row+1,col,grid);
        if(col-1>=0 && grid[row][col-1] == 1)
            dfs(row,col-1,grid);
        if(col+1<grid[0].length && grid[row][col+1] == 1)
            dfs(row,col+1,grid);
    }
}
