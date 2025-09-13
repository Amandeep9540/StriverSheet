package dp.onSubsequence;

public class PerfectSum_GFG {
    public static void main(String[] args) {

    }

        //Recursion + DP === TC---O(nums.length*target) + SC---O(nums.length*target)
    public int perfectSum(int[] nums, int target) {
        int[][] dp = new int[nums.length][target+1];
        for(int i=0;i<dp.length;i++){
            java.util.Arrays.fill(dp[i],-1);
        }
        perfectSum(nums,nums.length-1,target,dp);
        return dp[nums.length-1][target];
    }
    public int perfectSum(int[] arr, int index, int target, int[][] dp){
        if(index == 0 ){
            if(target == 0 && arr[0] == 0) return 2;
            if(target == 0 || target == arr[0]) return 1;
            return 0;
        }
        if(dp[index][target] != -1) return dp[index][target];
        int takeCount = 0;
        if(arr[index] <= target)
            takeCount = perfectSum(arr,index-1,target- arr[index],dp);
        int notTake = perfectSum(arr,index-1,target,dp);

        dp[index][target] = takeCount + notTake;
        return takeCount + notTake;
    }


    public int perfectSumTabulation(int[] nums, int target) {
        int[][] dp = new int[nums.length][target+1];
                //base conditions
        if (nums[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }

        if (nums[0] != 0 && nums[0] <= target) {
            dp[0][nums[0]] = 1;
        }

        for(int row = 1;row<dp.length;row++){
            for(int col = 0;col <dp[row].length;col++){
                int takeCount = 0;
                if(nums[row] <= col)
                    takeCount = dp[row-1][col-nums[row]];
                int notTakeCount = dp[row-1][col];
                dp[row][col] = takeCount + notTakeCount;
            }
        }

        return dp[nums.length-1][target];
    }
}
