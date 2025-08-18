package dp.dp_2D_3D;

import java.util.Arrays;

public class MinimumPathSum64 {
    public static void main(String[] args) {
        MinimumPathSum64 question = new MinimumPathSum64();
            int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int minSum = question.minPathSum(grid);
        System.out.println("Minimum Sum is -->" +minSum);
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            java.util.Arrays.fill(dp[i],-1);
        }
       // return minPathSum(grid,grid.length-1,grid[0].length-1,dp);
//        return minPathSumTabulation(grid,dp);
        return minPathSumTabulationSpaceOptimized(grid);
    }

    public int minPathSum(int[][] grid,int row , int col,int[][] dp){
        if(row == 0 && col == 0) return grid[row][col];
        if(row < 0 || col < 0) return Integer.MAX_VALUE;
        if(dp[row][col] != -1) return dp[row][col];
            int up = minPathSum(grid,row-1,col,dp);
            int right = minPathSum(grid,row,col-1,dp);
            dp[row][col] = Math.min(up,right) + grid[row][col];
            return Math.min(up,right) + grid[row][col];
    }


    public int minPathSumTabulation(int[][] grid,int[][] dp){
            dp[0][0] = grid[0][0];
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                if(row== 0 && col == 0) continue;
                int prevRow = row - 1;
                int prevCol = col - 1;
                int left = prevCol < 0   ? Integer.MAX_VALUE : dp[row][prevCol];
                int down = prevRow < 0 ? Integer.MAX_VALUE : dp[prevRow][col];
                dp[row][col] = Math.min(left,down) + grid[row][col];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }


    public int minPathSumTabulationSpaceOptimized(int[][] grid){
            int[] temp = new int[grid[0].length];
            Arrays.fill(temp,Integer.MAX_VALUE);
            int prev = Integer.MAX_VALUE;
        for(int row=0;row<grid.length;row++){
            for(int col=0;col<grid[row].length;col++){
                if(row== 0 && col == 0)
                {temp[0] = grid[row][col]; prev = grid[row][col];continue;};
                int left = prev;
                int down = temp[col];
                temp[col] = Math.min(left,down) + grid[row][col];
                prev = temp[col];
            }
            prev = Integer.MAX_VALUE;
        }
        return temp[grid[0].length-1];
    }

}
