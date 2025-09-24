package dp.dpOnString;

public class LongestPlaindeoneSubSeq516 {
    public static void main(String[] args) {
        int len = longestPalindromeSubseq("cbbd");
        System.out.println("--"+len);
    }
    public static int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        return longestCommonSubsequence(s,sb.reverse().toString());
    }

    public static int longestCommonSubsequence(String text1, String text2) {
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
