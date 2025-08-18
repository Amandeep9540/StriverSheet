package dp.singleD_dp;
import java.util.Arrays;

public class FrogJump_GFG {
    public static void main(String[] args) {
        int[] heights = {17, 6, 12, 10, 3, 13, 17, 20, 8};
        System.out.println("min energy required -- "+minCostTabulationV2(heights));
    }

    public static int minCostRecursive(int[] height) {
        int[] dp = new int[height.length];
        Arrays.fill(dp,-1);
        return recursiveFun(height, height.length-1,dp);
    }

    public static  int recursiveFun(int[] arr,int index,int[] dp){
        if(index == 0)
            return 0;

        if(dp[index] != -1)
            return dp[index];

        int leftCall = recursiveFun(arr,index-1,dp) + Math.abs(arr[index] - arr[index-1]);
        int rightCall = Integer.MAX_VALUE;
        if(index >= 2 )
            rightCall =  recursiveFun(arr,index-2,dp) + Math.abs(arr[index] - arr[index-2]);
        dp[index] = Math.min(leftCall,rightCall);
        return dp[index];
    }

    public static int minCostTabulation(int[] height) {
        int[] dp = new int[height.length];
        dp[0] = 0;
        for(int i=1;i<height.length;i++){
            int leftCall = dp[i-1] + Math.abs(height[i] - height[i-1]);
            int rightCall = Integer.MAX_VALUE;
            if(i >= 2 )
                rightCall =  dp[i-2] + Math.abs(height[i] - height[i-2]);
            dp[i] = Math.min(leftCall,rightCall);
        }
        return dp[dp.length-1];
    }

    public static int minCostTabulationV2(int[] height) {
        int prev = 0;
        int prev2 = 0;
        for(int i=1;i<height.length;i++){
            int leftCall = prev + Math.abs(height[i] - height[i-1]);
            int rightCall = Integer.MAX_VALUE;
            if(i >= 2 )
                rightCall =  prev2 + Math.abs(height[i] - height[i-2]);
            int curr = Math.min(leftCall,rightCall);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
