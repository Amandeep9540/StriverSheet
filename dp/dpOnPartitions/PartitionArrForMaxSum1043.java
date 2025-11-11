package dp.dpOnPartitions;
import java.util.*;

public class PartitionArrForMaxSum1043 {
    public static void main(String[] args) {
        int[] arr ={1,15,7,9,2,5,10};
        System.out.println("Max sum -- "+maxSumAfterPartitioningTabu(arr,3));
    }

// ----------------------------------------------------Memoization---------------------------------------------
    public static int maxSumAfterPartitioningMemo(int[] arr, int k) {
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp,-1);
        return solve(arr,0,k,dp);
    }

    public static int solve(int[] arr,int i,int k,int[] dp){
        if(i >= arr.length ) return 0;

        if(dp[i] != -1) return dp[i];
        int len = 1;
        int maxSum = 0;
        int currMax = 0;
        int n = Math.min((i+k)-1,arr.length-1);
        for(int j=i;j<=n;j++){
            currMax = Math.max(currMax,arr[j]);
            int sum = (len * currMax) + solve(arr,j+1,k,dp);
            maxSum = Math.max(maxSum,sum);
            len++;
        }
        dp[i] = maxSum;
        return maxSum;
    }

//------------------------------------------------------Tabulation------------------------------------------------
    public static int maxSumAfterPartitioningTabu(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            int len = 1;
            int maxSum = 0;
            int currMax = 0;
            int n = Math.min((i + k) - 1, arr.length - 1);
            for (int j = i; j <= n; j++) {
                currMax = Math.max(currMax, arr[j]);
                int sum = (len * currMax) + dp[j + 1];
                maxSum = Math.max(maxSum, sum);
                len++;
            }
            dp[i] = maxSum;
        }
        return dp[0];
    }

}
