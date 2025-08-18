package dp.singleD_dp;
import java.util.Arrays;

public class HouseRobber198 {
    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};
        System.out.println("Maximum Profit is :: "+ rob(arr));
    }

            // Memomization

    public static int robMomoization(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return findTheMaxMoney(nums,nums.length-1,dp);
    }

    public static int findTheMaxMoney(int[] arr, int index,int[] dp){
        if(index <= 0){
            return index ==0 ? arr[index] : 0;
        }
        if(dp[index] != -1) return dp[index];
        int pickSum = arr[index] + findTheMaxMoney(arr,index-2,dp);
        int notPickSum = 0 + findTheMaxMoney(arr,index-1,dp);
        dp[index] = Math.max(pickSum,notPickSum);
        return dp[index];
    }


                // Tabulation


        public static int robTabulation(int[] nums) {
            if(nums.length == 0) return 0;

            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for(int i=1;i<nums.length;i++){
                int pickSum = nums[i] + ((i-2) < 0 ? 0 : dp[i-2]);
                int notPickSum = 0 + dp[i-1];
                dp[i] = Math.max(pickSum,notPickSum);
            }
            return dp[dp.length-1];
        }



            // Tabulation + Constant Space

    public static int rob(int[] nums) {
        if(nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int prev = dp[0];
        int prev2 = 0;
        for(int i=1;i<nums.length;i++){
            int pickSum = nums[i] + prev2;
            int notPickSum = 0 + prev;
            dp[i] = Math.max(pickSum,notPickSum);
            prev2 = prev;
            prev = dp[i];
        }
        return dp[dp.length-1];
    }



}
