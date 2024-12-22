package Arrays.Medium;

public class BestTimeToBuyAndSellStock121 {
    public static void main(String[] args) {
        int maxProfit = maxProfit(new int[]{7,6,4,3,1});
        System.out.println("-- maxProfit is -- "+maxProfit);
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        int buyDay = 0;
        int sellDay = 0;

        for(int i=1;i<prices.length;i++){
                    //Allowed
             if(prices[i] > prices[sellDay]){
                 sellDay = i;
             }
             if(prices[i] < prices[buyDay]){
                 buyDay = i;
                 sellDay = i;
             }
             maxProfit = Math.max(maxProfit,prices[sellDay] - prices[buyDay]);
        }

        return maxProfit;
    }
}
