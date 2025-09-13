package dp.onSubsequence;

public class UnboundedKnapsack_Problem {
    public static void main(String[] args) {
        int[] val = {6, 1, 7, 7};
        int[] weight = {1, 3, 4, 5};
        int capacity = 8;
        int maxProfit = knapSackOpimizedTabulation(val,weight,capacity);
        System.out.println("maxProfit is --" +maxProfit);
    }


    //--------------------------------------------Memoization---------------------------------------------------------------

    static int knapSackMemoization(int val[], int wt[], int capacity) {
        int[][] dp = new int[val.length][capacity+1];
        for(int i=0;i<dp.length;i++){
            java.util.Arrays.fill(dp[i],-1);
        }
        return knapSack(val,val.length-1,wt,capacity,dp);
    }

    static int knapSack(int val[],int index, int wt[], int capacity,int[][] dp) {
        if(index == 0){
            if(wt[0] <= capacity)
                return (capacity/wt[0]) * val[0];
            return 0;
        }
        if(dp[index][capacity] != -1) return dp[index][capacity];
        int notTake = 0 + knapSack(val,index-1,wt,capacity,dp);
        int take = 0;
        if(wt[index] <= capacity)
            take = val[index] + knapSack(val,index,wt,capacity-wt[index],dp);

        dp[index][capacity] = Math.max(notTake,take);
        return dp[index][capacity];
    }


    //---------------------------------------Tabulation-----------------------------------------------------------------

    static int knapSackTabulation(int val[], int wt[], int capacity) {
        int[][] dp = new int[val.length][capacity+1];
        //base case -- if the index is 0, then
        for(int i=wt[0];i<dp[0].length;i++){
            dp[0][i] = (i/wt[0]) * val[0];
        }
        //actual
        for(int i = 1;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(wt[i] <= j)
                    take = val[i] + dp[i][j-wt[i]];
                dp[i][j] = Math.max(take,notTake);
            }
        }
        return dp[dp.length-1][capacity];
    }


    //-------------------------------Tabulation + Space Optimization-----------------------------------------------------

    static int knapSackOpimizedTabulation(int val[], int wt[], int capacity) {
        int[] dp = new int[capacity+1];
        int[] dp2 = new int[capacity+1];
        //base case -- if the index is 0, then
        for(int i=wt[0];i<dp.length;i++){
            dp[i] = (i/wt[0]) * val[0];
        }
        if(val.length == 1) return dp[capacity];
        //actual
        for(int i = 1;i<val.length;i++){
            for(int j=0;j<dp.length;j++){
                int notTake = dp[j];
                int take = 0;
                if(wt[i] <= j)
                    take = val[i] + dp2[j-wt[i]];
                dp2[j] = Math.max(take,notTake);
            }
            dp = dp2.clone();
            if(i != val.length -1)
                dp2 = new int[capacity+1];
        }
        return dp2[capacity];
    }

}
