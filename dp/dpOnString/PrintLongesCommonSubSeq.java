package dp.dpOnString;

public class PrintLongesCommonSubSeq {
    public static StringBuilder result = new StringBuilder();
    public static void main(String[] args) {
        String text1 = "acet";
        String text2 = "accuht";
        longestCommonSubsequence(text1,text2);
        System.out.println("longest common subsequence from recursion -- "+result.reverse().toString());
        String result = longestCommonSubsequenceTabu(text1,text2);
        System.out.println("longes subseq from tabu -- "+result);
    }

/*-------------------------------------------------Recursion-------------------------------------------------------------*/
    public static void longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        getMaxSequenceLent(text1,text2,text1.length()-1,text2.length()-1,dp,new StringBuilder());

    }

    public static void getMaxSequenceLent(String text1,String text2,int ind1, int ind2,int[][] dp,StringBuilder sb){
        if(ind1 < 0 || ind2 < 0) {
            sb = new StringBuilder();
            return;
        }

        if(text1.charAt(ind1) == text2.charAt(ind2)){
            sb.append(text1.charAt(ind1));
            if(result.length() < sb.length())
                result = new StringBuilder(sb);
            getMaxSequenceLent(text1,text2,ind1-1,ind2-1,dp,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        //not match case
        getMaxSequenceLent(text1,text2,ind1,ind2-1,dp,sb);
        getMaxSequenceLent(text1,text2,ind1-1,ind2,dp,sb);
    }


/*------------------------------------Tabulation---------------------------------*/
    public static String longestCommonSubsequenceTabu(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<dp.length;i++)
            java.util.Arrays.fill(dp[i],-1);
        int len = getMaxSequenceLent(text1,text2,text1.length()-1,text2.length()-1,dp);
        char[] ansArr = new char[len];
        int ansEnd = len-1;
        int row = dp.length-1;
        int col = dp[row].length -1;
        while(row > 0 || col > 0){
            int value = dp[row][col];
            if(value == 0) break;
            if(text1.charAt(row-1) == text2.charAt(col-1)){
                //adding the curent char and move to row -1 and col-1
                ansArr[ansEnd--] = text1.charAt(row-1);
                row--;col--;
            }else{
                //check the row-1 or col-1 is greater whichever is greater go to that index;
                if(dp[row-1][col] > dp[row][col-1])
                    row--;
                else
                    col--;
            }
        }
        return new String(ansArr);
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
}
