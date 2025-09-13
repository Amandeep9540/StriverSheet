package dp.onSubsequence;

public class CoinChangeII518 {
    public static void main(String[] args) {
        int[] coins ={1,2,5};
        int amount = 5;
        System.out.println("ways to make amount by coins --> "+changeMemo(amount,coins));
    }

//------------------------------------------Memoization-------------------------------------------------------

    public static int changeMemo(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<dp.length;i++)
            java.util.Arrays.fill(dp[i],-1);
        return solve(coins,coins.length-1,amount,dp);
    }

    public static int solve(int[] coins,int index,int amount,int[][] dp){
        //base cases
        if(index == 0){
            if(amount % coins[0] == 0) return 1;
            return 0;
        }
        if(amount == 0) return 1;

        //actual code
        if(dp[index][amount] != -1) return dp[index][amount];
        int notTake = solve(coins,index-1,amount,dp);
        int take = 0;
        if(amount >= coins[index])
            take = solve(coins,index,amount-coins[index],dp);
        dp[index][amount] = take + notTake;
        return dp[index][amount];
    }


//------------------------------------Tabulation-----------------------------------------------------------------
    public static int changeTabu(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        /*Base Case - if the coins is only have apply on row */
        for(int i=0;i<dp[0].length;i++){
            if(i % coins[0] == 0)
                dp[0][i] = 1;
        }

        /*If the amount is zero then yees  */
        for(int i=0;i<coins.length;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(j >= coins[i])
                    take = dp[i][j-coins[i]];
                dp[i][j] = take + notTake;
            }
        }
        return dp[dp.length-1][amount];
    }

}
