package dp.dpOnLIS;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class LongestIncreasingSubseq300 {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int len = lengthOfLISWithDPB(arr);
        System.out.println("longest increasing sub sequence -- "+len);
    }

//---------------------------------------------------Memoization---------------------------------------------------------
    public static int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int i=0;i<nums.length;i++)
            Arrays.fill(dp[i],-1);
        return solve(nums,0,-1,dp);
    }

    private static int solve(int[] arr,int index,int prevIndex,int[][] dp){
        if(index == arr.length)
            return 0;
        int take =0,notTake =0;
        if(dp[index][prevIndex+1] != -1) return dp[index][prevIndex+1];
        if(prevIndex == -1 || arr[index] > arr[prevIndex]){
            take = 1 + solve(arr,index+1,index,dp);
            notTake = solve(arr,index+1,prevIndex,dp);
        }else{
            notTake = solve(arr,index+1,prevIndex,dp);
        }
        dp[index][prevIndex+1] = Math.max(take,notTake);
        return Math.max(take,notTake);
    }
//------------------------------------------------------Tabulation--------------------------------------------------------
    public static int lengthOfLISTabu(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int index = nums.length - 1; index >= 0; index--) {
            for (int prevIndex = nums.length - 1; prevIndex >= -1; prevIndex--) {
                int take = 0;

                if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
                    take = 1 + dp[index + 1][index + 1]; // shifted prevIndex
                }

                int notTake = dp[index + 1][prevIndex + 1];

                dp[index][prevIndex + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }
//----------------------------------------------------Tabulation+Optimized-----------------------------------------------
    public static int lengthOfLISTabuOp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length + 1];
        for (int index = nums.length - 1; index >= 0; index--) {
            int[] currDp = new int[nums.length + 1];;
            for (int prevIndex = nums.length - 1; prevIndex >= -1; prevIndex--) {
                int take = 0;

                if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
                    take = 1 + dp[index + 1]; // shifted prevIndex
                }

                int notTake = dp[prevIndex + 1];

                currDp[prevIndex + 1] = Math.max(take, notTake);
            }
            dp = currDp.clone();
        }
        return dp[0];
    }


//-----------------------------------------------------Without DP----------------------------------------------------------
    public static int lengthOfLISWDP(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis,1);
        for(int i=0;i<nums.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    max = Math.max(max,lis[j]);
                }
            }
            lis[i] = max + lis[i];
        }
        int max = 0;
        for(int x:lis){
            max = Math.max(max,x);
        }
        return max;
    }
//----------------------------------------------------Without DP+Best------------------------------------------------------
    public static int lengthOfLISWithDPB(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        int lisSize =-1;
        for(int x : nums){
            if(lis.isEmpty() || lis.get(lisSize) < x){
                lis.add(x);
                lisSize++;
            }else{
                int index = findLowerBound(lis,x);
                lis.set(index,x);
            }
        }
        return lis.size();
    }

    public static int findLowerBound(List<Integer> list, int target){
        int start = 0;
        int end = list.size();
        while(end > start){
            int mid = start + (end-start)/2;
            if(list.get(mid) < target)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}
