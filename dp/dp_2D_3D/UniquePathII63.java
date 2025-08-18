package dp.dp_2D_3D;

public class UniquePathII63 {
    public static void main(String[] args) {
        UniquePathII63 qusetion = new UniquePathII63();
            int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int ways = qusetion.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("ways are --> "+ways);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*    int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[i].length;j++){
                    if(obstacleGrid[i][j] == 1)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = -1;
                }
            }
            return uniquePathsRec(obstacleGrid,obstacleGrid.length - 1,obstacleGrid[0].length -1 ,dp); */
        return uniquePathsTabulationOptimized(obstacleGrid,obstacleGrid.length,obstacleGrid[0].length);
    }

    public int uniquePathsRec(int[][] obstacleGrid, int m, int n,int[][] dp) {
        if(m == 0 && n == 0 && obstacleGrid[m][n] != 1) return 1;
        if((m < 0 || n < 0)) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        int up = uniquePathsRec(obstacleGrid,m-1,n,dp);
        int right = uniquePathsRec(obstacleGrid,m,n-1,dp);
        dp[m][n] = up+right;
        return dp[m][n];
    }

    public int uniquePathsTabulationOptimized(int[][] obstacleGrid,int m, int n) {
        if(obstacleGrid[0][0] == 1) return 0;
        int[] prevRow = new int[n];
        for(int i=0;i<m;i++){
            int prevCol = 0;
            for(int j=0;j<n;j++){
                if((i == 0 && j==0)) {prevRow[j] = 1;prevCol = 1;continue;}
                int down = prevRow[j];
                int right = prevCol;
                if(obstacleGrid[i][j] == 0)
                    prevRow[j] = down+right;
                else
                    prevRow[j] = 0;
                prevCol = prevRow[j];
            }
        }
        return prevRow[n-1];
    }
}
