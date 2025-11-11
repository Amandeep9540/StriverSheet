package dp.dpOnPartitions;
import java.util.*;

public class MatrixChainMultiplication_GFG {
    public static void main(String[] args) {

        int[] arr = {10,20,30,40,50};
        int minOp = matrixMultiplicationTabu(arr);
        System.out.println("minOp -- "+minOp);
    }

            //Memoization Solution TC-O(n cube) + auxiliary stack space
    static int matrixMultiplicationMemo(int arr[]) {
        int[][] dp = new int[arr.length][arr.length];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return solve(arr,1,arr.length-1,dp);
    }

    public static int solve(int[] arr,int i,int j,int[][] dp){
        if(i == j){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int minStep = Integer.MAX_VALUE;
        int step = 0;
        for(int k=i;k<j;k++){
            step = (arr[i-1] * arr[j] * arr[k]) +
                    (solve(arr,i,k,dp) + solve(arr,k+1,j,dp));
            minStep = Math.min(step,minStep);
        }
        dp[i][j] = minStep;
        return minStep;
    }

    static int matrixMultiplicationTabu(int arr[]){
        int[][] dp = new int[arr.length][arr.length];
            for(int i=0;i< dp.length;i++) dp[i][i] = 0;

        for(int i=arr.length-1;i>=1;i--){
            for(int j=i+1;j<arr.length;j++){
                int minStep = Integer.MAX_VALUE;
                int step = 0;
                for(int k=i;k<j;k++){
                    step = (arr[i-1] * arr[j] * arr[k]) +
                            dp[i][k] + dp[k+1][j];
                    minStep = Math.min(step,minStep);
                }
                dp[i][j] = minStep;
            }
        }
        return dp[1][arr.length-1];
    }

}
