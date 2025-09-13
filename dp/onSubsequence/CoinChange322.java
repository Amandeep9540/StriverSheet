package dp.onSubsequence;

public class CoinChange322 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int minCoin = coinChangeOptimizeTabulation(coins,11);
        System.out.println("min coins -- "+minCoin);
    }

//------------------------------Memoization------------------------------------
    public static int coinChangeMemoization(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++)
            java.util.Arrays.fill(dp[i],-1);
        int result = coinChange(coins,coins.length-1,amount,dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static int coinChange(int[] coins,int index,int amount,int[][] dp){
        if(index == 0){
            return amount % coins[0] == 0 ? (amount/coins[0]) : Integer.MAX_VALUE;
        }
        if(dp[index][amount] != -1) return dp[index][amount];
        int notTake = coinChange(coins,index-1,amount,dp);
        int take = Integer.MAX_VALUE;
        if(coins[index] <= amount){
            int sub = coinChange(coins,index,amount-coins[index],dp);
            if(sub != Integer.MAX_VALUE)
                take = sub + 1;
        }
        dp[index][amount] = Math.min(take,notTake);
        return dp[index][amount];
    }


//------------------------------------------Tabulation-------------------------------------------
    public static int coinChangeTabulation(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];

        // Base Cases -- if index is one so operation will happend on row
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = i % coins[0] == 0 ? (i/coins[0]) : Integer.MAX_VALUE;
        }

        //actual code
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                int notTake = dp[i-1][j];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= j){
                    int sub = dp[i][j-coins[i]];
                    if(sub != Integer.MAX_VALUE)
                        take = sub + 1;
                }
                dp[i][j] = Math.min(take,notTake);
            }
        }
        return dp[dp.length-1][amount] == Integer.MAX_VALUE ? -1 : dp[dp.length-1][amount];
    }


//--------------------------------------Tabulation + Space Optimisation---------------------------------------------------
    public static int coinChangeOptimizeTabulation(int[] coins, int amount) {
        int[] prevDp = new int[amount+1];

        // Base Cases -- if index is one so operation will happend on row
        for(int i=0;i<prevDp.length;i++){
            prevDp[i] = i % coins[0] == 0 ? (i/coins[0]) : Integer.MAX_VALUE;
        }

        //actual code
        int[] currDp = new int[amount+1];
        for(int i=1;i<coins.length;i++){
            for(int j=0;j<prevDp.length;j++){
                int notTake = prevDp[j];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= j){
                    int sub = currDp[j-coins[i]];
                    if(sub != Integer.MAX_VALUE)
                        take = sub + 1;
                }
                currDp[j] = Math.min(take,notTake);
            }
            // we need to empty the currentDP and current will be now prev
            prevDp = currDp.clone();
            currDp = new int[amount+1];
        }
        return prevDp[amount] == Integer.MAX_VALUE ? -1 : prevDp[amount];
    }
}
