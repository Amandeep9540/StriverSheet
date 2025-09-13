package dp.onSubsequence;

public class KnapsackProblem0_1 {
    public static void main(String[] args) {
        int[] value = {1,2,3};
        int[] weight = {4,5,1};
        int W = 4;
        System.out.println("Maximum value --> "+knapsack(W,value,weight));
    }
            //Memoization Code
    static int knapsackMemo(int W, int val[], int wt[]) {
        int[][] dp = new int[val.length][W+1];
        for(int i=0;i<val.length;i++){
            java.util.Arrays.fill(dp[i],-1);
        }
        return getMaxValueMemo(val,wt,W,val.length-1,dp);
    }

    static int getMaxValueMemo(int[] val, int[] wt, int W,int index,int[][] dp){
        if(index < 0 || W <= 0) return 0;
        if(dp[index][W] != -1) return dp[index][W];
        int take = 0;
        if(wt[index] <= W){
            take = val[index] + getMaxValueMemo(val,wt,W-wt[index],index-1,dp);
        }
        int notTake = getMaxValueMemo(val,wt,W,index-1,dp);
        dp[index][W] = Math.max(notTake,take);
        return Math.max(notTake,take);
    }

            //Tabulation code
    static int knapsack(int W, int val[], int wt[]) {
            int[][] dp = new int[val.length][W+1];
            //filling the first col;
            for(int i=0;i<dp.length;i++){
                dp[i][0] = 0;
            }
            //filling the first row
            for(int i=0;i<dp[0].length;i++){
                dp[0][i] = i < wt[0] ? 0 : val[0];
            }
            return getMaxValue(val,wt,W,dp);
    }

    static int getMaxValue(int[] val, int[] wt, int W,int[][] dp){
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(wt[i] <= j)
                    take = val[i] + dp[i-1][j-wt[i]];
                dp[i][j] = Math.max(take,notTake);
            }
        }
        return dp[dp.length-1][W];
    }

}
