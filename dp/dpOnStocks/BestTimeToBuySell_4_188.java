package dp.dpOnStocks;

public class BestTimeToBuySell_4_188 {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        System.out.println("max Profit -- "+maxProfitTabuOp(k,prices));
    }

//-----------------------------------------------------Memoization------------------------------------------------------
    public static int maxProfitMemo(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k+1];
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[i].length;j++){
                java.util.Arrays.fill(dp[i][j],-1);
            }
        return solve(prices,0,1,k,dp);
    }

    public static int solve(int[] prices,int index,int canBuy,int cap,int[][][] dp){
        //base case
        if(index == prices.length || cap == 0)
            return 0;

        int take = 0,notTake = 0;
        if(dp[index][canBuy][cap] != -1) return dp[index][canBuy][cap];
        if(canBuy == 1 ){
            take = -prices[index] + solve(prices,index+1,0,cap,dp);
            notTake = 0 + solve(prices,index+1,1,cap,dp);
        }else{
            take = prices[index] + solve(prices,index+1,1,cap-1,dp);
            notTake = 0 + solve(prices,index+1,0,cap,dp);
        }
        dp[index][canBuy][cap] = Math.max(take,notTake);
        return dp[index][canBuy][cap];
    }

//------------------------------------------------------Memoization + 2nd Approach---------------------------------------
    public static int maxProfitMemo2(int k, int[] prices) {
        int[] buySellArr = new int[k*2];
        int[][] dp = new int[prices.length][buySellArr.length];
        for(int i=0;i<dp.length;i++)
            java.util.Arrays.fill(dp[i],-1);
        return solve(prices,buySellArr,0,0,dp);
    }

    /* We are using aInd to check we need to sell or buy */
    private static int solve(int[] prices,int[] arr,int pInd,int aInd,int[][] dp){
        if(pInd == prices.length || arr.length == aInd)
            return 0;

        if(dp[pInd][aInd] != -1) return dp[pInd][aInd];

        if(aInd %2 == 0){ // buy
            int buy = -prices[pInd] + solve(prices,arr,pInd+1,aInd+1,dp);
            int notBuy = solve(prices,arr,pInd+1,aInd,dp);
            arr[aInd] = Math.max(buy,notBuy);
        }else{
            int sell = prices[pInd] + solve(prices,arr,pInd+1,aInd+1,dp);
            int notSell = solve(prices,arr,pInd+1,aInd,dp);
            arr[aInd] = Math.max(sell,notSell);
        }

        dp[pInd][aInd] = arr[aInd];
        return arr[aInd] ;
    }


//----------------------------------------------Tabulation of 2nd approach-----------------------------------------------
    public int maxProfitTabu2(int k, int[] prices) {
        int[][] dp = new int[prices.length + 1][k*2 + 1];

        for (int i = prices.length-1; i >= 0; i--) {
            for (int j = dp[0].length-2; j >=0; j--) {
                if (j % 2 == 0) { // sell
                    int buy = -prices[i] + dp[i+1][j+1];
                    int notBuy = dp[i+1][j];
                    dp[i][j] = Math.max(buy, notBuy);
                } else {
                    int sell = prices[i] + dp[i+1][j+1];
                    int notSell = dp[i+1][j];
                    dp[i][j] = Math.max(sell, notSell);
                }
            }
        }

        return dp[0][0];
    }


//------------------------------------------------Tabulation + Optimized ---------------------------------------------------
    public static int maxProfitTabuOp(int k, int[] prices) {
        int[] dp = new int[k*2 + 1];

        for (int i = prices.length-1; i >= 0; i--) {
            int[] currDp = new int[dp.length];
            for (int j = dp.length-2; j >=0; j--) {
                if (j % 2 == 0) { // sell
                    int buy = -prices[i] + dp[j+1];
                    int notBuy = dp[j];
                    currDp[j] = Math.max(buy, notBuy);
                } else {
                    int sell = prices[i] + dp[j+1];
                    int notSell = dp[j];
                    currDp[j] = Math.max(sell, notSell);
                }
            }
            dp = currDp.clone();
        }

        return dp[0];
    }

}
