package dp.dpOnPartitions;
import java.util.*;

public class PalindromePartitioningII_132 {
    public static void main(String[] args) {
        System.out.println("Min partition required -- "+minCutTabu("aab"));
    }

//------------------------------------------------Memoization------------------------------------------------------
    public static int minCutMemo(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return solve(s,0,s.length(),dp);
    }
    public static int solve(String str,int i,int j,int[][] dp){
        if(i > j) return 0;
        if(j-i == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int minPartitions = Integer.MAX_VALUE;
        if(isPalindrone(str,i,j-1)) return 0;
        for(int k=i;k<j;k++){
            if(isPalindrone(str,i,k)){
                int cut = 1 + solve(str,k+1,j,dp);
                minPartitions = Math.min(cut,minPartitions);
            }
        }
        dp[i][j] = minPartitions;
        return minPartitions;
    }

    public static boolean isPalindrone(String str,int start,int end){
        if(end == start) return true; // only one element
        while(end > start){
            if(str.charAt(end) != str.charAt(start)) return false;
            end--;
            start++;
        }
        return true;
    }

//------------------------------------------------------------Tabulation-----------------------------------------------
    public static int minCutTabu(String str) {
        int[] dp = new int[str.length()+1];

        for(int i=str.length()-2;i>=0;i--){
            if(isPalindrone(str,i,str.length()-1)) continue;
            int minPartitions = Integer.MAX_VALUE;
            for(int k=i;k<str.length();k++){
                if(isPalindrone(str,i,k)){
                    int cut = 1 + dp[k+1];
                    minPartitions = Math.min(cut,minPartitions);
                }
            }
            dp[i] = minPartitions;
        }
        return dp[0];
    }
}
