package dp.onSubsequence;

public class RodCutting_GFG {
    public static void main(String[] args) {
            int[] price ={1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("max profix -- "+cutRodMemo(price));
    }

//-------------------------------------------Memoization------------------------------------------------------------------
    public static int cutRodMemo(int[] price) {
        int rodLength = price.length;
        int[][] dp = new int[price.length][rodLength+1];
        for(int i=0;i<dp.length;i++)
            java.util.Arrays.fill(dp[i],-1);
        return solve(price,price.length-1,rodLength,dp);
    }

    public static int solve(int[] price, int index, int length,int[][] dp){
        if(index == 0){
            return price[0] * length;
        }
        if(length == 0) return 0;

        if(dp[index][length] != -1) return dp[index][length];
        int notTake = solve(price,index-1,length,dp);
        int take = 0;
        if(length >= (index+1))
            take = price[index] + solve(price,index,length-(index+1),dp);
        dp[index][length] = Math.max(take,notTake);
        return dp[index][length];
    }
//---------------------------------------------------Tabulation--------------------------------------------------------
    public static int cutRodTabu(int[] price) {
        int rodLength = price.length;
        int[][] dp = new int[price.length][rodLength+1];
        //base case -- if the price is only aviable for index 1 then
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = price[0] * i;
        }

        for(int i=1;i<price.length;i++){
            for(int j=0;j<dp[i].length;j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(j >= (i+1))
                    take = price[i] + dp[i][j-(i+1)];
                dp[i][j] = Math.max(notTake,take);
            }
        }
        return dp[dp.length-1][rodLength];
    }


//-------------------------------------------Tabulation + Space Optimisation----------------------------------------------
    public int cutRodTabuOP(int[] price) {
        int rodLength = price.length;
        int[] prevDp = new int[rodLength+1];
        //base case -- if the price is only aviable for index 1 then
        for(int i=0;i<prevDp.length;i++){
            prevDp[i] = price[0] * i;
        }
        int[] newDp = new int[rodLength+1];
        for(int i=1;i<price.length;i++){
            for(int j=0;j<prevDp.length;j++){
                int notTake = prevDp[j];
                int take = 0;
                if(j >= (i+1))
                    take = price[i] + newDp[j-(i+1)];
                newDp[j] = Math.max(notTake,take);
            }
            prevDp = newDp.clone();
            newDp = new int[rodLength+1];
        }
        return prevDp[rodLength];
    }


}
