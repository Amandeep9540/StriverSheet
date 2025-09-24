package dp.dpOnString;

public class WildcardMatching44 {

    public static void main(String[] args) {
        String s1 = "cb";
        String s2 = "?b";
        System.out.println("is Match -- "+isMatchTabu(s1,s2));
    }

//---------------------------------------------------Memoization----------------------------------------------
    public static boolean isMatch(String str, String wildCard) {
        int[][] dp = new int[str.length()][wildCard.length()];
        for(int i=0;i<dp.length;i++)
            java.util.Arrays.fill(dp[i],-1);
        return isMatch(str,wildCard,str.length()-1,wildCard.length()-1,dp);
    }


    public static boolean isMatch(String str, String wildCard,int index1,int index2,int[][] dp) {
        if(index1 < 0 && index2 < 0) return true;
        if(index1 < 0 ){
            while(index2 >= 0){
                if(wildCard.charAt(index2) != '*') return false;
                index2--;
            }
            return true;
        }
        if(index2 < 0) return false;


        //exploring possiblities
        boolean result = false;

        if(dp[index1][index2] != -1) return dp[index1][index2] == 0 ? false : true;
        if(str.charAt(index1) == wildCard.charAt(index2)){
            result = isMatch(str,wildCard,index1-1,index2-1,dp);
        }else if(wildCard.charAt(index2) == '?'){
            result = isMatch(str,wildCard,index1-1,index2-1,dp);
        }else if(wildCard.charAt(index2) == '*'){
            result = isMatch(str,wildCard,index1-1,index2-1,dp) ||
                    isMatch(str,wildCard,index1-1,index2,dp) ||
                    isMatch(str,wildCard,index1,index2-1,dp);
        }else{
            result = false;
        }
        dp[index1][index2] = result ? 1 : 0;
        return result;
    }


//-------------------------------------------------------Tabulation---------------------------------------------------
    public static boolean isMatchTabu(String str, String wildCard) {
        int n = str.length();
        int m = wildCard.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        // Base case: pattern with '*' can match empty string
        for (int j = 1; j <= m; j++) {
            if (wildCard.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (wildCard.charAt(j - 1) == str.charAt(i - 1) || wildCard.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (wildCard.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    // * as empty   OR   * as one/more chars
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

}
