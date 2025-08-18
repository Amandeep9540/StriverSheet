package dp.dp_2D_3D;
import java.util.Arrays;

public class UniquePaths62 {
    public static void main(String[] args) {
        UniquePaths62 ques = new UniquePaths62();
        //int ways = ques.uniquePaths(3,7);
        int ways2 = ques.uniquePathsTabulationOptimized(3,7);
        System.out.println("ways are -- "+ways2);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return uniquePathsTabulation(m-1,n-1,dp);
    }

    public int uniquePathsRec(int m, int n,int[][] dp) {
        if(m == 0 && n == 0 ) return 1;
        if(m < 0 || n < 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        int up = uniquePathsRec(m-1,n,dp);
        int right = uniquePathsRec(m,n-1,dp);
        dp[m][n] = up+right;
        return dp[m][n];
    }


    public int uniquePathsTabulation(int m, int n,int[][] dp) {

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i == 0 && j==0) || (i==0 && j == 1) || (i == 1 && j == 0)) {dp[i][j] = 1;continue;}
                int down = (i-1) == -1 ? 0 : dp[i-1][j];
                int right = (j-1) == -1 ? 0 : dp[i][j-1];
                dp[i][j] = down+right;
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsTabulationOptimized(int m, int n) {
        int[] prevRow = new int[n];
        for(int i=0;i<m;i++){
            int prevCol = 0;
            for(int j=0;j<n;j++){
                if((i == 0 && j==0) || (i==0 && j == 1) || (i == 1 && j == 0)) {prevRow[j] = 1;prevCol = 1;continue;}
                int down = prevRow[j];
                int right = prevCol;
                prevRow[j] = down+right;
                prevCol = prevRow[j];
            }
        }
        return prevRow[n-1];
    }
}
