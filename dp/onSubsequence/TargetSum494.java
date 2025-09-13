package dp.onSubsequence;

import java.util.HashMap;
import java.util.Map;

public class TargetSum494 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println("ways -- "+findTargetSumWaysTabulation(nums,target));
    }

//---------------------------------------------------memoization with MAP---------------------------------------------------
    public static int findTargetSumWays(int[] nums, int target) {
        Map<String,Integer> dpMap = new HashMap<>();
        return solve(nums,nums.length-1,target,dpMap);
    }

    public static int solve(int[] arr, int index, int target, Map<String,Integer> dpMap){
        if(index == 0){
            if(target - arr[0] == 0 && target + arr[0] == 0) return 2;
            if(target - arr[0] == 0) return 1;
            if(target + arr[0] == 0) return 1;
            return 0;
        }
        String key = index + "," + target;
        if(dpMap.containsKey(key))
            return dpMap.get(key);
        int miunsOp = solve(arr,index-1,target-arr[index],dpMap);
        int addOp = solve(arr,index-1,target+arr[index],dpMap);

        dpMap.put(key,miunsOp + addOp);
        return miunsOp + addOp;
    }

//------------------------------------Memoization + DP arr ----------------------------------------------------------------
    public int findTargetSumWaysMemo(int[] nums, int target) {
        int totalSum = 0;
        for(int x : nums)
            totalSum += x;

        //if i plus all element then totalSum is fine but if i subtract all items the 2*totalSum required
        int[][] dp = new int[nums.length][(2*totalSum)+2];
        //totalSum can got to neg
        //totalSum can got to pos
        for(int i=0;i<dp.length;i++)
            java.util.Arrays.fill(dp[i],-1);
        return solve(nums,nums.length-1,target,dp,totalSum);
    }

    public static int solve(int[] arr,int index,int target,int[][] dp,int totalSum){
        if(index == 0){
            if(target - arr[0] == 0 && target + arr[0] == 0) return 2;
            if(target - arr[0] == 0) return 1;
            if(target + arr[0] == 0) return 1;
            return 0;
        }


        //check if target is less then the totalSum or greater then sum
        if (target < -totalSum || target > totalSum) return 0;
        //check in DP
        int currentDpIndex = totalSum + target;
        if(dp[index][currentDpIndex] != -1) return dp[index][currentDpIndex];
        int miunsOp = solve(arr,index-1,target-arr[index],dp,totalSum);
        int addOp = solve(arr,index-1,target+arr[index],dp,totalSum);

        //put in DP
        dp[index][currentDpIndex] = miunsOp + addOp;
        return miunsOp + addOp;
    }

//-----------------------------------------Tabulation + with count partition problem-----------------------------------------
    public static int findTargetSumWaysTabulation(int[] nums, int target) {
        return countPartitions(nums,target);

        // in this some element belongs to subset with + sign and some with - sigh
    }
    private static  int countPartitions(int[] arr, int d) {
        // code here
        int totalSum = 0;
        for (int x : arr) {
            totalSum += x;
        }

        if (totalSum < d || (totalSum - d) % 2 != 0) return 0;

        int sum2 = (totalSum - d) / 2;
        int[][] dp = new int[arr.length][sum2+1];
        //for the sum = 0, we need to operate on column
        if (arr[0] == 0) dp[0][0] = 2;  // pick the element, not pick both get true
        else dp[0][0] = 1;              // we need to pick the element either in first or second subset that why we are not marking the whole column as 1

        //for the index = 0, we need to operate on column
        if (arr[0] != 0 && arr[0] <= sum2) dp[0][arr[0]] = 1;

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                int notPickCount = dp[i-1][j];
                int pickCount = 0;
                if(arr[i] <= j)
                    pickCount = dp[i-1][j-arr[i]];
                dp[i][j] = pickCount + notPickCount;
            }
        }
        return dp[dp.length-1][sum2];
    }
}
