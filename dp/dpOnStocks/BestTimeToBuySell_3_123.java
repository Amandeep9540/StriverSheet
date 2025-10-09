package dp.dpOnStocks;

public class BestTimeToBuySell_3_123 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println("max Profit "+ maxProfitWDP(prices));
    }

//--------------------------------------------------Memoization--------------------------------------------------------
    public static int maxProfitMemo(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[i].length;j++){
                java.util.Arrays.fill(dp[i][j],-1);
            }
        return solve(prices,0,1,2,dp);
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


//-----------------------------------------------------Tabulation-------------------------------------------------------
    public static int maxProfitTabu(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        for(int index =prices.length-1;index >= 0;index--){
            for(int canBuy =0;canBuy <=1 ;canBuy++){
                for(int cap=1;cap<=2;cap++){
                    int take = 0,notTake = 0;
                    if(canBuy == 1 ){
                        take = -prices[index] + dp[index+1][0][cap];
                        notTake = 0 + dp[index+1][1][cap];
                    }else{
                        take = prices[index] + dp[index+1][1][cap-1];
                        notTake = 0 + dp[index+1][0][cap];
                    }
                    dp[index][canBuy][cap] = Math.max(take,notTake);
                }
            }
        }
        return dp[0][1][2];
    }



//-------------------------------------------------without DP-----------------------------------------------------------
    public static int maxProfitWDP(int[] prices) {
        int fbp = Integer.MAX_VALUE,fsp = 0;
        int sbp = Integer.MAX_VALUE,ssp = 0;
        for(int i=0;i<prices.length;i++){
            fbp = Math.min(fbp,prices[i]);
            fsp = Math.max(fsp,prices[i] - fbp);
            sbp = Math.min(sbp,prices[i]-fsp);
            ssp = Math.max(ssp,prices[i] - sbp);
        }
        return ssp;
    }

}
