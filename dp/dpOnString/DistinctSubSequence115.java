package dp.dpOnString;

public class DistinctSubSequence115 {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println("sub sequence count -- "+numDistinctOPTabu(s,t));
    }


//--------------------------------------Memoization------------------------------------------------------
    public int numDistinctMemo(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<dp.length;i++)
            java.util.Arrays.fill(dp[i],-1);
        return numDistinct(s,t,s.length(),t.length(),dp);
    }

    public static int numDistinct(String str1,String str2,int index1,int index2,int[][] dp){
        if(index2 <= 0) return 1;
        if(index1 <= 0) return 0;

        if(dp[index1][index2] != -1) return dp[index1][index2];

        //if char is matching
        if(str1.charAt(index1-1) == str2.charAt(index2-1)){
            // i have two options i can take both and i didn't take
            dp[index1][index2] = numDistinct(str1,str2,index1-1,index2-1,dp) + numDistinct(str1,str2,index1-1,index2,dp);
        }else{
            // i will the index1 and index2 asit same;
            dp[index1][index2] = numDistinct(str1,str2,index1-1,index2,dp);
        }
        return dp[index1][index2];
    }



//-------------------------------------------------Tabulation------------------------------------------------------
    public static int numDistinctTabu(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<dp.length;i++)
            dp[i][0] = 1;

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }



//-----------------------------------------------------Tabulation + Optimised-----------------------------------------------
    public static int numDistinctOPTabu(String s, String t) {
        int[] dp = new int[t.length()+1];
        dp[0] = 1;

        for(int i=1;i<s.length()+1;i++){
            int[] currDP = new int[t.length()+1];
            currDP[0] = 1;
            for(int j=1;j<dp.length;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    currDP[j] = dp[j-1] + dp[j];
                }else{
                    currDP[j] = dp[j];
                }
            }
            dp = currDP.clone();
        }
        return dp[dp.length-1];
    }
}
