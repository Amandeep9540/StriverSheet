package dp.singleD_dp;

public class HouseRobberII_213 {
    public static void main(String[] args) {
        int[] arr ={1,2,3,1};
        System.out.println("maximum profit "+rob(arr));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if(n <= 1) return n <= 0 ? 0 : nums[0];
        int[] arr = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];
        for(int i=0;i<n;i++){
            if(i != 0) arr[i-1] = nums[i];
            if(i != n-1) arr2[i] = nums[i];
        }
        return Math.max(robTabulation(arr),robTabulation(arr2));
    }

    public static int robTabulation(int[] nums) {
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
