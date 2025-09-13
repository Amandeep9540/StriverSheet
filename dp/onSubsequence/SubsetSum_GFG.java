package dp.onSubsequence;

import java.util.Arrays;

public class SubsetSum_GFG {
    public static void main(String[] args) {
        SubsetSum_GFG question = new SubsetSum_GFG();
            int[] arr ={3, 34, 4, 12, 5, 2};
            int target = 9;
//        System.out.println("is target exists ==> "+question.isSubsetSum(arr,target));
//        System.out.println("is target exists ==> "+question.isSubsetSumTabulation(arr,target));
        System.out.println("is target exists ==> "+question.isSumExistsTabuSpaceOptimized(arr,target));
    }
            //Recursion + Memoization  ==> S.C - O(mn) + O(m), where m = arr.length , n = sum, T.C =  O(mn)
    static Boolean isSubsetSum(int arr[], int sum) {
        int[][] dp = new int[arr.length][sum+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return isSumExists(arr,arr.length-1,sum,dp);
    }
    static public boolean isSumExists(int[] arr,int index,int sum,int[][] dp){
        if(sum == 0 ) return true;
        if(index == 0) return arr[0] == sum ;

        if(dp[index][sum] != -1) return dp[index][sum] == 1;

        boolean take = false;
        if(sum >= arr[index])
            take = isSumExists(arr,index-1, sum - arr[index],dp);
        boolean notTake = isSumExists(arr,index-1,sum,dp);

        dp[index][sum] = (take || notTake)  ? 1 : 0;
        return take || notTake;
    }


            //Tabulation  ==> S.C - O(mn), TC(mn)
    static public boolean isSubsetSumTabulation(int[] arr,int sum){
        boolean[][] dp = new boolean[arr.length][sum+1];
                // fill the base conditions 1.if sum is 0 then it's true
        for(int i=0;i<dp.length;i++)
            dp[i][0] = true;
             // for first row, if sum == arr[0] then true otherwise false
        for(int i=1;i<dp[0].length;i++)
            dp[0][i] = i == arr[0] ? true : false;
                //now the main part comes
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length; j++){
                // it's representing the arr index and j => weight
                boolean take = arr[i] <= j ?  dp[i-1][j - arr[i]] : false;
                boolean notTake = dp[i-1][j];
                dp[i][j] = take || notTake;
            }
        }
        return dp[dp.length-1][sum];
    }


    static public boolean isSumExistsTabuSpaceOptimized(int[] arr,int sum){
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int i=1;i<dp.length;i++)
            dp[i] = i == arr[0] ? true : false;

        //now the main part comes

        for(int i=1;i<arr.length;i++){
            boolean[] tempDP = new boolean[dp.length];
            tempDP[0] = true;
            for(int j=1;j<dp.length; j++){
                // i representing the arr index and j => weight
                boolean take = arr[i] <= j ?  dp[j - arr[i]] : false;
                boolean notTake = dp[j];
                tempDP[j] = take || notTake;
            }
            dp = tempDP.clone();
        }
        return dp[sum];
    }
}
