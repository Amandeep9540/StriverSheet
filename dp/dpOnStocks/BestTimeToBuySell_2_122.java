package dp.dpOnStocks;

import java.util.concurrent.CompletableFuture;

public class BestTimeToBuySell_2_122 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("maxProfit == "+maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = prices[0];
        for(int i=1;i<prices.length;i++){
            if(buyPrice > prices[i]){
                buyPrice = prices[i];
            }else{
                profit += prices[i] - buyPrice;
                buyPrice = prices[i];
            }
        }
        return profit;
    }
}
