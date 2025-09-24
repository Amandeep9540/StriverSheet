package dp.dpOnString;

public class ShortSupersequence1092 {
    public static void main(String[] args) {
        String str1 = "groot";
        String str2 = "brute";
        System.out.println("super sequence is -- "+shortestCommonSupersequence(str1,str2));
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = longestCommonSubsequenceTabu(str1,str2);
        int row = dp.length-1, col = dp[0].length - 1;
        StringBuilder sb = new StringBuilder();
        while(row >= 1 && col >= 1){
            if(str1.charAt(row-1) == str2.charAt(col-1)){
                sb.append(str1.charAt(row-1));
                row--;col--;
            }else{
                if(dp[row][col-1] > dp[row-1][col]){
                    sb.append(str2.charAt(col-1));
                    col--;
                }else{
                    sb.append(str1.charAt(row-1));
                    row--;

                }
            }
        }
        while (row >= 1) {
            sb.append(str1.charAt(row - 1));
            row--;
        }
        while (col >= 1) {
            sb.append(str2.charAt(col - 1));
            col--;
        }

        return sb.reverse().toString();
    }

    public static int[][] longestCommonSubsequenceTabu(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
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
        return dp;
    }
}
