package dp.dpOnPartitions;
import java.util.*;

public class BurstBalloon312 {
    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println("Max coins -- "+maxCoinsTabu(nums));
    }
    public static int maxCoinsMemo(int[] nums) {
        int[] newNums = new int[nums.length+2];
        newNums[0] = 1;
        newNums[nums.length+1] = 1;
        int[][] dp = new int[newNums.length][newNums.length];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        for(int i=0;i<nums.length;i++) newNums[i+1] = nums[i];

        return solve(1,nums.length,newNums,dp);
    }


    public static int solve(int i,int j,int[] nums,int[][] dp){
        if(j<i) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int maxCoins = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int coins = (nums[i-1] * nums[k] * nums[j+1]) + (solve(i,k-1,nums,dp) + solve(k+1,j,nums,dp));
            maxCoins = Math.max(coins,maxCoins);
        }
        dp[i][j] = maxCoins;
        return dp[i][j];
    }



//----------------------------------------------Tabulation---------------------------------------------------------------
    public static int maxCoinsTabu(int[] nums) {
        int[] newNums = new int[nums.length+2];
        newNums[0] = 1;
        newNums[nums.length+1] = 1;
        for(int i=0;i<nums.length;i++) newNums[i+1] = nums[i];
        int[][] dp = new int[newNums.length][newNums.length];
        for(int i=nums.length;i>=1;i--){
            for(int j=1;j<=nums.length;j++){
                if(j<i) continue;
                int maxCoins = Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int coins = (newNums[i-1] * newNums[k] * newNums[j+1]) + dp[i][k-1] + dp[k+1][j];
                    maxCoins = Math.max(coins,maxCoins);
                }
                dp[i][j] = maxCoins;
            }
        }
        return dp[1][nums.length];
    }
}
