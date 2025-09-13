package dp.onSubsequence;

public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        System.out.println("== "+canPartition(arr));
    }

    public static boolean canPartition(int[] nums) {
        int total = 0;
        for(int x:nums){
            total += x;
        }
        return (total % 2 == 0) ? isSumExistsTabuSpaceOptimized(nums,total/2) : false;
    }

    public static boolean isSumExistsTabuSpaceOptimized(int[] arr,int sum){
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
