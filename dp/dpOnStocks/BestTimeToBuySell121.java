package dp.dpOnStocks;

public class BestTimeToBuySell121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("maxProfit == "+maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(buyPrice > prices[i])
                buyPrice = prices[i];
            else
                profit = Math.max(profit,prices[i]-buyPrice);
        }
        return profit;
    }
}
