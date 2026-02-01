package graph.problems;

public class NoOfIsland_GFG {
    public static void main(String[] args) {
        char[][] grid = {{'L', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'L'},
                {'L', 'W', 'W', 'L', 'L'},
                {'W', 'W', 'W', 'W', 'W'},
                {'L', 'W', 'L', 'L', 'W'}};
        System.out.println("no -- "+countIslands(grid));
    }

    public static int countIslands(char[][] grid) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 'L' && !isVisited[i][j]){
                    dfs(i,j,grid,isVisited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int row,int col,char[][] grid, boolean[][] isVisited){
        isVisited[row][col] = true;
        //check the upward downward row
        if(row-1 >= 0 && grid[row-1][col] == 'L' && !isVisited[row-1][col])
            dfs(row-1,col,grid,isVisited);
        if(row+1 < grid.length && grid[row+1][col] == 'L' && !isVisited[row+1][col])
            dfs(row+1,col,grid,isVisited);

        //check the left and right col
        if(col-1 >= 0 && grid[row][col-1] == 'L' && !isVisited[row][col-1])
            dfs(row,col-1,grid,isVisited);
        if(col+1 < grid[row].length && grid[row][col+1] == 'L' && !isVisited[row][col+1])
            dfs(row,col+1,grid,isVisited);

        //check the diagonal
        if(row-1>=0 && col-1>=0 && grid[row-1][col-1] == 'L' && !isVisited[row-1][col-1])
            dfs(row-1,col-1,grid,isVisited);
        if(row+1 < grid.length && col+1 < grid[row].length && grid[row+1][col+1] == 'L' && !isVisited[row+1][col+1])
            dfs(row+1,col+1,grid,isVisited);

        //check the diagonal
        if(row-1>=0 && col+1 < grid[row].length && grid[row-1][col+1] == 'L' && !isVisited[row-1][col+1])
            dfs(row-1,col+1,grid,isVisited);
        if(row+1 < grid.length && col-1 >=0 && grid[row+1][col-1] == 'L' && !isVisited[row+1][col-1])
            dfs(row+1,col-1,grid,isVisited);
    }
}


