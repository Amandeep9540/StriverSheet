package dp.dpOnString;

public class LongestCommonSubString_GFG {
    public static void main(String[] args) {
        String text1 = "ABCDEG";
        String text2 = "ABCYEYG";
        System.out.println("longest length -- "+longestCommonSubstrRecursion(text1,text2));
    }

/*-------------------------------------------Tabulation-----------------------------------------------*/
    public static int longestCommonSubstr(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int max = 0;

        for(int row = 1;row<dp.length;row++){
            for(int col = 1;col<dp[row].length;col++){
                //if the char is matching
                if(text1.charAt(row-1) == text2.charAt(col-1)){
                    dp[row][col] =  1 + dp[row-1][col-1];
                    max = Math.max(max,dp[row][col]);
                }else{ // char is not matching
                    dp[row][col] = 0;
                }
            }
        }
        return max;
    }


/*----------------------------------------------Recursion-----------------------------------------------------*/
        public static int Max = 0;
        public static int longestCommonSubstrRecursion(String text1, String text2) {
            int[][] dp = new int[text1.length()+1][text2.length()+1];
            for(int i=0;i<dp.length;i++)
                java.util.Arrays.fill(dp[i],-1);
            getMaxSequenceLent(text1,text2,text1.length()-1,text2.length()-1,dp);
            return Max;
        }


        public static int getMaxSequenceLent(String text1,String text2,int ind1, int ind2,int[][] dp){

            if(ind1 < 0 || ind2 < 0) return 0;

            if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

            if(text1.charAt(ind1) == text2.charAt(ind2)){
                dp[ind1][ind2] = 1 + getMaxSequenceLent(text1,text2,ind1-1,ind2-1,dp);
                Max = Math.max(Max,dp[ind1][ind2]);


            }else{
                dp[ind1][ind2] = 0;
            }
            getMaxSequenceLent(text1,text2,ind1,ind2-1,dp);
            getMaxSequenceLent(text1,text2,ind1-1,ind2,dp);
            return dp[ind1][ind2];

        }
}

