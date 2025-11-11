package dp.dpOnPartitions;
import java.util.*;

public class MinCostToCutStick1547 {
    public static void main(String[] args) {
        int[] cuts ={1,3,4,5};
        int n = 7;
        System.out.println("min cost -- "+minCostTabu(n,cuts));
    }

//---------------------------------------------------Tabulation-----------------------------------------------
    public static int minCostTabu(int n, int[] cuts) {
        int[] newCuts = new int[cuts.length + 2];
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;

        for (int i = 0; i < cuts.length; i++)
            newCuts[i + 1] = cuts[i];

        Arrays.sort(newCuts);

        int c = cuts.length;
        int[][] dp = new int[c + 2][c + 2];

        // Bottom-up DP filling
        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j)
                    continue;

                int minCost = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    int cost = (newCuts[j + 1] - newCuts[i - 1])
                            + dp[i][k - 1]
                            + dp[k + 1][j];
                    minCost = Math.min(minCost, cost);
                }

                dp[i][j] = minCost;
            }
        }

        return dp[1][c];
    }


//------------------------------------------------------Memoization-------------------------------------------
    private static int helper(int[] nums, int i, int j, Integer[][] dp){
        if(i > j){
            return 0;
        }

        if(dp[i][j] != null) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i; k<=j; k++){
            int steps = nums[j+1] - nums[i-1] + helper(nums, i, k-1, dp) + helper(nums, k+1, j, dp);
            min = Math.min(min, steps);
        }

        return dp[i][j] = min;
    }
    public static int minCostMemo(int n, int[] cuts) {
        int size = cuts.length;
        int[] nums = new int[size+2];

        nums[0] = 0;
        nums[nums.length-1] = n;
        for(int i=0; i<size; i++){
            nums[i+1] = cuts[i];
        }

        Arrays.sort(nums);

        Integer[][] dp  = new Integer[size+1][size+1];
        return helper(nums, 1, size, dp);
    }




}
