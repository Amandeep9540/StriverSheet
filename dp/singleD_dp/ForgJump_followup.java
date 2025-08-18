package dp.singleD_dp;

import java.util.Arrays;

public class ForgJump_followup {
    public static void main(String[] args) {
        int[] heights = {30,10,60,10,60,50};
        System.out.println("min energy required -- "+minEnergryTabulation(heights,3));
    }

    public static int minEnergry(int[] arr,int k){
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return minEnergry(arr,dp.length-1,k,dp);
    }

    private static int minEnergry(int[] arr, int index, int k, int[] dp) {
        if(index == 0){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int stepTaken = 1;
        int cost = Integer.MAX_VALUE;
        while(stepTaken <= k && (index - stepTaken) >= 0){
            cost = Math.min(cost,minEnergry(arr,index-stepTaken,k,dp) + Math.abs(arr[index] - arr[index-stepTaken]));
            stepTaken++;
        }
        dp[index] = cost;
        return dp[index];
    }

    public static int minEnergryTabulation(int[] arr,int k){
        int[] dp = new int[arr.length];
        dp[0] = 0;
            for(int i=1;i<arr.length;i++){
                int stepTaken = 1;
                int cost = Integer.MAX_VALUE;
                while(stepTaken <= k && (i - stepTaken) >= 0){
                    cost = Math.min(cost,dp[i-stepTaken] + Math.abs(arr[i] - arr[i-stepTaken]));
                    stepTaken++;
                }
                dp[i] = cost;
            }
        return dp[dp.length-1];
    }

}
