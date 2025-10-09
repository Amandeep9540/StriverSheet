package dp.dpOnStocks;

public class BestTimeToBuySellWithCollDown309 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println("max profit -- "+maxProfitTabu(prices));
    }

//----------------------------------------------------------Memoization--------------------------------------------------
    public static int maxProfitMemo(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<dp.length;i++)
            java.util.Arrays.fill(dp[i],-1);
        return solve(prices,0,1,dp);
    }
    public static int solve(int[] prices,int index,int canBuy,int[][] dp){
        //base case
        if(index >= prices.length)
            return 0;

        int take = 0,notTake = 0;
        if(dp[index][canBuy] != -1) return dp[index][canBuy];
        if(canBuy == 1 ){
            take = -prices[index] + solve(prices,index+1,0,dp);
            notTake = 0 + solve(prices,index+1,1,dp);
        }else{
            take = prices[index] + solve(prices,index+2,1,dp);// cooldown that's why we add the +2 one day cooldown
            notTake = 0 + solve(prices,index+1,0,dp);
        }
        dp[index][canBuy] = Math.max(take,notTake);
        return dp[index][canBuy];
    }




//-----------------------------------------------------Tabulation--------------------------------------------------------
    public static int maxProfitTabu(int[] prices) {
        int[][] dp = new int[prices.length+2][2];
        for(int index =prices.length-1;index >= 0;index--){
            for(int canBuy =0;canBuy <=1 ;canBuy++){
                int take = 0,notTake = 0;
                if(canBuy == 1 ){
                    take = -prices[index] + dp[index+1][0];
                    notTake = 0 + dp[index+1][1];
                }else{
                    take = prices[index] + dp[index+2][1];
                    notTake = 0 + dp[index+1][0];
                }
                dp[index][canBuy] = Math.max(take,notTake);
            }
        }
        return dp[0][1];
    }

}
