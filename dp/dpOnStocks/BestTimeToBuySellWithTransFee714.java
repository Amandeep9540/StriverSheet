package dp.dpOnStocks;

public class BestTimeToBuySellWithTransFee714 {
    public static void main(String[] args) {
        int[] prices ={1,3,2,8,4,9};
        System.out.println("max Profit -- "+maxProfit(prices,2));
    }

    public static int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<dp.length;i++)
            java.util.Arrays.fill(dp[i],-1);
        return solve(prices,0,1,dp,fee);
    }

    public static int solve(int[] prices,int index,int canBuy,int[][] dp,int fee){
        //base case
        if(index >= prices.length)
            return 0;

        int take = 0,notTake = 0;
        if(dp[index][canBuy] != -1) return dp[index][canBuy];
        if(canBuy == 1 ){
            take = -prices[index] + solve(prices,index+1,0,dp,fee);
            notTake = 0 + solve(prices,index+1,1,dp,fee);
        }else{
            take = (prices[index]-fee) + solve(prices,index+1,1,dp,fee);
            notTake = 0 + solve(prices,index+1,0,dp,fee);
        }
        dp[index][canBuy] = Math.max(take,notTake);
        return dp[index][canBuy];
    }
}
