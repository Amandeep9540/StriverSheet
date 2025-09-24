package dp.dpOnString;

public class EditDistance72 {

    public static void main(String[] args) {
        String st1 = "horse";
        String st2 = "ros";
        System.out.println("Min Op --" +minDistanceOPTabu(st1,st2));
    }

//--------------------------------------------------Memoization----------------------------------------------------
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i=0;i<dp.length;i++)
            java.util.Arrays.fill(dp[i],-1);
        return minDistance(word1,word2,word1.length()-1,word2.length()-1,dp);
    }

    public static int minDistance(String word1, String word2,int index1,int index2,int[][] dp) {
        if(index2 < 0) return index1 + 1;
        if(index1 < 0 ) return index2 + 1;

        if(dp[index1][index2] != -1) return dp[index1][index2];
        if(word1.charAt(index1) == word2.charAt(index2)){
            dp[index1][index2] = minDistance(word1,word2,index1-1,index2-1,dp);
        }else{
            int replace = 1 + minDistance(word1,word2,index1-1,index2-1,dp);
            int delete = 1 + minDistance(word1,word2,index1-1,index2,dp);
            int insert = 1 + minDistance(word1,word2,index1,index2-1,dp);
            dp[index1][index2] = Math.min(replace,Math.min(delete,insert));
        }
        return dp[index1][index2];
    }


//------------------------------------------------------Tabulation--------------------------------------------------------
    public static int minDistanceTabu(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //filling the row
        for(int i=1;i<dp[0].length;i++){
            dp[0][i] = i;
        }
        //filling the col
        for(int i=1;i<dp.length;i++){
            dp[i][0] = i;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int replace = 1 + dp[i-1][j-1];
                    int delete = 1 + dp[i-1][j];
                    int insert = 1 + dp[i][j-1];
                    dp[i][j] = Math.min(replace,Math.min(delete,insert));
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }


//------------------------------------------------------Tabulation + Optimisation -----------------------------------------
    public static int minDistanceOPTabu(String word1, String word2) {
        int[] dp = new int[word2.length()+1];
        //filling the row
        for(int i=1;i<dp.length;i++){
            dp[i] = i;
        }

        for(int i=1;i<=word1.length();i++){
            int[] currDp = new int[word2.length()+1];
            currDp[0] = i;
            for(int j=1;j<dp.length;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    currDp[j] = dp[j-1];
                }else{
                    int replace = 1 + dp[j-1];
                    int delete = 1 + dp[j];
                    int insert = 1 + currDp[j-1];
                    currDp[j] = Math.min(replace,Math.min(delete,insert));
                }
            }
            dp = currDp.clone();
        }

        return dp[dp.length-1];
    }

}
