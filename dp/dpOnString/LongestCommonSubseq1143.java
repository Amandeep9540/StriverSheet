package dp.dpOnString;

import java.util.Arrays;

public class LongestCommonSubseq1143 {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("longes subseq is -- "+longestCommonSubsequenceTabu(text1,text2));
    }

//--------------------------------------------Memoization------------------------------------------------------
    public static int longestCommonSubsequenceMemo(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return getMaxSequenceLent(text1,text2,text1.length()-1,text2.length()-1,dp);
    }

    public static int getMaxSequenceLent(String text1,String text2,int ind1, int ind2,int[][] dp){
        if(ind1 < 0 || ind2 < 0) return 0;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(text1.charAt(ind1) == text2.charAt(ind2)){
            dp[ind1][ind2] =  1 + getMaxSequenceLent(text1,text2,ind1-1,ind2-1,dp);
            return dp[ind1][ind2];
        }
        //not match case
        dp[ind1][ind2] = Math.max(getMaxSequenceLent(text1,text2,ind1,ind2-1,dp),getMaxSequenceLent(text1,text2,ind1-1,ind2,dp));
        return dp[ind1][ind2];
    }

/*------------------------------------------------Tabulation----------------------------------------------------*/
    public static int longestCommonSubsequenceTabu(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        //base case
        //Writing the base case if the row is zero and col is zero
        // for(int i=0;i<dp.length;i++)
        //     dp[i][0] = 0;
        /*Default the value assign to zero */
        // for(int i=0;i<dp[0].length;i++)
        //     dp[0][i] = 0;

        for(int row = 1;row<dp.length;row++){
            for(int col = 1;col<dp[row].length;col++){
                //if the char is matching
                if(text1.charAt(row-1) == text2.charAt(col-1)){
                    dp[row][col] =  1 + dp[row-1][col-1];
                }else{ // char is not matching
                    dp[row][col] = Math.max(dp[row][col-1],dp[row-1][col]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

/*--------------------------------------------Tabulation+Space Optimisation-------------------------------*/
    public static int longestCommonSubsequenceOptimizedTabu(String text1, String text2) {
        int[] prevDp = new int[text2.length()+1];
        int[] currDp = new int[text2.length()+1];
        for(int row = 1;row<=text1.length();row++){
            for(int col = 1;col<prevDp.length;col++){
                //if the char is matching
                if(text1.charAt(row-1) == text2.charAt(col-1)){
                    currDp[col] =  1 + prevDp[col-1];
                }else{ // char is not matching
                    currDp[col] = Math.max(currDp[col-1],prevDp[col]);
                }
            }
            prevDp = currDp.clone();
        }
        return prevDp[text2.length()];
    }
}
